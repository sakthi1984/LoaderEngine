import com.mobileiron.interview.loader.LoaderEngine;

import static com.mobileiron.interview.loader.LoaderEngine.logger;

/**
 * Created by sakthivel.v on 21/07/16.
 */
public class TestLoaderEngine {
    public static void main(String[] args) {
        LoaderEngine driver = new LoaderEngine();
        logger.info("Starting load test...");
        driver.start();
        logger.info("Load test completed.");
    }
}
