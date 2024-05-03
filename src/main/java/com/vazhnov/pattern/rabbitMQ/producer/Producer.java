package com.vazhnov.pattern.rabbitMQ.producer;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
/**
 * Запускает 3 потока и выводит в лог сообщения с разной переодичностью и разным routing key
 */
public class Producer {
    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String MESSAGE = "Message type [%s] from publisher N ";

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        producer.Start(5000, "error");
        producer.Start(10000, "warning");
        producer.Start(2000, "info");

        // Ожидаем ввода данных от пользователя
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }

    private void Start(int maxTimeToSleep, String routingKey) {
        new Thread(() -> {
            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
                try (Connection connection = factory.newConnection();
                     Channel channel = connection.createChannel()) {
                    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
                    int count = 0;
                    while (true) {
                        int timeToSleep = new Random().nextInt(1000, maxTimeToSleep);
                        Thread.sleep(timeToSleep);

                        String message = String.format(MESSAGE, routingKey);
                        channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
                        System.out.println(" [x] Sent " + message + " is sent into Direct Exchange " + (++count));
                    }
                }
            } catch (IOException | TimeoutException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}



