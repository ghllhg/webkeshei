package web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/regist")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取验证码
        String check = request.getParameter("check");
        HttpSession session=request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        System.out.println("验证码：");
        System.out.println(checkcode_server+"");
        session.removeAttribute("CHECKCODE_SERVER");//保证验证码只能使用一次
        //比较
        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info=new ResultInfo();
            info.setstatus(200);
            info.setmessage("验证码错误");
            ObjectMapper mapper=new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            //将json数据写回客户端
            //设置content-type
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        }
        //获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String phone1 =request.getParameter("phone");

        String email=request.getParameter("email");
        //封装对象
        int phone=Integer.parseInt(phone1);
        User user=new User(phone,username,password,email);

        //调用service完成注册
        UserService service=new UserServiceimpl();
        boolean flag=service.regist(user);
        ResultInfo info=new ResultInfo();

        //响应结果
        if(flag){
            //注册成功
            info.setstatus(200);
            System.out.println("注册成功");
        }else {
            //注册失败
            info.setstatus(500);
            System.out.println("注册失败");
            info.setmessage("注册失败");
              }
//        将info对象序列化为json

        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
