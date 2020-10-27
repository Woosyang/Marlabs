package com.activemq.recipes;
import javax.jms.*;

public class EventListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            float price = message.getFloatProperty("price");
            String symbol = message.getStringProperty("symbol");
            System.out.println("Price Update: " + symbol + "[$" + price + "]");
        } catch (Exception e) {
            System.out.println("Worker caught an Exception");
        }
    }
}