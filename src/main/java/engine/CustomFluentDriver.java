package engine;

import org.fluentlenium.adapter.junit.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CustomFluentDriver extends FluentTest {

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }

}
