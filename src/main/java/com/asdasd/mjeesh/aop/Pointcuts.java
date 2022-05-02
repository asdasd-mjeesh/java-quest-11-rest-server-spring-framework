package com.asdasd.mjeesh.aop;

import org.aspectj.lang.annotation.Pointcut;

class Pointcuts {

    @Pointcut("execution(* com.asdasd.mjeesh.service.product.ProductServiceImpl.*(..))")
    public void allMethodsInProductServicePointcut() {  /* pointcut */  }
}
