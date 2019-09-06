package com.sandao.javalearning.proxy;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/04
 */
public class TargetImpl implements Target{
    @Override
    public int test(int i) {
        return i+1;
    }
}
