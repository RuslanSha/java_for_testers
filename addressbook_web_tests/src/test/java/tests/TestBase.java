package tests;

import com.titusfortner.logging.SeleniumLogger;
import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;
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

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }
}
