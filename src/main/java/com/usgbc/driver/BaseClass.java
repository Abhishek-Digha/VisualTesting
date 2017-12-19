package com.usgbc.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;
import org.im4java.process.StandardStream;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;




public class BaseClass {
	
	public static WebDriver driver;
	public static XlsReader data;
	public Properties prop;
	public JavascriptExecutor js;
	public String testName;
	public String testScreenShotDirectory;
	public String url ="https://new.usgbc.org/";
    public static String currentDir = System.getProperty("user.dir");
	public String parentScreenShotsLocation = currentDir + "\\ScreenShots\\";
	public String parentDifferencesLocation = currentDir + "\\Differences\\";
	public static String baselineScreenShotPath;
	public static String actualScreenShotPath;
	public static String differenceScreenShotPath;
	public static File baselineImageFile;
	public static File actualImageFile;
	public static File differenceImageFile;
	public static File differenceFileForParent;


	
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browserName","environment"})
	public void setup(String browserName,String environment) throws InterruptedException, IOException{
		 js = (JavascriptExecutor) driver;
	     //Create screenshot and differences folders if they are not exist
	     createFolder(parentScreenShotsLocation);
	     createFolder(parentDifferencesLocation);
	     //Clean Differences Root Folder
	     File differencesFolder = new File(parentDifferencesLocation);
	     FileUtils.cleanDirectory(differencesFolder);

		//Excel path configuration
		//data= new XlsReader(System.getProperty("user.dir")+"/ArcTest.xlsx"); 
		
		 
		//selecting browser based on parameter from TestNG.xml
		if(browserName.equalsIgnoreCase("firefox")){
			
			FirefoxProfile profile = new FirefoxProfile();
			   profile.setPreference("browser.download.folderList", 2);
			   profile.setPreference("browser.download.dir", System.getProperty("user.dir") +"/Downloads/");
			   profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			   profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
			   profile.setPreference("browser.download.manager.showWhenStarting", false);
			   profile.setPreference("browser.download.manager.focusWhenStarting", false);  
			   profile.setPreference("browser.download.useDownloadDir", true);
			   profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			   profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			   profile.setPreference("browser.download.manager.closeWhenDone", true);
			   profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			   profile.setPreference("browser.download.manager.useWindow", false);
			   profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			   profile.setPreference("pdfjs.disabled", true);
			         
			   driver = new FirefoxDriver(profile);
		
		}
		else if(browserName.equalsIgnoreCase("chrome")){

			//work with chrome
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe");
			/* HashMap<String, Object> images = new HashMap<String, Object>(); 
		        images.put("images", 2); 

		        HashMap<String, Object> prefs = new HashMap<String, Object>(); 
		        prefs.put("profile.default_content_setting_values", images);


		        ChromeOptions options =new ChromeOptions(); 
		        options.setExperimentalOption("prefs", prefs); 

		        DesiredCapabilities chromeCaps = DesiredCapabilities.chrome(); 
		        chromeCaps.setCapability(ChromeOptions.CAPABILITY, options); */

		       
			driver = new ChromeDriver();	
		}
		
		else if(browserName.equalsIgnoreCase("opera")){
			//opera
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"/DriverFiles/operadriver.exe");
			driver = new OperaDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie")){

			//work with Internet explorer
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/DriverFiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("safari")){

			//work with Internet explorer
			System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			driver = new SafariDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("phantom")){

			File src = new File (System.getProperty("user.dir")+"\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		   // driver = new PhantomJSDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("htmlunit")){

		    driver = new HtmlUnitDriver();
		    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
		   /* Logger logger = Logger.getLogger("");
		    logger.setLevel(Level.OFF); */
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");

		prop.load(file);
		String qaurl=prop.getProperty("ENV_QA");
		String stageurl=prop.getProperty("ENV_STAGING");
		String productionurl=prop.getProperty("ENV_PRODUCTION");
		
		if(environment.equalsIgnoreCase("qa")){
			
			driver.get(qaurl);
			
		}
		else if(environment.equalsIgnoreCase("staging")){
			System.out.println(stageurl);
			driver.get(stageurl);

		}
		else if(environment.equalsIgnoreCase("production")){
			
			driver.get(productionurl);
			
		}
		Thread.sleep(5000);	
		
	
	}
	
	
		@BeforeMethod
	    public void setupTestMethod (Method method) {
	        //Get the test name to create a specific screenshot folder for each test.
        testName = method.getName();
        System.out.println("Test Name: " + testName + "\n");

        //Create a specific directory for a test
        testScreenShotDirectory = parentScreenShotsLocation + testName + "\\";
        createFolder(testScreenShotDirectory);

        //Declare element screenshot paths
        //Concatenate with the test name.
        declareScreenShotPaths(testName+"_Baseline.png", testName+"_Actual.png", testName + "_Diff.png");
		}
	
		//Create Folder Method
	    public void createFolder (String path) {
	        File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	            if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	            } else {
	                System.out.println("Failed to create directory: " + path);
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
	    }

		
	    public long height() {
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	long value = (long) js.executeScript("return document.documentElement.clientWidth");
	    	System.out.println(value);
	    	return value;
	    }
	    
	    
	    public long width() {
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	long value = (long) js.executeScript("return document.body.clientHeight");
	    	System.out.println(value);
	    	return value;
	    }
		//Take screenshot with Ashot
		public static Screenshot takeScreenshot () throws IOException {
			   System.out.println("Hi Test 1");
			   TakesScreenshot ts = (TakesScreenshot)driver;
		   	   File Source = ts.getScreenshotAs(OutputType.FILE);
		   	   String Dest = currentDir + "\\Differences\\ "+ "Abhi.png";
		   	   File Destination = new File(Dest);
		   	   FileUtils.copyFile(Source, Destination);
			   //Take screenshot with Ashot
		       Screenshot elementScreenShot = new AShot()
		        		.coordsProvider(new WebDriverCoordsProvider())
		    		    .takeScreenshot(driver); 
		        //Print element size
		        String size = "Height: " + elementScreenShot.getImage().getHeight() + "\n" +
		                "Width: " + elementScreenShot.getImage().getWidth() + "\n";
		        System.out.print("Size: " + size);
		        return elementScreenShot;
		    }
		
		
		  //Write
	  
	   	
		//Screenshot paths
		public void declareScreenShotPaths (String baseline, String actual, String diff) {
		    //BaseLine, Actual, Difference Photo Paths
		    baselineScreenShotPath = testScreenShotDirectory + baseline;
		    actualScreenShotPath = testScreenShotDirectory + actual;
		    differenceScreenShotPath = testScreenShotDirectory + diff;
		
		    //BaseLine, Actual Photo Files
		    baselineImageFile = new File(baselineScreenShotPath);
		    actualImageFile = new File(actualScreenShotPath);
		    differenceImageFile = new File (differenceScreenShotPath);
		
		    //For copying difference to the parent Difference Folder
		    differenceFileForParent = new File (parentDifferencesLocation + diff);
		}
	
	
	    @AfterClass(alwaysRun = true)
		public void end(){	
			driver.quit();
		}
	}
