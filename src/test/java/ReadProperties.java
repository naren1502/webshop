import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		Properties property=new Properties();
		
		FileInputStream fis=new FileInputStream(new File("./src/test/resources/testData/configuration.properties"));
		
		property.load(fis);
		
		String url = property.getProperty("Url");
		
		System.out.println(url);
		
		
	}

}
