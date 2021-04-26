package dao;

import domain.Model;
import domain.Phone;

import java.util.List;

public interface ModelDao {
    //查找全部手机
    List<Model> FindallCategory();
    //添加手机类别
    Model AddCategory(Model model);
    //查找指定手机类别
    Model AddFindCategory(String phonemodel);
    //更改手机类别
    List<Model> UpdateCategory();
    //删除手机类别
    Model DeleteCategory(Model model);
}
