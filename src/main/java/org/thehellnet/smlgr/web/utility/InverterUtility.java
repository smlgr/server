package org.thehellnet.smlgr.web.utility;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by sardylan on 25/12/15.
 */
public final class InverterUtility {
    public static String generateTag() {
        return RandomStringUtils.randomAlphanumeric(16);
    }

    public static String generateToken() {
        return RandomStringUtils.randomAlphanumeric(32);
    }
}
