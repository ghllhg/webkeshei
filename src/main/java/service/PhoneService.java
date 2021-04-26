package service;

import domain.PageBean;
import domain.Phone;

import java.util.List;

public interface PhoneService {
    //分页显示手机信息
     PageBean<Phone> pageQuery(int phoneID, int currentPage, int pageSize);
    //根据ID查找手机信息
    Phone FindPhoneID(int phoneID);
    //添加手机信息
    Phone AddPhone(Phone phone);
    //删除手机信息
    boolean DeleteInfoPhone(Phone phone);
    //修改手机信息
    boolean UpdatePhone(Phone phone);
}
