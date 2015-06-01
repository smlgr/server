package org.thehellnet.smlgr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sardylan on 19/05/15.
 */
@Controller
public class JspController extends MultiActionController {
    @RequestMapping({"/today", "/"})
    public ModelAndView today(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView graph = new ModelAndView("graph");
        graph.addObject("action", "today");
        return graph;
    }

    @RequestMapping({"/yesterday"})
    public ModelAndView yesterday(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView graph = new ModelAndView("graph");
        graph.addObject("action", "yesterday");
        return graph;
    }
}
