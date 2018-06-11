package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends GenericPage{

    @Page private MainPage mainPage;

    @FindBy(css = ".logout")
    private FluentWebElement logOutButton;

    public LoggedInPage verifyThatUserIsLoggedIn() {
        await().until(logOutButton).displayed();
        return this;
    }

    public MainPage logOut(){
        logOutButton.click();
        return mainPage;
    }

}
