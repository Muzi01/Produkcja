package bindings.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDriverFactory {

    private static Integer DEF_WAIT_TIME_OUT_SECONDS = 2;

    public static WebDriverWait createWaitDriver(WebDriver webDriver ) {

        Integer waitDriverTimeOutSeconds = getWaitDriverTimeOutSecondsOption();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, waitDriverTimeOutSeconds);

        return webDriverWait;
    }


    private static Integer getWaitDriverTimeOutSecondsOption()  {

        String waitDriverTimeOutSecondsString = System.getProperty("selenium.options.timeoutinseconds");

        // check if wait time is specified, otherwise set default value
        if (waitDriverTimeOutSecondsString == null) {
            return DEF_WAIT_TIME_OUT_SECONDS;
        }

        Integer waitDriverTimeOutSecondsInteger = null;
        // convert wait time of string to seconds
        try {
            waitDriverTimeOutSecondsInteger = Integer.parseInt(waitDriverTimeOutSecondsString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return waitDriverTimeOutSecondsInteger;
    }
}
