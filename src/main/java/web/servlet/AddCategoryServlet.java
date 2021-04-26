package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Model;
import domain.ResultInfo;
import org.apache.commons.beanutils.BeanUtils;
import service.ModelService;
import service.impl.ModelServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String phonemodel=request.getParameter("phonemodel");
        //封装类别对象
        System.out.println("获取的"+phonemodel);
        Model model=new Model();
        model.setPhonemodel(phonemodel);
        System.out.println("对象中"+model.getPhonemodel());
        //调用service查询
        ModelService service =new ModelServiceimpl();
        boolean flag=service.AddFindCategory(model);
        ResultInfo info=new ResultInfo();
        if(flag){
            info.setstatus(200);
            info.setData(service.AddCategory(model));
        }else {
            info.setstatus(500);
            info.setmessage("已有此选项");
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
