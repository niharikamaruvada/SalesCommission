package com.springboot.assn.SalesCommission.aspect;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  
@Component  
public class Performance 
{
	@Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceClassMethods() {};

    @Around("serviceClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) 
      throws Throwable {
        long start = System.nanoTime();
        Object returnValue = joinPoint.proceed();
        /*joinPoint.proceed() method is used to calculate start time before invoking a method
          then computations in invoked method are done
          then end time is calculated after the method is invoked again.
         */
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(
          "Execution of " + methodName + " took " + 
          TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return returnValue;
    }
		
}
