package com.vazhnov.pattern.rabbitMQ.producer.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class All {
    static int count = 0;

    private final static String EXCHANGE_NAME = "direct_logs";
    private final static String QUEUE_NAME = "fortex-queue";
    public static void main(String[] args) {
        //создаем фабрику коннектов
        ConnectionFactory factory = new ConnectionFactory();
        //указываем, что отправляться будем с локальной машины
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();

             Channel channel = connection.createChannel()) {
            //объявим наш exchange заранее, чтобы он точно существовал
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            //указываем, в какую очередь отправляем и параметры по умолчанию
            var queueName=  channel.queueDeclare().getQueue();
            //связываем с всеми очередями
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"warning");
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"error");
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            count++;
            //тут мы принимаем сообщение из очереди QUEUE_NAME, указываем кодировку
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'" + count++);
            };
            //связываем нашего консьюмера с очередью
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });
            System.out.println(" [*] Subscribed to the queue " + queueName);
            System.in.read();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
