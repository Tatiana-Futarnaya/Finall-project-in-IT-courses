package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.enums.ActionNews;
import by.itclass.model.enums.EnumManager;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SaveNewsController", value = AppConstant.SAVE_NEWS_CONT)
public class SaveNewsController extends AbstractNewsControllers {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getAttribute(AppConstant.ID_PARAMETER);
        String title = (String) request.getAttribute(AppConstant.TITLE_PARAMETER);
        String text = (String) request.getAttribute(AppConstant.TEXT_PARAMETER);
        String action = (String) request.getAttribute(AppConstant.ACTION_PARAMETER);
        Image image = (Image) request.getAttribute(AppConstant.IMAGE_ATTR);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);
        News news = new News(id, user.getId(), title, text, image);


        try {
            ActionNews actionNews = EnumManager.getKindActionNews(action);

            newsDAO.addNews(news, actionNews);
            redirect(response, AppConstant.USER_NEWS_LIST_CONT);
        } catch (IllegalArgumentException | SQLException | DAOException e) {
            e.printStackTrace();
        }
    }
}
