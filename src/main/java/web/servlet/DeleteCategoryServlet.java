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

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String phonemodel = request.getParameter("phonemodel");
        //封装类别对象
        Model model=new Model();
        model.setPhonemodel(phonemodel);
        ModelService service=new ModelServiceimpl();
        boolean flag=service.DeleteCategory(model);
        ResultInfo info=new ResultInfo();
        if(flag){
            info.setstatus(200);

        }else {
            info.setstatus(500);
            info.setmessage("无此选项");
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
