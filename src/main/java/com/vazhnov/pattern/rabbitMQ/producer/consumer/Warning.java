package com.vazhnov.pattern.rabbitMQ.producer.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
public class Warning {
    static int count = 0;
    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String WARNING_QUEUE_NAME = "warning";

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
            channel.queueDeclare(WARNING_QUEUE_NAME, true, false, false, null);

            // Связываем новую очередь с обменником, указывая только нужный ключ маршрутизации "error"
            channel.queueBind(WARNING_QUEUE_NAME, EXCHANGE_NAME, "warning");

            System.out.println(" [*] Waiting for error messages. To exit press CTRL+C");

            // Устанавливаем обработчик сообщений для новой очереди
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'" + count++);
            };

            // Начинаем потребление сообщений из новой очереди
            channel.basicConsume(WARNING_QUEUE_NAME, true, deliverCallback, consumerTag -> {});
            System.in.read();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
