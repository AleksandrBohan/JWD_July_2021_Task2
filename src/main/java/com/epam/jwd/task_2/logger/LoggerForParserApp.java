package com.epam.jwd.task_2.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerForParserApp {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        try {
            throw new RuntimeException("Exception1");
        } catch (RuntimeException e){
            logger.log(Level.ERROR, "first runtime", e);
        }
        logger.info("Log4j2ExampleApp started.");
        logger.warn("Something to warn");
        logger.error("Something failed.");

    }
    }

