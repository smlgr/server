package org.thehellnet.smlgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.dto.DataPayloadDTO;
import org.thehellnet.smlgr.web.model.dto.InverterPayloadDTO;
import org.thehellnet.smlgr.web.model.service.DataPayloadService;
import org.thehellnet.smlgr.web.model.service.InverterService;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sardylan on 16/05/15.
 */
@RestController
@RequestMapping(value = "/api/inverter")
@Scope(value = "request")
public class InverterApiController {
    private Logger logger = Logger.getLogger(InverterApiController.class.getSimpleName());

    @Autowired
    private InverterService inverterService;

    @Autowired
    private DataPayloadService dataPayloadService;

    @RequestMapping(value = "/list")
    public JsonResponse ListAllInverters() {
//        logger.log(Level.INFO, "List all inverters");

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

    @RequestMapping(value = "/{inverterId}/payload", method = RequestMethod.POST)
    public JsonResponse ReceiveDataPayload(@PathVariable("inverterId") long inverterId,
                                           @RequestBody InverterPayloadDTO payloadDto) {
//        logger.log(Level.INFO, String.format("Payload for inverter %d", inverterId));

        Inverter inverter = inverterService.findByIdAndToken(inverterId, payloadDto.getToken());
        if (inverter == null) {
            return JsonResponse.createErrorInstance("Inverter not found");
        }

        DataPayload payload = new DataPayload(payloadDto.getData());
        payload.setInverter(inverter);
        dataPayloadService.persist(payload);

        return JsonResponse.createInstance(true);
    }
}
