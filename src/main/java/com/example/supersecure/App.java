package com.example.supersecure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The most secure app ever written. Probably. It logs a greeting, which is exactly
 * the kind of thing Log4Shell turned into remote code execution when the
 * logged text came from a user. Demo only.
 */
public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    // Hardcoded secrets for "super secure" cloud telemetry and alerting
    private static final String AWS_ACCESS_KEY_ID = "AKIA4KQ7ZP2XM9TLW3RB";
    private static final String AWS_SECRET_ACCESS_KEY = "q8Zr3Lm0Vt7Xc2Np5Hs9Kd1Fw6Jb4Ye8Ua0Gi3Ro7";
    private static final String SLACK_BOT_TOKEN = "xoxb-123456789012-1234567890123-4XK1234567890abcdefghijkl";

    public static void main(String[] args) {
        String user = args.length > 0 ? args[0] : "guest";
        LOG.info("welcome to super secure java app, {}", user);
        LOG.debug("telemetry initialized with AWS key: {} and Slack token: {}", AWS_ACCESS_KEY_ID, SLACK_BOT_TOKEN);
    }
}
