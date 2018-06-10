package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.wait.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

class GenericPage extends FluentPage {

    private static final int DEFAULT_TIMEOUT_IN_SEC = 30;

    @Override
    public FluentWait await() {
        return super.await().atMost(DEFAULT_TIMEOUT_IN_SEC, SECONDS);
    }

}
