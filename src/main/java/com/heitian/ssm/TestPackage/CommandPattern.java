package com.heitian.ssm.TestPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
interface Order {
    void execute();
}

class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("[Name:" + name + ",Quantity:" + quantity + "]bought");
    }

    public void sell() {
        System.out.println("Stock[Name:" + name + ",Quantity:" + quantity + "]sold");
    }
}

class BuyStock implements Order {
    private Stock abcSock;

    public BuyStock(Stock abcSock) {
        this.abcSock = abcSock;
    }

    public void execute() {
        abcSock.buy();
    }
}

class SellStock implements Order {
    private Stock abcSock;

    public SellStock(Stock abcSock) {
        this.abcSock = abcSock;
    }

    public void execute() {
        abcSock.sell();
    }
}
//通过该类整合执行命令
class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void replaceOrders() {
        for (Order order : orderList)
            order.execute();
        orderList.clear();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Stock abcStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.replaceOrders();
    }
}