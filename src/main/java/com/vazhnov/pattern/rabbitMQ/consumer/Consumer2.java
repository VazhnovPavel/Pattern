package com.vazhnov.pattern.rabbitMQ.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.Console;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    private final static String QUEUE_NAME = "fortex-queue";
    static int count = 0;
    public static void main(String[] args) {

        //создаем фабрику коннектов
        ConnectionFactory factory = new ConnectionFactory();
        //указываем, что отправляться будем с локальной машины
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();

             Channel channel = connection.createChannel()) {
            //указываем, в какую очередь отправляем и параметры по умолчанию
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            //тут мы принимаем сообщение из очереди QUEUE_NAME, указываем кодировку
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'" + count++);
            };
            //связываем нашего консьюмера с очередью
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
            System.out.println(" [*] Subscribed to the queue " + QUEUE_NAME);
            System.in.read();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }


    }

}