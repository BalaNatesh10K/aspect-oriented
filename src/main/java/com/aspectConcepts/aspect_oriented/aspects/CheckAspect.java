package com.aspectConcepts.aspect_oriented.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;

@Aspect
@Component
public class CheckAspect {
    @Before("@annotation(com.aspectConcepts.aspect_oriented.aspects.CheckSomething)")
    public void checkSomethingBefore(JoinPoint joinPoint){
        System.out.println("Before Execution : Roles"+ Arrays.toString(getRoles(joinPoint)));
    }

    public String[] getRoles(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        CheckSomething myAnnotation = method.getAnnotation(CheckSomething.class);
        return myAnnotation.roles();
    }

    @AfterThrowing(pointcut = "@annotation(com.aspectConcepts.aspect_oriented.aspects.CheckSomething)", throwing = "ex")
    public void checkSomethingAfterThrowingException(JoinPoint joinPoint, Exception ex){
        System.out.println("After Throwing Exception - Roles: "+Arrays.toString(getRoles(joinPoint)));
    }

    @AfterReturning(pointcut = "@annotation(com.aspectConcepts.aspect_oriented.aspects.CheckSomething)")
    public void checkSomethingAfterReturning(JoinPoint joinPoint){
        System.out.println("After Returning Exception - Roles: "+Arrays.toString(getRoles(joinPoint)));
    }

    @Around("@annotation(com.aspectConcepts.aspect_oriented.aspects.CheckSomething)")
    public Object checkSomethingAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Before in Around execution: "+ Arrays.toString(getRoles(joinPoint)));
        Object result = joinPoint.proceed();
        System.out.println("After in around execution");
        return result;
    }
}
