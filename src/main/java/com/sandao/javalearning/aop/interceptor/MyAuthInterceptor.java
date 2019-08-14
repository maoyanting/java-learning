package com.sandao.javalearning.aop.interceptor;

import com.sandao.javalearning.aop.annotation.MyAuth;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/13
 */
@Component
@Aspect
@Slf4j
public class MyAuthInterceptor {

    @Around("execution(* com.sandao.javalearning.aop..*(..))&&@annotation(myAuth)")
    public Object judgeAuth(ProceedingJoinPoint point, MyAuth myAuth) throws Throwable {
        String className = myAuth.className();
        log.info("拦截器返回"+className);

        //获取拦截的方法的入参值
        Object[] param = point.getArgs();
        //获取拦截的方法的入参名
        String[] argNames = ((MethodSignature) point.getSignature()).getParameterNames();
        //组装，一一对应的
        Map<String, Object> paramMap = new HashMap<>(argNames.length * 2);
        for (int i = 0; i < argNames.length; i++) {
            paramMap.put(argNames[i], param[i]);
        }
        //执行方法体
        return point.proceed();
    }
}
