package com.vazhnov.pattern.decoding;

import java.util.Base64;
/**
 * Задача: расшифровать строку
 * Была на вступлении при общении с HR Яндекса
 */

public class Decoding_Yandex {

    public static void main(String[] args) {

        // Исходная строка в формате Base64
        String base64String = "SmF2YSDQvdC1INGC0L7RgNC80L7Qt9C40YIhCg==";

        // Декодирование строки из Base64
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        // Преобразование байтов в строку
        String decodedString = new String(decodedBytes);

        // Вывод декодированной строки на экран
        System.out.println(decodedString);
    }
}
