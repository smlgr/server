package org.thehellnet.smlgr.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.thehellnet.smlgr.web.repository.DataPayloadRepository;
import org.thehellnet.smlgr.web.repository.InverterRepository;
import org.thehellnet.smlgr.web.repository.UserRepository;

/**
 * Created by sardylan on 25/12/15.
 */
@Controller
public abstract class AbstractApiController {

    @Autowired
    protected Environment environment;

    @Autowired
    protected InverterRepository inverterRepository;

    @Autowired
    protected DataPayloadRepository dataPayloadRepository;

    @Autowired
    protected UserRepository userRepository;
}
