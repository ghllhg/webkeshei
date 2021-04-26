package service;

import domain.Order;
import domain.PageBean;

public interface OrderService {
    //分页展示订单
    PageBean<Order> pageQuery(int order,int currentPage, int pageSize);
    //根据订单号查询订单
    Order FindOrderID(int orderID);
    //添加订单
    boolean AddOrder(Order order);
    //修改订单
    boolean UpdateOrder(Order order);
    //删除订单
    boolean DeleteOrder(Order order);
}
