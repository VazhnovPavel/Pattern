package com.vazhnov.pattern.sorting;

import java.util.*;


/**
 *   Задание:
 *         Сначала программа должна запросить у пользователя два числа: количество префиксов и количество запросов.
 *         Далее программа должна запросить у пользователя ввод указанного количества префиксов, каждый из которых
 *         вводится с новой строки.
 *         Затем программа должна запросить у пользователя ввод указанного количества запросов. Каждый запрос
 *         состоит из числа и строки, разделённых пробелом.
 *         Для каждого запроса программа должна определить, какие префиксы из списка начинаются с указанной в
 *         запросе строки, собрать эти префиксы в новый список и отсортировать его.
 *         Программа должна вывести позицию префикса в изначальном списке, соответствующую порядковому номеру,
 *         указанному числом в запросе (нумерация начинается с 1).
 */


public class Sortirovka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число префиксов и количество обращений");
        int countPrefix = scanner.nextInt();
        int countRequest = scanner.nextInt();
        System.out.println("Введите "+ countPrefix + " преффиксов");
        scanner.nextLine();
        //Заполняем список преффиксов
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < countPrefix ; i++) {
            list.add(scanner.nextLine());
        }

        System.out.println("Введите "+ countRequest + " запросов");
        Map<Integer,String> mapRequest = new HashMap<>();
        for (int i = 0; i < countRequest; i++) {
            int key = scanner.nextInt();
            String value = scanner.next();
            mapRequest.put(key, value);
        }

        for (Map.Entry<Integer, String> entry : mapRequest.entrySet()) {

                //собираем коллекцию с совпадающим префиксом и сортируем ее
                ArrayList<String> currentList = new ArrayList<>();
                for (int j = 0; j < list.size()  ; j++) {
                    if (list.get(j).startsWith(entry.getValue()))
                        currentList.add(list.get(j));
                }
                Collections.sort(currentList);

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(currentList.get(entry.getKey() -1 )))
                        System.out.println(i+1);
                }
                }
    }
}
