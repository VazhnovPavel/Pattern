package com.vazhnov.pattern.rabbitMQ.producer.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
public class Error {
    static int count = 0;
    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String ERROR_QUEUE_NAME = "error";

    public static void main(String[] args) {
        // Создаем фабрику коннектов
        ConnectionFactory factory = new ConnectionFactory();
        // Указываем, что отправляться будем с локальной машины
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // Объявляем обменник
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // Создаем отдельную очередь только для сообщений с ключом маршрутизации "error"
            channel.queueDeclare(ERROR_QUEUE_NAME, true, false, false, null);

            // Связываем новую очередь с обменником, указывая только нужный ключ маршрутизации "error"
            channel.queueBind(ERROR_QUEUE_NAME, EXCHANGE_NAME, "error");

            System.out.println(" [*] Waiting for error messages. To exit press CTRL+C");

            // Устанавливаем обработчик сообщений для новой очереди
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'" + count++);
            };

            // Начинаем потребление сообщений из новой очереди
            channel.basicConsume(ERROR_QUEUE_NAME, true, deliverCallback, consumerTag -> {});
            System.in.read();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}


