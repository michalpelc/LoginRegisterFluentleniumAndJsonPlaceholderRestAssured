package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends GenericPage {

    @Override
    public void isAt() {
        await().until(signInButton).clickable();
    }

    @Page
    private LoggedInPage loggedInPage;

    @Page
    private AccountCreationForm accountCreationForm;

    @FindBy(id = "email")
    private FluentWebElement emailLoginInput;

    @FindBy(id = "email_create")
    private FluentWebElement emailCreateInput;

    @FindBy(id = "SubmitCreate")
    private FluentWebElement createAccountButton;

    @FindBy(id = "passwd")
    private FluentWebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private FluentWebElement signInButton;

    public AuthenticationPage setEmailToCreateAccount(String email) {
        this.emailCreateInput.fill().withText(email);
        return this;
    }

    public AccountCreationForm clickCreateAccountButton () {
        createAccountButton.click();
        return accountCreationForm;
    }

    public AuthenticationPage setEmailToLogin(String email) {
        this.emailLoginInput.fill().withText(email);
        return this;
    }

    public AuthenticationPage setPasswordToLogin(String password) {
        this.passwordInput.fill().withText(password);
        return this;
    }

    public LoggedInPage clickSignInButton() {
        signInButton.click();
        return loggedInPage;
    }

}
