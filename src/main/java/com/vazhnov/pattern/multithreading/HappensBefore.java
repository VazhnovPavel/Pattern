package com.vazhnov.pattern.multithreading;

/**
 В этом примере у нас есть два потока: t1 и t2. Поток t1 устанавливает значение переменной x в 1 и делает переменную
 ready истинной. Поток t2 ждет, пока ready станет истинной, после чего выводит значение x.
 Поскольку поток t2 видит изменение значения x, выполненное потоком t1, это означает, что существует
 отношение happens-before между этими двумя действиями.
 */

public class HappensBefore {
        public static int x = 0;
        public static boolean ready = false;
        public static int result = 0;

        public static void main(String[] args) throws InterruptedException {
            // Создаем два потока
            Thread t1 = new Thread(() -> {
                x = 1;
                ready = true;
            });
            Thread t2 = new Thread(() -> {
                while (!ready) {
                    // Ждем, пока переменная ready не станет истинной
                }
                System.out.println(x);
            });

            // Запускаем потоки
            t1.start();
            t2.start();

            // Ждем завершения обоих потоков
            t1.join();
            t2.join();
        }
    }

