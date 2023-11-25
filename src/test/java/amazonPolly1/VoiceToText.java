package amazonPolly1;

import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.TextType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.Voice;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class VoiceToText {
    private final AmazonPolly polly;
    private final Voice voice;

    private static final String SAMPLE = "Congratulations. You have successfully built this working demo of Amazon Polly in Java.";

    public VoiceToText(AmazonPolly polly, Voice voice) {
        this.polly = polly;
        this.voice = voice;
    }

    public InputStream synthesize(String text, OutputFormat format) {
        return polly.synthesizeSpeech(
                new SynthesizeSpeechRequest()
                        .withText(text)
                        .withVoiceId(voice.getId())
                        .withOutputFormat(format)
        ).getAudioStream();
    }

    public static void main(String[] args) throws JavaLayerException, IOException {
    	FileInputStream fis=new FileInputStream(new File("./src/test/resources/testData/configuration.properties"));
		 Properties property=new Properties();
		 property.load(fis);
		// AWS Credentials
	        String accessKey = property.getProperty("Secretkey");
	        String secretKey = property.getProperty("Accesskey");
        // Load AWS credentials from a secure source (e.g., environment variables)
//        String accessKey = System.getenv("AWS_ACCESS_KEY_ID");
//        String secretKey = System.getenv("AWS_SECRET_ACCESS_KEY");

        // Initialize Amazon Polly client
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonPolly polly = AmazonPollyClientBuilder.standard()
                .withRegion(Regions.AP_SOUTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        // Create describe voices request.
        DescribeVoicesRequest describeVoiceRequest = new DescribeVoicesRequest();

        // Synchronously ask Amazon Polly to describe available TTS voices.
        DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoiceRequest);
        Voice voice = describeVoicesResult.getVoices().get(0);

        // Create the test class
        VoiceToText convertTextToVoice = new VoiceToText(polly, voice);

        // Get the audio stream
        final InputStream speechStream = convertTextToVoice.synthesize(SAMPLE, OutputFormat.Mp3);

        // Create an MP3 player
        AdvancedPlayer player = new AdvancedPlayer(
                speechStream,
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
        );

        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackStarted(PlaybackEvent evt) {
                System.out.println("Playback started");
                System.out.println(SAMPLE);
            }

            @Override
            public void playbackFinished(PlaybackEvent evt) {
                System.out.println("Playback finished");
                // Close the InputStream to release resources
                try {
                    speechStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Play it!
        player.play();
    }
}
