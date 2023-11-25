package amazonPolly1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import com.amazonaws.services.polly.model.Voice;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class ConvertTextToVoice {
	private final AmazonPolly polly;
	private final Voice voice;
	
	private static final String ADITI="Aditi";
	private static final String EMMA="Emma";
	
	private static final String SAMPLE="Congratulations. You have sucessfully built this working demo of Amazon"+"Polly in java.";
	
	
	public ConvertTextToVoice() {
		//Create an Amazon polly client in specific region
		polly=AmazonPollyClientBuilder.standard().withRegion(Regions.AP_SOUTH_1).build();
		
		//Create describe voices request.
		DescribeVoicesRequest describeVoiceRequest=new DescribeVoicesRequest();
		
		//Synchronously ask Amazon Polly to describe available TTS voices.
		DescribeVoicesResult describeVoicesResult =polly.describeVoices(describeVoiceRequest);
		voice=describeVoicesResult.getVoices().get(0);
		  
	}
	
	public InputStream synthesize(String text, OutputFormat format) {
		SynthesizeSpeechRequest synthReq = new SynthesizeSpeechRequest().withText(text).withVoiceId(voice.getId()).withOutputFormat(format);
		SynthesizeSpeechResult synthRes=polly.synthesizeSpeech(synthReq);
		
		return synthRes.getAudioStream();
	}
	
	 public static void main(String[] args) throws JavaLayerException, IOException {
		 FileInputStream fis=new FileInputStream(new File("./src/test/resources/testData/configuration.properties"));
		 Properties property=new Properties();
		 property.load(fis);
		// AWS Credentials
	        String accessKey = property.getProperty("Secretkey");
	        String secretKey = property.getProperty("Accesskey");

	    // Initialize Amazon Polly client
	        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		//Create the test class
		 ConvertTextToVoice convertTextToVoice=new ConvertTextToVoice();
		 
		//get the audio stream
		  InputStream speechStream = convertTextToVoice.synthesize(ADITI, OutputFormat.Mp3);
		  
		//Create an Mp3 player
		  AdvancedPlayer player=new AdvancedPlayer(speechStream,javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
		  player.setPlayBackListener(new PlaybackListener() {
				@Override
				public void playbackStarted(PlaybackEvent evt) {
					System.out.println("Playback started");
					System.out.println(SAMPLE);
				}
				
				@Override
				public void playbackFinished(PlaybackEvent evt) {
					System.out.println("Playback finished");
				}
			});
			
			
			// play it!
			player.play();
	}
} 