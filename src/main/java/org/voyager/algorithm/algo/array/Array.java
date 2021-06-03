package org.voyager.algorithm.algo.array;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * @author caiweiquan
 * @since 2021/6/3
 */
@Slf4j
public class Array<T> {
    // 定义整型数据data保存数据
    public Object[] data;
    // 定义数组长度
    private final int n;
    // 定义中实际个数
    private int count;

    // 构造方法，定义数组大小
    public Array(int capacity){
        this.data = new Object[capacity];
        this.n = capacity;
    }

    public Array(@NotNull T... data) {
        this.data = data;
        this.n = data.length;
        this.count = data.length;
    }

    // 根据索引，找到数据中的元素并返回
    @SuppressWarnings("unchecked")
    public T find(int index){
        if (index < 0 || index >= count) { return null; }
        return (T) data[index];
    }

    /**
     * 插入元素:头部插入，尾部插入
     * @param index 插入索引
     * @param value 插入值
     * @return 执行结果 <code>true</code>:插入成功,<code>false</code>:插入失败
     */
    public boolean insert(int index,T value){
        //region 校验
        // 数组空间已满
        if (count == n) {
            log.error("没有可插入的位置");
            return false;
        }
        // 位置不合法
        if (index < 0 || index > count) {
            log.error("位置不合法");
            return false;
        }
        //endregion

        // 1.数据搬迁操作:从插入索引开始到末索引
        System.arraycopy(data, index, data, index + 1, count - index);

        // 2.插入元素
        data[index] = value;
        ++count;
        return true;
    }

    // 根据索引，删除数组中元素
    public boolean delete(int index){
        //region 校验
        // 位置不合法
        if (index < 0 || index >= count) {
            log.error("位置不合法");
            return false;
        }
        //endregion

        // 1.数据搬迁操作: 从删除位置开始，将后面的元素向前移动一位
        System.arraycopy(data, index + 1, data, index, count - index - 1);
        data[count - 1] = null;

        // 2.实际个数减一
        --count;
        return true;
    }

    @Override
    public String toString() {
        if (data == null) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0,maxIndex = count - 1;; i++) {
            b.append(data[i]);
            if (i == maxIndex) { return b.append("]").toString(); }
            b.append(",");
        }
    }
}