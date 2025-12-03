package org.example.tpfoyer.configAOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class performance {
    @Around("execution(* org.example.tpfoyer.services.BlocServiceImpl.findBlocsByFoyerCapacity(..))")
    public Object findBlocsWithNomjpql(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
    @Before("execution(* org.example.tpfoyer.services.BlocServiceImpl.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* org.example.tpfoyer.services.BlocServiceImpl.*(..))")
    public void logMethodAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("After method " + name + " : ");
    }

}
