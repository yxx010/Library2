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
