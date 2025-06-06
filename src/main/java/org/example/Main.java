package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.GetCallerIdentityResponse;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (StsClient sts = StsClient.create()) {
            GetCallerIdentityResponse identity = sts.getCallerIdentity();
            logger.info("Current identity: {}", identity.arn());
        } catch (Exception e) {
            logger.error("Failed to get caller identity", e);
        }
    }
}