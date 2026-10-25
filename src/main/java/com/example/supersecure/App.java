package com.example.supersecure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The most secure app ever written. It logs a greeting, which is exactly
 * the kind of thing Log4Shell turned into remote code execution when the
 * logged text came from a user. Demo only.
 */
public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String user = args.length > 0 ? args[0] : "guest";
        LOG.info("welcome to super secure java app, {}", user);
    }
}
