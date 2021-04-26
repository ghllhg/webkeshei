package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PageBean;
import domain.Phone;
import domain.ResultInfo;
import service.PhoneService;
import service.impl.PhoneServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info/*")
public class FindAllInfoServlet extends HttpServlet {
    private PhoneService service=new PhoneServiceimpl();
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String currentPageStr =request.getParameter("currentPage");
        String pageSizeStr=request.getParameter("pageSize");
        String cidStr=request.getParameter("cid");

        int cid=0;//类别id
        //处理参数
        if(cidStr!=null && cidStr.length()>0){
            cid=Integer.parseInt(cidStr);
        }

        int currentPage =0;//当前页码，如果不传递，默认第一页
        if(currentPageStr!=null&&currentPageStr.length()>0){
            currentPage=Integer.parseInt(currentPageStr);
        }else {
            currentPage=1;
        }
        int pageSize=0;//每页显示条数，如果不传递，默认每页显示5条
        if(pageSizeStr!=null&&pageSizeStr.length()>0){
            pageSize=Integer.parseInt(pageSizeStr);

        }else {
            pageSize=5;
        }
        //调用service查询PageBean对象
        PageBean<Phone> pb = service.pageQuery(cid, currentPage, pageSize);
        //将pageBean对象序列化为json
        ResultInfo info=new ResultInfo();
        if(pb!=null){
            info.setstatus(200);
            info.setData(pb);
        }else {
            info.setstatus(500);
        }
        //返回json
        //writeValue(info,response);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
