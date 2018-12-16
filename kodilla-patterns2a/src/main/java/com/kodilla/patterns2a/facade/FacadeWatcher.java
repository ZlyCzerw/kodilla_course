package com.kodilla.patterns2a.facade;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

    @Aspect
    @Component
    public class FacadeWatcher {

        private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2a.facade.FacadeWatcher.class);

        @Around("execution(* com.kodilla.patterns2a.facade.api.OrderFacade.processOrder(..))")
        public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            Object result;
            try {
                long begin = System.currentTimeMillis();
                result = proceedingJoinPoint.proceed();
                long end = System.currentTimeMillis();
                LOGGER.info("Time sprend calculating: " + (end - begin) + "[ms]");
            } catch (Throwable throwable) {
                LOGGER.error(throwable.getMessage());
                throw throwable;
            }
            return result;
        }
    }
