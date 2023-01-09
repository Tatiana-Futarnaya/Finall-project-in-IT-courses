package by.itclass.model.dao.newsDAO;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.db.jdbc.ConnectionManager;
import by.itclass.model.db.jdbc.SQLRequest;
import by.itclass.model.enums.ActionNews;
import by.itclass.model.enums.RatingNews;
import by.itclass.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewsMySqlDAOImpl implements INewsDAO{
    @Override
    public List<News> getNewsList(int idUser) throws DAOException {
        List<News> newsList=new ArrayList<>();
        String idUserTmp= String.valueOf(idUser);
        try(Connection cn= ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.SELECT_NEWS_BY_ID_USER)) {

            pst.setString(1, String.valueOf(idUser));

            ResultSet rs= pst.executeQuery();
            while (rs.next()){
                if(idUserTmp.equals(String.valueOf(idUser))){
                    int id=rs.getInt(SQLRequest.ID);
                    String title=rs.getString(SQLRequest.TITLE);
                    String text=rs.getString(SQLRequest.TEXT);
                    String name=rs.getString(SQLRequest.NAME);
                    byte[] content=rs.getBytes(SQLRequest.CONTENT);
                    Image image=new Image(name,content);
                    newsList.add(new News(id,idUser,title,text, image));

                }
                System.out.println("newsList: "+newsList);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return newsList;
    }


    public void updateImagesNews(News news) throws SQLException {
        Image image=news.getImage();
        try(Connection cn= ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.UPDATE_IMAGE_BY_ID_NEWS)) {
            pst.setString(1, image.getName());
            pst.setBytes(2, image.getContent());
            pst.setInt(3, news.getId());
            pst.executeUpdate();
        }
    }

    @Override
    public void remove(String id, User user) throws DAOException {
        try(Connection cn=ConnectionManager.getConnection();
        PreparedStatement pst=cn.prepareStatement(SQLRequest.DELETE_NEWS_BY_ID)) {
            pst.setString(1,id);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        removeImageNews(id,user);
    }

    @Override
    public void removeImageNews(String id, User user) throws DAOException {
        try(Connection cn=ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.DELETE_IMAGE_NEWS_BY_ID)) {
            pst.setString(1,id);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public News getNewById(int id) throws DAOException {
        News news=null;
        try(Connection cn=ConnectionManager.getConnection();
        PreparedStatement pst=cn.prepareStatement(SQLRequest.SELECT_NEWS_BY_ID)) {
            pst.setString(1, String.valueOf(id));
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                int idUser=rs.getInt(SQLRequest.ID_USER);
                String title=rs.getString(SQLRequest.TITLE);
                String text=rs.getString(SQLRequest.TEXT);
                int rating=rs.getInt(SQLRequest.RATING);
                String name=rs.getString(SQLRequest.NAME);
                byte[] content=rs.getBytes(SQLRequest.CONTENT);
                Image image=new Image(name,content);
                news=new News(id,idUser,title, text, rating,image);
                System.out.println("news"+news);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return news;
    }

    @Override
    public void setNews(News news) throws DAOException {
        try(Connection cn=ConnectionManager.getConnection();
        PreparedStatement pst=cn.prepareStatement(SQLRequest.UPDATE_NEWS)) {

            pst.setString(1,news.getTitle());
            pst.setString(2,news.getText());
            pst.setString(3,String.valueOf(news.getId()));
            pst.setString(4,String.valueOf(news.getIdUser()));

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }



    @Override
    public void addNews(News news,ActionNews action) throws SQLException, DAOException {
        String sql=action.getSql();
        News newsLastImage=null;
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, news.getTitle());
            pst.setString(2, news.getText());
            pst.setInt(3, news.getIdUser());

            if (action == ActionNews.EDIT) {
                pst.setInt(4, news.getId());
            }

            pst.executeUpdate();//insert, update, delete
            if (action == ActionNews.EDIT) {
                newsLastImage=getNewById(news.getId());
                if(!newsLastImage.getImage().getName().isEmpty() && news.getImage().getName().isEmpty()){
                    updateImagesNews(newsLastImage);
                }else{
                    updateImagesNews(news);
                }
            }else{
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int idNews = rs.getInt(1);
                        saveImage(idNews, news.getImage());
                        updateImagesNews(news);
                }
            }
        }
    }

    /*@Override
    public void updateRating(int id, int idUser, RatingNews rating) throws SQLException {
        boolean isExists=false;
        isExists=existsRating(id, idUser);
        try(Connection cn=ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.UPDATE_NEWS_RATING)){

            pst.setInt(1,rating.getValue());
            pst.setInt(2,id);

            System.out.println(isExists);
            if(isExists){
                if(rating==RatingNews.DOWN){
                    pst.executeUpdate();
                    deleteLike(id,idUser);
                }
            }

            if(!isExists){
                if(rating==RatingNews.UPP){
                    pst.executeUpdate();
                    updateLike(id,idUser);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void updateRating(News news, User user, RatingNews rating) throws SQLException {
        boolean isExists=false;
        isExists=existsRating(news.getId(), user.getId());
        try(Connection cn=ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.UPDATE_NEWS_RATING)){

            pst.setInt(1,rating.getValue());
            pst.setInt(2,rating.getValue());
            pst.setInt(3,news.getId());
            pst.setInt(4,user.getId());
            pst.setInt(5,news.getId());
            pst.setInt(6,news.getIdUser());


            pst.executeUpdate();

            if(isExists)  {
                if (rating == RatingNews.DOWN) {
                    deleteLike(news.getId(), user.getId());
                }
            }

            if(!isExists) {
                if (rating == RatingNews.UPP) {
                    insertLike(news.getId(), user.getId());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsRating(int id, int idUser) throws SQLException {
        boolean result=false;
        try(Connection cn=ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.EXISTS_NEWS_RATING)){

            pst.setInt(1,id);
            pst.setInt(2,idUser);

            ResultSet rs=pst.executeQuery();
            if (rs.next()){
             result=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public void insertLike(int idNews, int idUser) throws SQLException{
        try(Connection cn=ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.INSERT_LIKE_TABLE)){

            pst.setInt(1,idNews);
            pst.setInt(2,idUser);

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLike(int idNews, int idUser) throws SQLException{
        try(Connection cn=ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(SQLRequest.DELETE_LIKE_TABLE)){

            pst.setInt(1,idNews);
            pst.setInt(2,idUser);

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<News> getAllNews() throws DAOException {
        return getNews(SQLRequest.SELECT_ALL_NEWS);
    }

    @Override
    public List<News> getTopNews() throws DAOException {
        return getNews(SQLRequest.SELECT_TOP_NEWS);
    }

    private List<News> getNews(String sql) throws DAOException {
        List<News> newsTop=new LinkedList<>();
        try(Connection cn= ConnectionManager.getConnection();
            PreparedStatement pst=cn.prepareStatement(sql) ){


            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                int id=rs.getInt(SQLRequest.ID);
                int idUser=rs.getInt(SQLRequest.ID_USER);
                String title=rs.getString(SQLRequest.TITLE);
                String text=rs.getString(SQLRequest.TEXT);
                int rating= rs.getInt(SQLRequest.RATING);
                Timestamp timestamp=rs.getTimestamp(SQLRequest.DATE);
                String name=rs.getString(SQLRequest.NAME);
                byte[] content=rs.getBytes(SQLRequest.CONTENT);
                Image image=new Image(name,content);
                newsTop.add(new News(id,idUser,title,text,rating,timestamp,image));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return newsTop;
    }

    @Override
    public void saveImage(int idNews,Image image) throws SQLException {
        Connection cn = ConnectionManager.getConnection();
        try (PreparedStatement pst = cn.prepareStatement(SQLRequest.INSERT_IMAGE_NEWS)) {
            pst.setInt(1, idNews);
            pst.setString(2, image.getName());
            pst.setBytes(3, image.getContent());
            pst.executeUpdate();
        }
    }


}
