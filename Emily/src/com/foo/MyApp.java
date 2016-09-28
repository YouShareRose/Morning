package com.foo;

/**
 * Created by Administrator on 2016/9/5.
 */
import com.foo.Bar;

// Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MyApp {
    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(final String... args) {

        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径

        // Set up a simple configuration that logs on the console.

        logger.trace("Entering application.");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("Didn't do it.");
            System.out.println("nengbunebfsghy");
        }
        logger.trace("Exiting application.");
    }
}