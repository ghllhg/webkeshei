package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Model;
import domain.Phone;
import domain.ResultInfo;
import service.ModelService;
import service.PhoneService;
import service.impl.ModelServiceimpl;
import service.impl.PhoneServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private ModelService modelService =new ModelServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询所有
        List<Model> mo=modelService.FindallCategory();
        ResultInfo info =new ResultInfo();
        //判断是否查询到
        if(mo!=null){
            info.setstatus(200);
            info.setData(mo);
        }else {
            info.setstatus(500);
            info.setmessage("无类别");
        }
        //序列化json
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }
}
