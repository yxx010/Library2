package service;

import dao.CategoryDaoImpl;
import model.Category;

import java.util.List;

public class CategoryServiceImpl {
    CategoryDaoImpl categoryDao=new CategoryDaoImpl();

    public void addCategory(String id, String categoryName) {
        if (!categoryIdIsExist(id)){
            categoryDao.addCategory(id, categoryName);
        }
    }
    public void deleteCategory(String id) {
        if (categoryIdIsExist(id)){
            categoryDao.deleteCategory(id);
        }
    }
    public boolean categoryIdIsExist(String id) {
        List<Category> list=categoryDao.getCategoryList();
        for (int i=0;i<list.size();i++){
            Category category=list.get(i);
            if(id!=null){
                if(category.getId().equals(id)){
                    return true;
                }
            }
        }
        return false;
    }
    public List<Category> getCategoryList(){
        return categoryDao.getCategoryList();
    }
}
