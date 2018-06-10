package scenario;

import engine.FluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import page.MainPage;

public class UserLoginTest extends FluentDriver {

    @Page
    private MainPage mainPage;


    @Test
    public void shouldLoginLogoutExistingUser() {
        goTo(mainPage).clickSignInLink();
    }

    @Test
    public void shouldNotLoginNotExistingUser() {
    }

    @Test
    public void shouldNotLoginUserWithIncompleteData() {
    }

}
