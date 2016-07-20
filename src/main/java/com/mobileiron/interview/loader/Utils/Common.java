package com.mobileiron.interview.loader.Utils;

import com.mobileiron.interview.loader.Config.TestConfig;

import java.util.Random;

/**
 * Created by sakthivel.v on 21/07/16.
 */
public class Common {

    public static long currentTime() {
        return System.currentTimeMillis();
    }

    public static String getRandomEventType(TestConfig config) {
        String[] events = config.events;
        Random rnd = new Random();
        return events[rnd.nextInt(events.length - 1)];
    }

    public static String getRandomDeviceId() {
        int length = 16;
        String deviceId = "";
        Random rnd = new Random();
        String stringPool = "ABCDEDFG1234567890";
        for (int i = 0; i < length; i++) {
            deviceId = deviceId + stringPool.charAt(rnd.nextInt(stringPool.length()));
        }
        return deviceId;
    }
}
