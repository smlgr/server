package org.thehellnet.smlgr.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.repository.DataPayloadRepository;
import org.thehellnet.smlgr.web.repository.InverterRepository;
import org.thehellnet.smlgr.web.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sardylan on 19/05/15.
 */
@Controller
public class JspController extends MultiActionController {

    private static final Logger logger = LogManager.getLogger(JspController.class.getSimpleName());

    private static final String inverterTag = "ZkwHQPOrXKwmlI7F";

    @Autowired
    protected Environment environment;

    @Autowired
    protected InverterRepository inverterRepository;

    @Autowired
    protected DataPayloadRepository dataPayloadRepository;

    @Autowired
    protected UserRepository userRepository;

    @Transactional
    @RequestMapping({"/"})
    public ModelAndView today(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Inverter inverter = inverterRepository.findByTag(inverterTag);
        DateTime minDate = dataPayloadRepository.findFirstDateTimeByInverter(inverter);
        DateTime maxDate = dataPayloadRepository.findLastDateTimeByInverter(inverter);

        ModelAndView graph = new ModelAndView("graph");
        graph.addObject("inverterTag", inverterTag);
        graph.addObject("minDate", minDate.getMillis());
        graph.addObject("maxDate", maxDate.getMillis());

        return graph;
    }
}
