package AutoSetup;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	static WebDriver driver;

	public ScreenShot(WebDriver driver) {
		ScreenShot.driver = driver;
	}

	public static void TakeSS(String file)

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinatiom = new File(
				"C:/Users/CG-DTE/eclipse-workspace/OHRMTestNGM/src/test/java/Test_Result_ScreenShot/" + file + ".png");
		try {
			FileUtils.copyFile(source, destinatiom);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
