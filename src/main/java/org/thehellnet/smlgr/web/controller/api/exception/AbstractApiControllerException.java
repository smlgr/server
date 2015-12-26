package org.thehellnet.smlgr.web.controller.api.exception;

/**
 * Created by sardylan on 25/12/15.
 */
public abstract class AbstractApiControllerException extends RuntimeException {
    protected String errorMessage = "";

    public String getErrorMessage() {
        return errorMessage;
    }
}
