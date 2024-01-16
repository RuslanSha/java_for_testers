package tests;

import com.titusfortner.logging.SeleniumLogger;
import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
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

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
