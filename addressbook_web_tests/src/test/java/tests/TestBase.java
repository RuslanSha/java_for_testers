package tests;

import com.titusfortner.logging.SeleniumLogger;
import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.logging.Level;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        SeleniumLogger.enable();
        SeleniumLogger seleniumLogger = new SeleniumLogger();
        seleniumLogger.setLevel(Level.WARNING);

        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

}
