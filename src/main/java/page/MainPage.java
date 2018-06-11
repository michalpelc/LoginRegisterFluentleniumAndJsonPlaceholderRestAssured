package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("http://automationpractice.com")
public class MainPage extends GenericPage {

    @Override
    public void isAt() {
        await().until(signInLink).clickable();
    }

    @Page
    private AuthenticationPage authenticationPage;

    @FindBy(css = ".login")
    private FluentWebElement signInLink;

    public AuthenticationPage clickSignInLink() {
        signInLink.click();
        return authenticationPage;
    }

    public void veriyThatUserIsLoggedOut() {
        await().until(signInLink).displayed();
    }

}
