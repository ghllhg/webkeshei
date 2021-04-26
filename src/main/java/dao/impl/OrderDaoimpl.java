package dao.impl;

import dao.OerderDao;
import domain.Order;
import domain.Phone;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class OrderDaoimpl implements OerderDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int orderID) {
        String sql="select count(*) from order where orderID=?";
        return template.queryForObject(sql,Integer.class,orderID);
    }

    @Override
    public Order FindOrderID(int orderID) {
        Order order=null;
        try {
            String sql="select * from `order` where orderID=?";
            order=template.queryForObject(sql,new BeanPropertyRowMapper<Order>(Order.class),orderID);
        } catch (DataAccessException e) {

        }
        return order;
    }
    @Test
    public void test1(){
        OrderDaoimpl p=new OrderDaoimpl();
        Order order = p.FindOrderID(2);
        System.out.println(order);
    }
    @Override
    public List<Order> FindAllOrder(int start, int pageSize) {
        String sql="select * from order limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),start,pageSize);
    }
//insert into order(orderID,orderStatus,orderInformation,orderName) value(?,?,?,?)
    @Override
    public Order AddOrder(Order order) {
        String sql="insert into `order`(orderID, orderStatus, orderInformation, orderName) VALUE (?,?,?,?)";
        template.update(sql,order.getOrderID(),
                order.getOrderStatus(),
                order.getOrderInformation(),
                order.getOrderName());
        return order;
    }
//update order set orderStatus=? where orderID=?
    @Override
    public Order UpdateOrder(Order order) {
        String sql="update `order`set orderStatus=? where orderID=?";
        template.update(sql,order.getOrderStatus(),
                order.getOrderID());
        return order;
    }
    @Test
    public void te(){
        Order order =new Order();
        order.setOrderID(3);
        order.setOrderStatus("发货");
        OrderDaoimpl o=new OrderDaoimpl();
        o.UpdateOrder(order);
    }

    @Override
    public Order DeleteOrder(Order order) {
        String sql="delete from `order`where orderID =?";

        template.update(sql,order.getOrderID());

        return order;
    }
}
