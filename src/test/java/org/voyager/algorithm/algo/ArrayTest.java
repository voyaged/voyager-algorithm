package org.voyager.algorithm.algo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.voyager.algorithm.algo.array.Array;

/**
 * @author caiweiquan
 * @since 2021/6/3
 */
@Slf4j
public class ArrayTest {
    @Test
    public void testInsert() {
        Array<Integer> array = new Array<>(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.insert(3, 11);
        log.info("array {}", array); // ask array [4,5,3,10,9]
    }

    @Test
    public void testDelete(){
        Array<Integer> array = new Array<>(10, 9, 8, 7, 6);
        array.delete(2);
        array.delete(0);
        log.info("array {}", array); // ask array [9, 7, 6]
    }
}
