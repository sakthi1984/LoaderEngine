package com.mobileiron.interview.loader;

import com.mobileiron.interview.loader.Config.ConfigUtil;
import com.mobileiron.interview.loader.Config.TestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.mobileiron.interview.loader.Utils.Common.*;

/**
 * Created by sakthivel.v on 21/07/16.
 */
public class LoaderEngine {
    public static Logger logger;
    ConfigUtil configUtil;
    TestConfig testConfig;

    //Initialize
    public LoaderEngine() {
        configUtil = new ConfigUtil();
        testConfig = configUtil.getConfig();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    //Generate dynamic API URL
    private String getAPIUrl() {
        String apiUrl = testConfig.protocol + "://" + testConfig.server + "/api/deviceLog?time=" + currentTime() + "&type=" + getRandomEventType(testConfig) + "&deviceId=" + getRandomDeviceId();
        logger.info("API URL:" + apiUrl);
        return apiUrl;
    }

    //CreateThreadPool & Start Execution
    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(testConfig.concurrentUsers);
        for (int i = 0; i < testConfig.maxRequestsPerUser; i++) {
            Runnable worker = new Worker(getAPIUrl());
            executor.execute(worker);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {

        }
        logger.info("All threads completed.");
    }

}
