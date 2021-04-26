package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Phone;
import domain.ResultInfo;
import org.apache.commons.beanutils.BeanUtils;
import service.PhoneService;
import service.impl.PhoneServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateinfo")
public class UpdatePhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String ID=request.getParameter("phoneID");
        String phonemodel=request.getParameter("phonemodel");
        String phonecpu=request.getParameter("phonecpu");
        String phonename=request.getParameter("phonename");
        int phoneID=Integer.parseInt(ID);
        //封装类别对象
        Phone phone=new Phone(phoneID,phonemodel,phonecpu,phonename);

        //调用service
        PhoneService service =new PhoneServiceimpl();
        boolean flag=service.UpdatePhone(phone);
        ResultInfo info=new ResultInfo();
        if(flag){
            info.setstatus(200);
        }else {
            info.setstatus(500);
            info.setmessage("更改失败");
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
