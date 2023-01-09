package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.newsControllers.AbstractNewsControllers;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.User;
import by.itclass.model.exceptions.DAOException;
import by.itclass.model.files.ImageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "FileUploadController", value = AppConstant.FILE_UPLOAD_CONT)
public class FileUploadController extends AbstractUserController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute(AppConstant.USER_ATTR);
        Image image=(Image) request.getAttribute(AppConstant.IMAGE_ATTR);
        user.setImage(image);

        try {
            if (userDAO.saveImage(user)){
                ImageManager.createImage(getServletContext().getRealPath("/image"),image);
                forward(request, response, AppConstant.CABINET_JSP);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            forward(request, response, AppConstant.CABINET_JSP,e.getMessage());
        }

    }
}
