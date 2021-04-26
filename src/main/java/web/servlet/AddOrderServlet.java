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

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    private OrderService service=new OrderServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String ID=request.getParameter("orderID");
        String orderStatus=request.getParameter("orderStatus");
        String orderInformation=request.getParameter("orderInformation");
        String ordername=request.getParameter("ordername");
        int orderID=Integer.parseInt(ID);
        //封装对象
        Order order=new Order(orderID,orderStatus,orderInformation,ordername);

        //调用service
        boolean flag=service.AddOrder(order);
        ResultInfo info=new ResultInfo();
        if(flag){
            info.setstatus(200);
        }else {
            info.setstatus(500);
            info.setmessage("添加失败");
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
