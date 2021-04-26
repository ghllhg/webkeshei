package service.impl;

import dao.PhoneDao;
import dao.impl.PhoneDaoimpl;
import domain.PageBean;
import domain.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceimpl implements PhoneService {

    private PhoneDao phoneDao=new PhoneDaoimpl();
    public  PageBean<Phone> pageQuery(int phoneID,int currentPage,int pageSize){
        //封装pageBean
        PageBean<Phone> pb=new PageBean<Phone>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount=phoneDao.findTotalCount(phoneID);
        pb.setTotalCount(totalCount);
        //设置当前页演示的数据集合
        int start=(currentPage-1)*pageSize;//开始的记录数
        List<Phone> list=phoneDao.FindallPhone(start,pageSize);
        pb.setList(list);
        //设置总页数
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Phone FindPhoneID(int phoneID) {
        return phoneDao.AddFindPhone(phoneID);
    }

    @Override
    public Phone AddPhone(Phone phone) {
        return phoneDao.AddPhone(phone);
    }

    @Override
    public boolean DeleteInfoPhone(Phone phone) {
        Phone p=phoneDao.AddFindPhone(phone.getPhoneID());
        if (p!=null){
            phoneDao.DeletePhone(phone);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean UpdatePhone(Phone phone) {
        Phone p=phoneDao.AddFindPhone(phone.getPhoneID());
        if (p!=null){
            phoneDao.UpdatePhone(phone);
            return true;
        }else {
            return false;
        }
    }


}
