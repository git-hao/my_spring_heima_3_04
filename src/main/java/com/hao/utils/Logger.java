package com.hao.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Describe com.hao.utils
 * @Auther wenhao chen
 * @CreateDate 2019/8/10
 * @Version 1.0
 *
 * 记录日志工具类，提供公共代码
 */
public class Logger {
    //打印日志，在切入点方法执行之前执行，切入点方法就是业务层方法
    public void beforePrintLog(){
        System.out.println("前置通知，beforePrintLog，开始记录日志---");
    }
    public void afterReturningPrintLog(){
        System.out.println("后置通知，afterReturningPrintLog---");
    }
    public void afterThrowingPrintLog(){
        System.out.println("异常通知，afterThrowingPrintLog---");
    }
    public void afterPrintLog(){
        System.out.println("最终通知，afterPrintLog---");
    }

    /**
     * 环绕通知。
     * 问题：
     *      配置了环绕通知后，切入点方法没有执行，只执行了通知方法
     * 分析：
     *      对比动态代理中的环绕通知，发现动态代理中有明确的切入点方法调用，我们的代码中没有
     * 解决：
     *      Spring框架提供了一个接口，ProceedingJoinPoint。该接口的方法proceed(),相当于明确的切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，Spring框架会为我们提供该接口的实现类，供使用
     *
     *
     * Spring中的环绕通知：
     *      是Spring框架提供的一种可以在代码中手动控制增强方法何时执行的方法
     */
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
        Object rtValue = null;
        try{
            //得到方法执行所需参数
            Object[] args = joinPoint.getArgs();
            //根据通知代码所处位置，决定是什么通知
            System.out.println("环绕通知，aroundPrintLog---前置通知");
            //明确要调用的业务层方法，即切入点方法
            rtValue = joinPoint.proceed(args);

            System.out.println("环绕通知，aroundPrintLog---后置通知");
            return rtValue;

        }catch (Throwable t){
            System.out.println("环绕通知，aroundPrintLog---异常通知");
            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知，aroundPrintLog---最终通知");
        }


    }
}
