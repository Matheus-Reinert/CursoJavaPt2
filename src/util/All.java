package util;

import entities.enums.OrderStatus;
import entitiesProject.Order;

import java.util.Date;

public class All {

    public static void enumerationProgram () {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED;

        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);


    }
}
