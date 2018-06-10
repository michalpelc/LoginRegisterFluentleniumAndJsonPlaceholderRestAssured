package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("http://automationpractice.com")
public class MainPage extends GenericPage {

    @Override
    public void isAt() {
        await().until(signInLink).isClickable();
    }

    @Page
    private LoginRegisterForm loginRegisterForm;

    @FindBy(css = ".login")
    private FluentWebElement signInLink;

    public LoginRegisterForm clickSignInLink() {
        signInLink.click();
        return loginRegisterForm;
    }

    public void veriyThatUserIsLoggedOut() {
        await().until(signInLink).isDisplayed();
    }

}
