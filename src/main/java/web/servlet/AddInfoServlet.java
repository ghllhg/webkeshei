package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Model;
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

@WebServlet("/addInfo")
public class AddInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String phoneID = request.getParameter("phoneID");
        int ID=Integer.parseInt(phoneID);
        String phonemodel = request.getParameter("phonemodel");
        String phonecpu = request.getParameter("phonecpu");
        String phonename = request.getParameter("phonename");
        //封装类别对象
        Phone phone=new Phone(ID,phonemodel,phonecpu,phonename);

        //调用service
        PhoneService service=new PhoneServiceimpl();
        Phone flag=service.FindPhoneID(phone.getPhoneID());
        Phone p=service.AddPhone(phone);
        ResultInfo info=new ResultInfo();
        if(flag==null&&p!=null){
            info.setstatus(200);
            info.setData(p);
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
