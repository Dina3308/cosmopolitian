package ru.kpfu.itis.cosmopolitan.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LoggingAspect {

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.cosmopolitan.services.BasketService.*(..))", throwing = "error")
    public void logBasketService(JoinPoint joinPoint, Exception error) {
        log.error(joinPoint.getSignature().getName() + " " + error.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.cosmopolitan.services.OrderService.*(..))", throwing = "error")
    public void logOrderService(JoinPoint joinPoint, Exception error) {
        log.error(joinPoint.getSignature().getName() + " " + error.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.cosmopolitan.services.ProductService.*(..))", throwing = "error")
    public void logProductService(JoinPoint joinPoint, Exception error) {
        log.error(joinPoint.getSignature().getName() + " " + error.getMessage());
    }

    @AfterThrowing(pointcut = "execution(* ru.kpfu.itis.cosmopolitan.services.SignUpService.*(..))", throwing = "error")
    public void loggSignUpService(JoinPoint joinPoint, Exception error) {
        log.error(joinPoint.getSignature().getName() + " " + error.getMessage());
    }
}
