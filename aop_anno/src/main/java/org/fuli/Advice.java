package org.fuli;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
    @Pointcut("execution(* org.fuli.service.*.*(..))")
    public void pointCut(){

    }
    @Before("execution(* org.fuli.service.*.*(..))")
    public void beforeAdvice(JoinPoint point){
        System.out.println("当前代理对象："+point.getTarget());
        System.out.println("前置增强");
    }
    @AfterReturning("pointCut()")
    public void afterAdvice(){
        System.out.println("后置增强");
    }
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object res = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("环绕后");
        return res;
    }
}
