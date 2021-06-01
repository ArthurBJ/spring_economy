package group907.baybikov.springwitch.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingTimeAspect {

    private final Logger logger = Logger.getLogger(LoggingTimeAspect.class.getName());

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long up = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long time = System.currentTimeMillis() - up;
        logger.info(joinPoint.getSignature().getDeclaringTypeName() + "-" +joinPoint.getSignature().getName() + " выполнен за " + time + " мс");
        return proceed;
    }
}
