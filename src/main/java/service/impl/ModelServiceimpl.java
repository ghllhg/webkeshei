package service.impl;

import dao.ModelDao;
import dao.impl.ModelDaoimpl;
import domain.Model;
import service.ModelService;

import java.util.List;

public class ModelServiceimpl implements ModelService {

    private ModelDao modelDao=new ModelDaoimpl() {
    };
    @Override
    public List<Model> FindallCategory() {
        return modelDao.FindallCategory();
    }

    @Override
    public boolean AddFindCategory(Model model) {
        Model m=modelDao.AddFindCategory(model.getPhonemodel());
        if(m==null){
            //添加成功
            modelDao.AddCategory(model);
            return true;
        }else {
            //添加失败
            return false;
        }
    }

    @Override
    public Model AddCategory(Model model) {
        return modelDao.AddFindCategory(model.getPhonemodel());
    }

    @Override
    public boolean DeleteCategory(Model model) {
        Model m=modelDao.AddFindCategory(model.getPhonemodel());
        System.out.println("查询："+m);
        if(m!=null){
            //删除成功
            modelDao.DeleteCategory(model);
            return true;
        }else {
            //删除失败
            return false;
        }
    }
}
