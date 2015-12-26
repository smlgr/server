package org.thehellnet.smlgr.web.controller.api;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sardylan on 19/05/15.
 */
@RestController
@RequestMapping(value = "/api/mobile")
@Scope(value = "request")
public class MobileController {
    /*
    private Logger logger = Logger.getLogger(MobileApiController.class.getSimpleName());

    @Autowired
    private DataPayloadService dataPayloadService;

    @Autowired
    private InverterService inverterService;

    @RequestMapping(value = "/live/{inverter_id}", produces = "application/json")
    public JsonResponse live(@PathVariable("inverter_id") long inverterId) {
//        logger.log(Level.INFO, String.format("Live data for inverter %d", inverterId));

        DataPayload last = dataPayloadService.findTodayLastByInverterId(inverterId);

        if (last != null) {
            DataPayloadDTO data = new DataPayloadDTO(last);
            return JsonResponse.createInstance(true, data);
        }

        return JsonResponse.createErrorInstance("Inverter not found");
    }

    @RequestMapping(value = "/once/{inverter_id}", produces = "application/json")
    public JsonResponse once(@PathVariable("inverter_id") long inverterId) {
//        logger.log(Level.INFO, String.format("Once data for inverter %d", inverterId));

        Inverter inverter = inverterService.findById(inverterId);
        if (inverter == null) {
            return JsonResponse.createErrorInstance("Inverter not found");
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("maxPower", inverter.getMaxPower());

        DataPayload todayFirst = dataPayloadService.findTodayFirstByInverterId(inverterId);
        DataPayload todayLast = dataPayloadService.findTodayLastByInverterId(inverterId);
        DataPayload todayMax = dataPayloadService.findTodayMaxByInverterId(inverterId);

        if (todayFirst != null && todayLast != null && todayMax != null) {
            data.put("todayMaxProduction", todayMax.getAcPower());
            data.put("todayMaxTime", todayMax.getDateTime());
            data.put("todayStartTime", todayFirst.getDateTime());
            data.put("todayStopTime", todayLast.getDateTime());
        } else {
            data.put("todayMaxProduction", null);
            data.put("todayMaxTime", null);
            data.put("todayStartTime", null);
            data.put("todayStopTime", null);

        }

        DataPayload yesterdayFirst = dataPayloadService.findYesterdayFirstByInverterId(inverterId);
        DataPayload yesterdayLast = dataPayloadService.findYesterdayLastByInverterId(inverterId);
        DataPayload yesterdayMax = dataPayloadService.findYesterdayMaxByInverterId(inverterId);

        if (yesterdayFirst != null && yesterdayLast != null && yesterdayMax != null) {
            data.put("yesterdayProduction", yesterdayLast.getProduction());
            data.put("yesterdayMaxProduction", yesterdayMax.getAcPower());
            data.put("yesterdayMaxTime", yesterdayMax.getDateTime());
            data.put("yesterdayStartTime", yesterdayFirst.getDateTime());
            data.put("yesterdayStopTime", yesterdayLast.getDateTime());
        } else {
            data.put("yesterdayProduction", null);
            data.put("yesterdayMaxProduction", null);
            data.put("yesterdayMaxTime", null);
            data.put("yesterdayStartTime", null);
            data.put("yesterdayStopTime", null);
        }

        return JsonResponse.createInstance(true, data);
    }
    */
}
