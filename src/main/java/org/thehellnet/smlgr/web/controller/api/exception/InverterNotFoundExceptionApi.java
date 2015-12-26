package org.thehellnet.smlgr.web.controller.api.exception;

/**
 * Created by sardylan on 25/12/15.
 */
public class InverterNotFoundExceptionApi extends AbstractApiControllerException {
    public InverterNotFoundExceptionApi() {
        errorMessage = "Inverter not found";
    }
}
