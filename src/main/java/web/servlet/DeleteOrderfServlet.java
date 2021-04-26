package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;
import domain.ResultInfo;
import service.OrderService;
import service.impl.OrderServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrder")
public class DeleteOrderfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String ID=request.getParameter("orderID");
        int orderID=Integer.parseInt(ID);
        //
        Order order=new Order();
        order.setOrderID(orderID);
        //service
        OrderService service =new OrderServiceimpl();
        boolean flag=service.DeleteOrder(order);
        ResultInfo info=new ResultInfo();
        if(flag){
            info.setstatus(200);
        }else {
            info.setstatus(500);
            info.setmessage("无此ID，删除失败");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
