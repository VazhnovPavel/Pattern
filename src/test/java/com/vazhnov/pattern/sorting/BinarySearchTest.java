package com.vazhnov.pattern.sorting;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {


        @Test
        public void testBinaryIndexOf() {
            // Создаем массив для тестирования
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            // Ожидаемый индекс элемента
            int expectedIndex = 5;

            // Вызываем метод напрямую
            int resultIndex = BinarySearch.binaryIndexOf(array, 6);

            // Проверяем, что полученный индекс соответствует ожидаемому
            assertEquals(expectedIndex, resultIndex);
        }


}
