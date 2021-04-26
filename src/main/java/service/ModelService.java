package service;

import domain.Model;


import java.util.List;

public interface ModelService {
    //查找所有分类
    List<Model> FindallCategory();
    //查找所添加分类是否存在
    boolean AddFindCategory(Model model);
    //添加分类
    Model AddCategory(Model model);
    //删除手机分类
    boolean DeleteCategory(Model model);
}
