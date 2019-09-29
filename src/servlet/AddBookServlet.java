package servlet;

import model.Book;
import model.Category;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.BookServiceImpl;
import service.CategoryServiceImpl;
import service.LibServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServiceImpl bookService=new BookServiceImpl();
        Map<String,String> map=new HashMap();
        String bookPic=null;
        //1.创建磁盘文件项工厂
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        //2.创建核心解析类
        ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);
        //3.解析请求对象
        try {
            List<FileItem> list=fileUpload.parseRequest(request);
            //4.遍历集合获取每个部分的对象
            for(FileItem fileItem:list){
                //判断是普通项，还是文件上传项
                if(fileItem.isFormField()){
                    String name=fileItem.getFieldName();
                    String value=fileItem.getString();
                    map.put(name,value);
                }else{
                    //获取文件的输入流
                    String fileName=fileItem.getName();
                    if(!fileName.isEmpty()){
                    InputStream is=fileItem.getInputStream();
                    //将文件写到另外一个路径
                    String path=getServletContext().getRealPath("/img");
                    System.out.println(path);
                    //创建输出流与输入流对接,图片
                    OutputStream fos=new FileOutputStream(path+"/"+fileName);
                    int len=0;
                    byte []b=new byte[1024];
                    while ((len=is.read(b))!=-1){
                        fos.write(b,0,len);
                    }
                    is.close();
                    fos.close();
                    bookPic=fileName;
                }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String id=map.get("bookId");
        String bookName=map.get("bookName");
        String categoryId=map.get("categoryId");
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        Category category=categoryService.searchCategoryById(categoryId);
        String price=map.get("bookPrice");
        String description=map.get("remarks");

        if(bookService.getBookByBookId(id)==null){
            Book book=new Book(id,bookName,category,price,bookPic,description);
            bookService.addBook(book);
            response.getWriter().println("添加成功");
            response.sendRedirect("/searchBook");
        }else {
            response.getWriter().println("该书已存在");
            response.sendRedirect("/addBook.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
