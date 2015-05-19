package org.thehellnet.smlgr.web.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.service.DataPayloadService;
import org.thehellnet.smlgr.web.model.service.InverterService;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.HashMap;

/**
 * Created by sardylan on 19/05/15.
 */
@RestController
@RequestMapping(value = "/api/mobile")
@Scope(value = "request")
public class MobileApiController {
    @Autowired
    private DataPayloadService dataPayloadService;

    @Autowired
    private InverterService inverterService;

    @RequestMapping(value = "/live/{inverter_id}", produces = "application/json")
    public JsonResponse live(@PathVariable("inverter_id") long inverterId) {
        DataPayload last = dataPayloadService.findLastByInverterId(inverterId);
        if (last != null) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("outPower", last.getOutPower());
            data.put("acVoltage", last.getAcVoltage());
            data.put("temp", last.getTemp());
            data.put("frequency", last.getFrequency());
            data.put("todayProduction", last.getTodayProduction());
            return JsonResponse.createInstance(true, data);
        }
        return JsonResponse.createErrorInstance("Inverter not found");
    }

    @RequestMapping(value = "/once/{inverter_id}", produces = "application/json")
    public JsonResponse once(@PathVariable("inverter_id") long inverterId) {
        Inverter inverter = inverterService.findById(inverterId);
        if (inverter == null) {
            return JsonResponse.createErrorInstance("Inverter not found");
        }

        DataPayload todayFirst = dataPayloadService.findTodayFirstByInverterId(inverterId);
        DataPayload todayLast = dataPayloadService.findTodayLastByInverterId(inverterId);
        DataPayload todayMax = dataPayloadService.findTodayMaxByInverterId(inverterId);
        if (todayFirst == null || todayLast == null || todayMax == null) {
            return JsonResponse.createErrorInstance("Inverter not found");
        }

        DataPayload yesterdayFirst = dataPayloadService.findYesterdayFirstByInverterId(inverterId);
        DataPayload yesterdayLast = dataPayloadService.findYesterdayLastByInverterId(inverterId);
        DataPayload yesterdayMax = dataPayloadService.findYesterdayMaxByInverterId(inverterId);

        HashMap<String, Object> data = new HashMap<>();
        data.put("maxPower", inverter.getMaxPower());

        data.put("todayMaxProduction", todayMax.getOutPower());
        data.put("todayMaxTime", todayMax.getDateTime());
        data.put("todayStartTime", todayFirst.getDateTime());
        data.put("todayStopTime", todayLast.getDateTime());

        if (yesterdayFirst != null && yesterdayLast != null && yesterdayMax != null) {
            data.put("yesterdayMaxProduction", yesterdayMax.getOutPower());
            data.put("yesterdayMaxTime", yesterdayMax.getDateTime());
            data.put("yesterdayStartTime", yesterdayFirst.getDateTime());
            data.put("yesterdayStopTime", yesterdayLast.getDateTime());
        } else {
            data.put("yesterdayMaxProduction", null);
            data.put("yesterdayMaxTime", null);
            data.put("yesterdayStartTime", null);
            data.put("yesterdayStopTime", null);
        }

        return JsonResponse.createInstance(true, data);
    }
}