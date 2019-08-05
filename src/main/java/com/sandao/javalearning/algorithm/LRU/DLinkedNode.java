package com.sandao.javalearning.algorithm.LRU;

import lombok.Data;

/**
 * 双向链表
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/05
 */
public class DLinkedNode {
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}
