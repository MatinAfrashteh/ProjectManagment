//package com.example.ProjectManagment.loggin;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//
//@org.aspectj.lang.annotation.Aspect
//@Component
//public class Aspect {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Pointcut("within(com.example.ProjectManagment.Controller..*)"
//    +"|| within(com.example.ProjectManagment.Repository..*)")
//    public void definePackegePointcuts(){
//    }
//
//    @Around("definePackegePointcuts()")
//    public Object logger(ProceedingJoinPoint jp){
//        log.debug("------ \n \n \n");
//        log.debug("******* after method execution ********* \n {}.{} () with arguments[s] = {}"
//        , jp.getSignature().getDeclaringTypeName(),
//          jp.getSignature().getName(), Arrays.toString((jp.getArgs())));
//        log.debug("------ \n \n \n");
//
//        Object o = null;
//        try {
//             o = jp.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//
//        log.debug("------ \n \n \n");
//        log.debug("******* after method execution ********* \n {}.{} () with arguments[s] = {}"
//                , jp.getSignature().getDeclaringTypeName(),
//                jp.getSignature().getName(), Arrays.toString((jp.getArgs())));
//        log.debug("------ \n \n \n");
//
//        return o;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
