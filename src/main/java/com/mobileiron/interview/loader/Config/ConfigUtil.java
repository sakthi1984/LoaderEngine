package com.mobileiron.interview.loader.Config;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sakthivel.v on 21/07/16.
 */
public class ConfigUtil {
    private static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
    private TestConfig jsonObject;
    private FileReader fr;
    private ObjectMapper mapper = new ObjectMapper();

    public TestConfig getConfig() {
        String cwd = System.getProperty("user.dir");
        logger.info("Current working dir: " + cwd);
        String configFile = cwd + "/src/main/resources/config/testConfig.json";
        logger.info("Loading config file: " + configFile);
        try {
            fr = new FileReader(configFile);
            this.jsonObject = mapper.readValue(fr, TestConfig.class);
            logger.debug(jsonObject.server + " " + jsonObject.protocol + " " + jsonObject.maxRequestsPerUser);
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.jsonObject;
    }
}
