package org.thehellnet.smlgr.web.controller.api;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thehellnet.smlgr.web.controller.api.dto.request.EmptyRequestDTOApi;
import org.thehellnet.smlgr.web.controller.api.exception.AbstractApiControllerException;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.User;
import org.thehellnet.smlgr.web.utility.InverterUtility;
import org.thehellnet.smlgr.web.utility.JsonResponse;
import org.thehellnet.smlgr.web.utility.PasswordUtility;

import java.util.logging.Logger;

/**
 * Created by sardylan on 02/06/15.
 */
@RestController
@RequestMapping(value = "/api/service")
@Scope(value = "request")
public class ServiceApiController extends AbstractApiController {

    private Logger logger = Logger.getLogger(ServiceApiController.class.getSimpleName());

    @Transactional
    @RequestMapping(value = "/populate",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonResponse populate(EmptyRequestDTOApi dto, JsonResponse response) throws AbstractApiControllerException {
        logger.info("populate");

        User user = new User();
        user.setEmail("sardylan@gmail.com");
        user.setPassword(PasswordUtility.hashPassword("password"));
        userRepository.save(user);
        user = userRepository.findByEmail("sardylan@gmail.com");

        Inverter inverter = new Inverter();
        inverter.setUser(user);
        inverter.setTag(InverterUtility.generateTag());
        inverter.setProducer("SolarMax");
        inverter.setModel("S3000");
        inverter.setMaxPower(27500);
        inverter.setToken(InverterUtility.generateToken());
        inverterRepository.save(inverter);

        return response;
    }
}
