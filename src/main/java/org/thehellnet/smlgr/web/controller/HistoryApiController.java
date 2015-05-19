package org.thehellnet.smlgr.web.controller;

import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thehellnet.smlgr.web.model.HistoryPayload;
import org.thehellnet.smlgr.web.model.service.HistoryPayloadService;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sardylan on 18/05/15.
 */
@RestController
@RequestMapping(value = "/api/history")
@Scope(value = "request")
public class HistoryApiController {
    @Autowired
    private HistoryPayloadService historyPayloadService;

    @RequestMapping(value = "/today", produces = "application/json")
    public
    @ResponseBody
    JsonResponse getToday() {
        List<HistoryPayload> elems = historyPayloadService.getToday();
        if(elems == null) {
            return JsonResponse.createErrorInstance("No data for today");
        }

        return jsonDay(elems);
    }

    @RequestMapping(value = "/yesterday", produces = "application/json")
    public
    @ResponseBody
    JsonResponse getYesterday() {
        List<HistoryPayload> elems = historyPayloadService.getYesterday();
        if(elems == null) {
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

        List<HistoryPayload> elems = historyPayloadService.getDay(mutableDateTime.toDateTime());
        if(elems == null) {
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

        List<HistoryPayload> elems = historyPayloadService.getInterval(mutableStart.toDateTime(), mutableStop.toDateTime());
        if(elems == null) {
            return JsonResponse.createErrorInstance("No data for Interval");
        }

        return jsonDay(elems);
    }

    private JsonResponse jsonDay(List<HistoryPayload> elems) {
        ArrayList<Object> data = new ArrayList<>();
        for(final HistoryPayload elem: elems) {
            ArrayList<Long> item = new ArrayList<>();
            item.add(elem.getWhenquery().getMillis());
            item.add((long) elem.getPac() / 2);
            data.add(item);
        }
        return JsonResponse.createInstance(true, data);
    }
}
