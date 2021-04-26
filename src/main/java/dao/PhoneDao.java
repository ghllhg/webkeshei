package dao;

import domain.Phone;

import java.util.List;

public interface PhoneDao {
    //查找全部记录条数
    int findTotalCount(int phoneID);
    //查找全部手机信息
    List<Phone> FindallPhone(int start,int pageSize);
    //添加手机信息
    Phone AddPhone(Phone phone);
    //添加查询
    Phone AddFindPhone(int phoneID);
    //更改手机信息
    Phone UpdatePhone(Phone phone);
    //删除手机信息
    Phone DeletePhone(Phone phone);
}
