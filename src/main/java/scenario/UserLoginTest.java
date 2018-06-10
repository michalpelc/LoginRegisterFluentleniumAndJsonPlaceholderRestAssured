package scenario;

import engine.FluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import page.LoginRegisterForm;
import page.MainPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class UserLoginTest extends FluentDriver {

    @Page private MainPage mainPage;
    @Page private LoginRegisterForm loginRegisterForm;

    private final String randomPassword = randomAlphabetic(10);
    private final String randomEmailWithValidFormat = randomAlphabetic(10) + "@google.com";
    private final String existingUser = "michalpelc@wp.pl";
    private final String existingPassword = "michalpelc";

    @Test
    public void shouldLoginLogoutExistingUser() {
        goTo(mainPage)
                .clickSignInLink()
                .setEmailInput(existingUser)
                .setPasswordInput(existingPassword)
                .submit()
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
                .setEmailInput(email)
                .setPasswordInput(password)
                .submit();
        loginRegisterForm.verifyThatErrorMessageAppeared(errorMessage);
        mainPage.veriyThatUserIsLoggedOut();
    }

}
