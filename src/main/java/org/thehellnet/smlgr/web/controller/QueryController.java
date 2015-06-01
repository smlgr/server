package org.thehellnet.smlgr.web.controller;

import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.service.DataPayloadService;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sardylan on 02/06/15.
 */
@RestController
@RequestMapping(value = "/api/query")
@Scope(value = "request")
public class QueryController {
    @Autowired
    private DataPayloadService dataPayloadService;

    @RequestMapping(value = "/today", produces = "application/json")
    public
    @ResponseBody
    JsonResponse getToday() {
        List<DataPayload> elems = dataPayloadService.getToday();
        if (elems == null) {
            return JsonResponse.createErrorInstance("No data for today");
        }

        return jsonDay(elems);
    }

    @RequestMapping(value = "/yesterday", produces = "application/json")
    public
    @ResponseBody
    JsonResponse getYesterday() {
        List<DataPayload> elems = dataPayloadService.getYesterday();
        if (elems == null) {
            return JsonResponse.createErrorInstance("No data for yesterday");
        }

        return jsonDay(elems);
    }

    @RequestMapping(value = "/day/{day}", produces = "application/json")
    public
    @ResponseBody
    JsonResponse getDay(@PathVariable("day") String day) {
        MutableDateTime mutableDateTime = MutableDateTime.parse(day, DateTimeFormat.forPattern("yyyyMMdd"));
        mutableDateTime.setTime(0, 0, 0, 0);

        List<DataPayload> elems = dataPayloadService.getDay(mutableDateTime.toDateTime());
        if (elems == null) {
            return JsonResponse.createErrorInstance("No data for day");
        }

        return jsonDay(elems);
    }

    @RequestMapping(value = "/interval/{start}/{stop}", produces = "application/json")
    public
    @ResponseBody
    JsonResponse getInterval(@PathVariable("start") String start, @PathVariable("stop") String stop) {
        MutableDateTime mutableStart = MutableDateTime.parse(start, DateTimeFormat.forPattern("yyyyMMddHHmmss"));
        MutableDateTime mutableStop = MutableDateTime.parse(stop, DateTimeFormat.forPattern("yyyyMMddHHmmss"));

        List<DataPayload> elems = dataPayloadService.getInterval(mutableStart.toDateTime(), mutableStop.toDateTime());
        if (elems == null) {
            return JsonResponse.createErrorInstance("No data for Interval");
        }

        return jsonDay(elems);
    }

    private JsonResponse jsonDay(List<DataPayload> elems) {
        ArrayList<Object> data = new ArrayList<>();

        for (final DataPayload elem : elems) {
            ArrayList<Long> item = new ArrayList<>();

            item.add(elem.getDateTime().getMillis());
            item.add((long) elem.getAcPower());

            data.add(item);
        }

        return JsonResponse.createInstance(true, data);
    }
}
