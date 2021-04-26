package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Phone;
import domain.ResultInfo;
import org.junit.Test;
import service.PhoneService;
import service.impl.PhoneServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteInfo")
public class DeleteInfoServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String phoneID1=request.getParameter("phoneID");
        System.out.println("获取到的phoneID"+phoneID1);
        int phoneID=2;
        phoneID=Integer.parseInt(phoneID1);
        System.out.println("获取到的phoneID"+phoneID);
        //
        Phone phone=new Phone();
        phone.setPhoneID(phoneID);
        //service
        PhoneService service=new PhoneServiceimpl();
        boolean flag=service.DeleteInfoPhone(phone);
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

    /*public static void main(String[] args) {
        int phoneID=3;
        //service
        PhoneService service=new PhoneServiceimpl();
        Phone phone=service.FindPhoneID(phoneID);
        Phone flag=service.DeleteInfoPhone(phone);
        if(flag!=null){
            System.out.println("ture");
        }else {
            System.out.println("flase");
        }
    }*/
}
