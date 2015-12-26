package org.thehellnet.smlgr.web.utility;

import org.apache.commons.codec.binary.Hex;

/**
 * Created by sardylan on 25/12/15.
 */
public final class PasswordUtility {
    public static String hashPassword(String password) {
        return new String(Hex.encodeHex(org.apache.commons.codec.digest.DigestUtils.sha512(password)));
    }
}
