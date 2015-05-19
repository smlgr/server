package org.thehellnet.smlgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.dto.DataPayloadDTO;
import org.thehellnet.smlgr.web.model.service.DataPayloadService;
import org.thehellnet.smlgr.web.model.service.InverterService;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sardylan on 16/05/15.
 */
@RestController
@RequestMapping(value = "/api/inverter")
@Scope(value = "request")
public class InverterApiController {
    @Autowired
    private InverterService inverterService;

    @Autowired
    private DataPayloadService dataPayloadService;

    @RequestMapping(value = "/list")
    public JsonResponse ListAllInverters() {
        HashMap<String, Object> content = new HashMap<>();
        List<Inverter> inverters = inverterService.findAll();
        content.put("count", inverters.size());
        for (final Inverter inverter : inverters) {
            HashMap<String, Object> item = new HashMap<>();
            item.put("user", inverter.getUser().getEmail());
            item.put("producer", inverter.getProducer());
            item.put("model", inverter.getModel());
            item.put("max_power", inverter.getMaxPower());
            content.put(String.valueOf(inverter.getId()), item);
        }
        return JsonResponse.createInstance(true, content);
    }

    @RequestMapping(value = "/{inverterId}/payload", method = RequestMethod.POST, produces = "application/json")
    public JsonResponse ReceiveDataPayload(@PathVariable("inverterId") long inverterId,
                                           @RequestParam("dcVoltage") int dcVoltage,
                                           @RequestParam("dcCurrent") int dcCurrent,
                                           @RequestParam("acVoltage") int acVoltage,
                                           @RequestParam("acCurrent") int acCurrent,
                                           @RequestParam("outPower") int outPower,
                                           @RequestParam("temp") int temp,
                                           @RequestParam("frequency") int frequency,
                                           @RequestParam("todayProduction") int todayProduction) {
        Inverter inverter = inverterService.findById(inverterId);
        if (inverter == null) {
            return JsonResponse.createErrorInstance("Inverter not found");
        }

        DataPayload payload = new DataPayload();
        payload.setInverter(inverter);
        payload.setDcVoltage(dcVoltage);
        payload.setDcCurrent(dcCurrent);
        payload.setAcVoltage(acVoltage);
        payload.setAcCurrent(acCurrent);
        payload.setOutPower(outPower);
        payload.setTemp(temp);
        payload.setFrequency(frequency);
        payload.setTodayProduction(todayProduction);
        dataPayloadService.persist(payload);

        return JsonResponse.createInstance(true);
    }
}
