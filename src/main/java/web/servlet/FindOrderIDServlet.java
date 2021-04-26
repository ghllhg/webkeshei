package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;
import domain.Phone;
import domain.ResultInfo;
import service.OrderService;
import service.PhoneService;
import service.impl.OrderServiceimpl;
import service.impl.PhoneServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order:id")
public class FindOrderIDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数ID
        String ID=request.getParameter("orderID");
        int orderID=Integer.parseInt(ID);
        //service
        OrderService service=new OrderServiceimpl();

        Order order=service.FindOrderID(orderID);
        ResultInfo info=new ResultInfo();
        //判断phone对象
        if (order!=null){
            info.setstatus(200);
            info.setData(order);
        }else {
            info.setstatus(500);
            info.setmessage("无此ID的手机信息");
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
