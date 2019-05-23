package com.web;

import com.web.core.ProjectLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    public static void main(String[] args) {
        Logger log=LogManager.getLogger("Base");
        log.error("Error message");
    }
}