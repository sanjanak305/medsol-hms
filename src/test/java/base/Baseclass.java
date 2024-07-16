package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties data = new Properties();
	public static FileReader fr1;
	public static FileReader fr2;
	public static FileReader fr3;

	
	public WebDriver getdriver() {
		return driver;
	}
	
	public void setUp() throws IOException {
		if (driver == null) {
			String projectpath = System.getProperty("user.dir");
			fr1 = new FileReader(projectpath+"//src//test//resources//configFiles//config.properties");
			fr2 = new FileReader(projectpath+"//src//test//resources//configFiles//locators.properties");
			fr3 = new FileReader(projectpath + "//src//test//resources//testdata//data.txt");
			prop.load(fr1);
			loc.load(fr2);
			data.load(fr3);

		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("testurl"));
		String current_url = driver.getCurrentUrl();
		String expected_url = "https://medsolbuffer.in/login";
		Assert.assertEquals(current_url, expected_url);
		System.out.println("SetUp successful");
		
	}
	
	public void tearDown() {
		driver.close();
		System.out.println("Teardown successful");
	}
}
