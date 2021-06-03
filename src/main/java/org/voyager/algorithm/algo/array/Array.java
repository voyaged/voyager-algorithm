package org.voyager.algorithm.algo.array;

import lombok.extern.slf4j.Slf4j;
import org.voyager.algorithm.utils.Arrays;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * @author caiweiquan
 * @since 2021/6/3
 */
@Slf4j
public class Array {
    // 定义整型数据data保存数据
    public int[] data;
    // 定义数组长度
    private final int n;
    // 定义中实际个数
    private int count;

    // 构造方法，定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
    }

    // 根据索引，找到数据中的元素并返回
    public int find(int index){
        if (index < 0 || index >= count) { return -1; }
        return data[index];
    }

    /**
     * 插入元素:头部插入，尾部插入
     * @param index 插入索引
     * @param value 插入值
     * @return 执行结果 <code>true</code>:插入成功,<code>false</code>:插入失败
     */
    public boolean insert(int index, int value){
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
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        // 2.插入元素
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index){
        //region 校验
        // 位置不合法
        if (index<0 || index >=count) {
            log.error("位置不合法");
            return false;
        }
        //endregion

        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}