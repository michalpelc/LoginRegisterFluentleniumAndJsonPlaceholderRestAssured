package scenario;

import engine.CustomFluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import page.AuthenticationPage;
import page.MainPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class LoginRegisterTest extends CustomFluentDriver {

    @Page
    private MainPage mainPage;

    @Page
    private AuthenticationPage authenticationPage;

    private final String randomPassword = randomAlphabetic(10);
    private final String randomEmailWithValidFormat = randomAlphabetic(10) + "@google.com";

    @Test
    public void shouldNotRegisterUserWhenUserAlreadyExists() {
        String email = randomAlphabetic(5) + "@xyz.com";
        String password = randomAlphabetic(5);

        goTo(mainPage)
                .clickSignInLink()
                .setEmailToCreateAccount(email)
                .clickCreateAccountButton()
                .fillAccountCreationForm(email, password)
                .submitAccountCreationForm()
                .logOut()
                .clickSignInLink()
                .setEmailToCreateAccount(email)
                .clickCreateAccountButton()
                .verifyThatErrorMessageAppeared("account using this email address has already been registered");
    }

    @Test
    public void shouldRegisterAndLoginNewUser() {

        String email = randomAlphabetic(5) + "@xyz.com";
        String password = randomAlphabetic(5);

        goTo(mainPage)
                .clickSignInLink()
                .setEmailToCreateAccount(email)
                .clickCreateAccountButton()
                .fillAccountCreationForm(email, password)
                .submitAccountCreationForm()
                .logOut()
                .clickSignInLink()
                .setEmailToLogin(email)
                .setPasswordToLogin(password)
                .clickSignInButton()
                .verifyThatUserIsLoggedIn()
                .logOut()
                .veriyThatUserIsLoggedOut();
    }

    @Test
    public void shouldNotLoginUserThatDoesNotExists() {
        verifyLoginFailure(randomEmailWithValidFormat, randomPassword, "Authentication failed");
    }

    @Test
    public void shouldNotLoginUserWithoutLoginProvided() {
        verifyLoginFailure("", randomPassword, "An email address required");
    }

    @Test
    public void shouldNotLoginUserWithoutPasswordProvided() {
        verifyLoginFailure(randomEmailWithValidFormat, "", "Password is required");
    }

    @Test
    public void shouldNotLoginUserWithIncorrectFormattedLoginProvided() {
        verifyLoginFailure(randomAlphabetic(5), randomPassword, "Invalid email address.");
    }

    private void verifyLoginFailure(String email, String password, String errorMessage) {
        goTo(mainPage)
                .clickSignInLink()
                .setEmailToLogin(email)
                .setPasswordToLogin(password)
                .clickSignInButton()
                .verifyThatErrorMessageAppeared(errorMessage)
                .veriyThatUserIsLoggedOut();
    }

}
