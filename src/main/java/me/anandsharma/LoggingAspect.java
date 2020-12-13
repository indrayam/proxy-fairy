package me.anandsharma;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* *(..)) && @within(me.anandsharma.LoggedClass)")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        log.info("== [ASPECT] ENTERED");
        log.info("[ASPECT] Intercepted method call " + pjp.getSignature().getName() + " with args " + Arrays.toString(pjp.getArgs()));
        long t0 = System.currentTimeMillis();
        Object result = pjp.proceed();
        long t1 = System.currentTimeMillis();
        log.info("[ASPECT] Took {} ms", t1-t0);
        log.info("== [ASPECT] EXITED");
        return result;
    }
}
