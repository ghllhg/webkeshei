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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class loginUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取用户名和密码
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        //封装User对象
        User user=new User();
        user.setUsername(name);
        user.setPassword(password);
        //调用service查询
        UserService service=new UserServiceimpl();
        User u=service.login(user);

        ResultInfo info=new ResultInfo();

        //判断用户对象是否为null
        if(u==null){
            //用户密码错误
            info.setstatus(500);
            info.setmessage("用户名或密码错误");
        }else {
            //登陆成功
            info.setstatus(200);
        }
        //返回json
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);


    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
