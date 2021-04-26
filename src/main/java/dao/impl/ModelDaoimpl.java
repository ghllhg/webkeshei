package dao.impl;

import dao.ModelDao;
import domain.Model;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class ModelDaoimpl implements ModelDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Model> FindallCategory() {
        String sql="select *from  model";
        return template.query(sql, new BeanPropertyRowMapper<Model>(Model.class));
    }

    @Override
    public Model AddCategory(Model model) {
        String sql="insert into model(phonemodel) value(?)";
        try {
            template.update(sql,model.getPhonemodel());
        }catch (Exception e){
            System.out.println("添加失败");
        }

        return model;
    }

    @Override
    public Model AddFindCategory(String phonemodel) {
        Model model=null;
        try {
            String sql="select * from model where phonemodel=?";
            model=template.queryForObject(sql,new BeanPropertyRowMapper<Model>(Model.class),phonemodel);
        } catch (DataAccessException e) {

        }
        return model;
    }

    @Override
    public List<Model> UpdateCategory() {
        return null;
    }

    @Override
    public Model DeleteCategory(Model model) {
        String sql="delete from model where phonemodel =?";

        template.update(sql,model.getPhonemodel());

        return model;
    }

    //main测试
    /*public static void main(String[] args) {
        Model m=new Model("2");
        ModelDao md=new ModelDaoimpl();
        md.DeleteCategory(m);
    }*/

}





















