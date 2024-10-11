package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;

public  class ListenersAuto extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution){
        System.out.println("------------------Starting Execution------------------");
    }

    public void onFinish(ITestContext execution){
        System.out.println("------------------Execution Ended------------------");
    }

    public void onTestStart(ITestResult test){
        System.out.println("------------------Starting Test: "+test.getName()+"------------------");
        if (getData("PlatformNameOfTest").equalsIgnoreCase("web")) {
            System.out.println("Tester Name: \t" + test.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ExecutionData.class).name());
            System.out.println("Test Category: \t" + test.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ExecutionData.class).category());
        }
    }

    public void onTestSuccess(ITestResult test){
        System.out.println("------------------Test: " + test.getName() + " Passed------------------");
        if (!getData("PlatformNameOfTest").equalsIgnoreCase("api")) {
            if (getData("PlatformNameOfTest").equalsIgnoreCase("web"))
                System.out.println("Company: \t \t" + test.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ExecutionData.class).company() + "\n");
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete()) {
                System.out.println("File deleted successfully \n \n");
            } else
                System.out.println("Failed deleting file");
        }
    }

    public void onTestFailure(ITestResult test){
        System.out.println("------------------Test: "+test.getName()+" Failed------------------");
        if (!getData("PlatformNameOfTest").equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            saveScreenshot();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        System.out.println("???");
    }

    public void onTestSkipped(ITestResult test){
        System.out.println("------------------Skipping Test: "+test.getName()+"------------------");
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        if (!getData("PlatformNameOfTest").equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}
