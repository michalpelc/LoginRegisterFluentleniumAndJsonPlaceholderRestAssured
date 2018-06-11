package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.wait.FluentWait;
import org.openqa.selenium.support.FindBy;

import static java.util.concurrent.TimeUnit.SECONDS;

class GenericPage extends FluentPage {

    // Class with common methods used between pages

    private static final int DEFAULT_TIMEOUT_IN_SEC = 30;

    @Page
    private MainPage mainPage;

    @Override
    public FluentWait await() {
        return super.await().atMost(DEFAULT_TIMEOUT_IN_SEC, SECONDS);
    }

    @FindBy(css = ".alert")
    private FluentWebElement errorNotification;

    public MainPage verifyThatErrorMessageAppeared(String errorMessage) {
        await().until(errorNotification).containsText(errorMessage);
        return mainPage;
    }

}
