package org.thehellnet.smlgr.web.controller.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.thehellnet.smlgr.web.controller.api.dto.request.EmptyRequestDTOApi;
import org.thehellnet.smlgr.web.controller.api.dto.request.InverterPayloadRequestDTOApi;
import org.thehellnet.smlgr.web.controller.api.exception.AbstractApiControllerException;
import org.thehellnet.smlgr.web.controller.api.exception.InverterNotFoundExceptionApi;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.utility.JsonResponse;

import java.util.stream.Collectors;

/**
 * Created by sardylan on 16/05/15.
 */
@RestController
@RequestMapping(value = "/api/inverter")
@Scope(value = "request")
public class InverterApiController extends AbstractApiController {

    private static final Logger logger = LogManager.getLogger(InverterApiController.class.getSimpleName());

    @Transactional
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonResponse list(EmptyRequestDTOApi dto, JsonResponse response) throws AbstractApiControllerException {
        return response.putData("inverters",
                inverterRepository.findAll()
                .stream()
                .map(Inverter::toDTO)
                .collect(Collectors.toList())
        );
    }

    @Transactional
    @RequestMapping(value = "/payload",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonResponse payload(@RequestBody InverterPayloadRequestDTOApi dto, JsonResponse response) throws AbstractApiControllerException {
        logger.info("payload");
        Inverter inverter = inverterRepository.findByTagAndToken(dto.tag, dto.token);
        if (inverter == null) {
            throw new InverterNotFoundExceptionApi();
        }
        DataPayload dataPayload = new DataPayload(inverter, dto);
        dataPayloadRepository.save(dataPayload);
        return response;
    }
}
