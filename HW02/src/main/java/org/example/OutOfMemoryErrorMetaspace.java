package org.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class OutOfMemoryErrorMetaspace {

    public static void main(String[] args) {
        // 无限循环生成动态类
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OutOfMemoryErrorMetaspace.class);
            enhancer.setUseCache(false); // 禁用缓存，确保每次生成新的类
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });

            // 创建动态代理类
            enhancer.create();
        }
    }
}