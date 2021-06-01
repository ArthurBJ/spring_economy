package group907.baybikov.springwitch.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class ExceptionThrowingAspect {

    private final Logger logger = Logger.getLogger(ExceptionThrowingAspect.class.getName());

    @AfterThrowing(pointcut = "@annotation(ExceptionThrowing)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.warning("Исключение в методе" + signature.getDeclaringTypeName() + "-" + method + ": " + exception.toString());
    }
}
