package org.thehellnet.smlgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.service.DataPayloadService;
import org.thehellnet.smlgr.web.model.service.InverterService;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sardylan on 02/06/15.
 */
@RestController
@RequestMapping(value = "/api/service")
@Scope(value = "request")
public class ServiceController {
    private Logger logger = Logger.getLogger(ServiceController.class.getSimpleName());

    @Autowired
    private InverterService inverterService;

    @Autowired
    private DataPayloadService dataPayloadService;

    @RequestMapping(value = "/test")
    public JsonResponse test() {
        logger.log(Level.INFO, "SERVICE TEST");

//        Inverter inverter = inverterService.findById(1);
//        if (inverter == null) {
//            return JsonResponse.createErrorInstance("Inverter not found");
//        }
//
//        DataPayload payload = new DataPayload();
//        payload.setInverter(inverter);
//        payload.setAcPower(10);
//        payload.setAcVoltage(100);
//        payload.setAcFrequency(5100);
//        payload.setTemperature(123);
//        dataPayloadService.persist(payload);

        return JsonResponse.createInstance(true);
    }
}
