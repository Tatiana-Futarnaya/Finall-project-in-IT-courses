package by.itclass.filters;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@WebFilter(filterName = "MultipartFilter", value = {AppConstant.FILE_UPLOAD_CONT,AppConstant.SAVE_NEWS_CONT}, dispatcherTypes = DispatcherType.REQUEST)//то есть при запросе от клиента
public class MultipartFilter implements Filter {
    private ServletFileUpload fileUpload;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;

        try {
            List<FileItem> itemList=fileUpload.parseRequest(request);
            for(FileItem item : itemList){
                if(item.isFormField()){//Если item явл. не file input-ом
                    request.setAttribute(item.getFieldName(), new String(item.getString().getBytes(), Charset.defaultCharset()));//default-ная кодировка которая поддерживается в данный момент системой
                    System.out.println("item.getFieldName()"+item.getFieldName());
                    System.out.println("item.getString()"+item.getString());
                }else{//то item явл. file input-ом
                    Image image=new Image(item.getName(),item.get());
                    System.out.println("item.getName()"+item.getName());
                    request.setAttribute(AppConstant.IMAGE_ATTR, image);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        File repository=(File)config.getServletContext().getAttribute(AppConstant.CONTEXT_TEMPDIR_ATTR);
        factory.setRepository(repository);
        fileUpload=new ServletFileUpload(factory);
    }

}
