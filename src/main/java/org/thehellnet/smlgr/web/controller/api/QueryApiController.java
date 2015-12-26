package org.thehellnet.smlgr.web.controller.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.thehellnet.smlgr.web.controller.api.dto.request.QueryDataPayloadDTOApi;
import org.thehellnet.smlgr.web.controller.api.exception.AbstractApiControllerException;
import org.thehellnet.smlgr.web.controller.api.exception.InverterNotFoundExceptionApi;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.stream.Collectors;

/**
 * Created by sardylan on 02/06/15.
 */
@RestController
@RequestMapping(value = "/api/query")
@Scope(value = "request")
public class QueryApiController extends AbstractApiController {

    private static final Logger logger = LogManager.getLogger(QueryApiController.class.getSimpleName());

    @Transactional
    @RequestMapping(value = "/dataPayload",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonResponse dataPayload(@RequestBody QueryDataPayloadDTOApi dto, JsonResponse response) throws AbstractApiControllerException {
        logger.info("dataPayload");

        Inverter inverter = inverterRepository.findByTag(dto.tag);
        if (inverter == null) {
            throw new InverterNotFoundExceptionApi();
        }

        return response.putData("dataPayloads", dataPayloadRepository
                .findByInverterAndDateTimeBetweenOrderByDateTimeAsc(inverter, dto.startInterval, dto.stopInterval)
                .stream()
                .map(DataPayload::toSimpleDTO)
                .collect(Collectors.toList()));
    }
}
