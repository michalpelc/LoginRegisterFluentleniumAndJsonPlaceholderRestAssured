package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterForm extends GenericPage {

    @Override
    public void isAt() {
        await().until(signInButton).isClickable();
    }

    @Page
    private LoggedInPage loggedInPage;

    @FindBy(id = "email")
    private FluentWebElement emailInput;

    @FindBy(id = "passwd")
    private FluentWebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private FluentWebElement signInButton;

    @FindBy(css = ".alert")
    private FluentWebElement errorNotification;


    public LoginRegisterForm setEmailInput(String emailInput) {
        this.emailInput.text(emailInput);
        return this;
    }

    public LoginRegisterForm setPasswordInput(String passwordInput) {
        this.passwordInput.text(passwordInput);
        return this;
    }

    public LoggedInPage submit() {
        signInButton.click();
        return loggedInPage;
    }

    public void verifyThatErrorMessageAppeared(String errorDescription) {
        await().until(errorNotification).containsText(errorDescription);
    }
}
