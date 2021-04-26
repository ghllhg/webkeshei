package dao;

import domain.Order;

import java.util.List;

public interface OerderDao {
    //查找全部记录条数
    int findTotalCount(int orderID);
    //查找订单
    Order FindOrderID(int orderID);
    //查询所有订单
    List<Order> FindAllOrder(int start,int pageSize);
    //添加订单
    Order AddOrder(Order order);
    //修改订单
    Order UpdateOrder(Order order);
    //删除订单
    Order DeleteOrder(Order order);
}
