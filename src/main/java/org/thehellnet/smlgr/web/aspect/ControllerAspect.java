package org.thehellnet.smlgr.web.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.thehellnet.smlgr.web.controller.api.exception.AbstractApiControllerException;
import org.thehellnet.smlgr.web.utility.JsonResponse;

/**
 * Created by sardylan on 25/12/15.
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger logger = LogManager.getLogger(ControllerAspect.class.getSimpleName());

    @Around("execution(* org.thehellnet.smlgr.web.controller.api.*.*(..))")
    public Object prepareResponse(ProceedingJoinPoint joinPoint) {
        JsonResponse response = JsonResponse.createInstance(true);
        Object[] proceedingParams = new Object[]{joinPoint.getArgs()[0], response};
        try {
            response = (JsonResponse) joinPoint.proceed(proceedingParams);
        } catch (AbstractApiControllerException e) {
            response.setSuccess(false)
                    .putError("message", e.getErrorMessage());
        } catch (Throwable throwable) {
            response.setSuccess(false);
            throwable.printStackTrace();
        }
        return response;
    }
}
