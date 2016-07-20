package com.mobileiron.interview.loader;

import com.mobileiron.interview.loader.Utils.myHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sakthivel.v on 21/07/16.
 */
public class Worker implements Runnable {
    private static Logger logger = LoggerFactory.getLogger("THREAD");
    private String url;

    public Worker(String url) {
        this.url = url;
    }

    public void run() {
        logger.info(Thread.currentThread().getName() + " (Start) url = " + url);
        getAPI(url);
        postAPI(url);
        logger.info(Thread.currentThread().getName() + " (End)");
    }

    private void postAPI(String url) {
        try {
            myHttpClient client = new myHttpClient();
            logger.info(client.post(url));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void getAPI(String url) {
        try {
            myHttpClient client = new myHttpClient();
            logger.info(client.get(url));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
