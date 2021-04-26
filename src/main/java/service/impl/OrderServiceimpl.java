package service.impl;

import dao.OerderDao;
import dao.impl.OrderDaoimpl;
import domain.Order;
import domain.PageBean;
import org.junit.Test;
import service.OrderService;
import java.util.List;

public class OrderServiceimpl implements OrderService {
    private OerderDao orderDao=new OrderDaoimpl();
    @Override
    public PageBean<Order> pageQuery(int orderID, int currentPage, int pageSize) {
        //封装pageBean
        PageBean<Order> pb=new PageBean<Order>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount=orderDao.findTotalCount(orderID);
        pb.setTotalCount(totalCount);
        //设置当前页演示的数据集合
        int start=(currentPage-1)*pageSize;//开始的记录数
        List<Order> list=orderDao.FindAllOrder(start,pageSize);
        pb.setList(list);
        //设置总页数
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Order FindOrderID(int orderID) {
        return orderDao.FindOrderID(orderID);
    }

    @Override
    public boolean AddOrder(Order order) {
        Order o=orderDao.FindOrderID(order.getOrderID());
        if(o==null){
             orderDao.AddOrder(order);
             return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean UpdateOrder(Order order) {
        Order o=orderDao.FindOrderID(order.getOrderID());
        if(o!=null){
            orderDao.UpdateOrder(order);
            return true;
        }else {
            return false;
        }
       }

    @Override
    public boolean DeleteOrder(Order order) {
        Order o=orderDao.FindOrderID(order.getOrderID());
        System.out.println(o);
        if(o!=null){
            orderDao.DeleteOrder(order);
            return true;
        }else {
            return false;
        }
    }
    @Test
    public void t1(){
        OrderDaoimpl o=new OrderDaoimpl();
        Order order=new Order();
        order.setOrderID(2);
        o.DeleteOrder(order);
    }
}
