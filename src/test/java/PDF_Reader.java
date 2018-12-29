import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDF_Reader 
{
	@Test
	public void pdfReaderTest() throws IOException
	{
		
		/*System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		//driver.get("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		
		String pageURL=driver.getCurrentUrl();
		URL url=new URL(pageURL);*/
		
		URL url=new URL("file:///C:/Users/Manohar/Downloads/1546099104655bXXcT80FkNULLaeJ.pdf");
		//URL url=new URL("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		InputStream is=url.openStream();
		BufferedInputStream fileparse=new BufferedInputStream(is);
		PDDocument document=null;
		
		document=PDDocument.load(fileparse);
		String pdfcontent=new PDFTextStripper().getText(document);
		System.out.println(pdfcontent);
		
		/*Assert.assertTrue(pdfcontent.contains("Personal Information"));
		Assert.assertTrue(pdfcontent.contains("City State ZIP Code"));
		Assert.assertTrue(pdfcontent.contains("Job Information"));*/
		
		Assert.assertTrue(pdfcontent.contains("Commission of"));
	}
}
