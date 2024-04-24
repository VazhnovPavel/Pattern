package com.vazhnov.pattern.rabbitMQ;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    private final static String QUEUE_NAME = "fortex-queue";
    private final static String MESSAGE = "Hello World!";
    public static void main(String[] args) {
        //создаем фабрику коннектов
        ConnectionFactory factory = new ConnectionFactory();
        //указываем, что отправляться будем с локальной машины
        factory.setHost("localhost");

        //Коннекшн будет управлять версией протокола, аутентификацией и т.д.
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //указываем, в какую очередь отправляем и параметры по умолчанию
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            String message = MESSAGE;
            //публикуем сообщение в очередь
            //нам нужно обязательно перевестти строку в байты, поэтому используем message.getBytes())
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
