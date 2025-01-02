package com.ayzeysdev.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieRepository {
    // Corrected method name (getLogger with uppercase 'L')
    private static final Logger logger = LoggerFactory.getLogger(MovieRepository.class);

    public void logTest() {
        logger.info("Logging setup is successful!");
    }
}

