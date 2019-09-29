package model;

public class Book {
    //  类型描述：能够描述图书ID、图书名、图书分类名、价格、描述等
    //          方法：构造方法、get和set方法，toString()方法
    private String id;
    private String name;
    private Category category;
    private String price;
    private String des;



    public Book(){

    }
    public Book(String id, String name, Category category,String price, String des) {
        this.id = id;
        this.name = name;
        this.category=category;
        this.price = price;
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
