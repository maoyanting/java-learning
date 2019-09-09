package com.sandao.javalearning.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 更多关于 CGlib 代理：https://www.jianshu.com/p/9a61af393e41?isappinstalled=0
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/04
 */
public class CglibProxyTest implements MethodInterceptor {

    private CglibProxyTest() {
    }

    public static <T extends Target> Target newProxyInstance(Class<T> targetInstanceClazz) {
        //CGLIB的字节码增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyTest());
        return (Target) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return proxy.invokeSuper(obj, args);
    }

}
