package org.thehellnet.smlgr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Controller
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

    @RequestMapping(value = "/{inverter_id}/payload", method = RequestMethod.POST, consumes = "application/json")
    public JsonResponse ReceiveDataPayload(@PathVariable("inverter_id") long inverter_id,
                                           @RequestBody DataPayloadDTO payloadDTO) {
        Inverter inverter = inverterService.findById(inverter_id);
        if (inverter != null) {
            DataPayload payload = new DataPayload(payloadDTO);
            payload.setInverter(inverter);
            dataPayloadService.persist(payload);
            return JsonResponse.createInstance(true);
        }

        return JsonResponse.createErrorInstance("Inverter not found");
    }
}
