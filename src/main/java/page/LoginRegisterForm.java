package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterForm extends GenericPage{

    @FindBy(css = "")
    private FluentWebElement email;

    @FindBy(css = "")
    private FluentWebElement password;

    @FindBy(css = "")
    private FluentWebElement signInButton;

    @Page
    private LoggedInPage loggedInPage;

    @Override
    public void isAt() {
        await().until(email).isDisplayed();
    }

    public LoginRegisterForm setEmail(String email) {
        this.email.text(email);
        return this;
    }

    public LoginRegisterForm setPassword(String password) {
        this.email.text(password);
        return this;
    }

    public LoggedInPage submit(){
        signInButton.click();
        return loggedInPage;
    }


}
