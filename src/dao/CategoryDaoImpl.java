package dao;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl {
    private static final List<Category> categorys = new ArrayList<>();
    public void addCategory(String id, String categoryName) {
        Category category=new Category(id,categoryName);
        categorys.add(category);
    }
    public static List<Category> getCategoryList() {
        categorys.clear();
        Category category1=new Category("ca0001","计算机");
        Category category2=new Category("ca0002","文学");
        categorys.add(category1);
        categorys.add(category2);
        return categorys;
    }
    public void deleteCategory(String id) {
        for (int i = 0; i <categorys.size() ; i++) {
            if(categorys.get(i).getId().equals(id)){
                categorys.remove(i);
                return;
            }
        }
    }

}
