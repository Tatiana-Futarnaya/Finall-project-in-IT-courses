package by.itclass.model.db.jdbc;
//никто не будет наследоваться
public final class SQLRequest {
    public static final String SELECT_USER_BY_LOGIN_AND_PASSWORD
            ="select u.id, " +
            "u.login, " +
            " u.email, " +
            "im.image, " +
            "im.content " +
            "from users as u " +
            "left join images_users as im on u.id=im.idUser where login=? and password=?";
    public static final String SELECT_USER_BY_LOGIN_AND_EMAIL
            = "select * from users where login=? and email=?";
    public static final String SELECT_NEWS_BY_ID_USER
            =  "select n.id," +
            "n.title," +
            "n.text," +
            "im.image," +
            "im.content " +
            "from news as n " +
            "left join images_news as im on n.id=im.idNews " +
            "where idUser=?";
    public static final String SELECT_NEWS_BY_ID
            = "select news.id, news.idUser, news.title, news.text, news.rating, images_news.image, images_news.content" +
            " from news " +
            "left join images_news on news.id=images_news.idNews where news.id=?";
    public static final String SELECT_ALL_NEWS
            = "select news.id, news.idUser, news.title, news.text, news.timestamp, news.rating, images_news.image, images_news.content " +
            "from news " +
            "left join images_news on news.id=images_news.idNews where timestamp >=(NOW() - INTERVAL 8 DAY) order by news.timestamp desc ";
    public static final String SELECT_TOP_NEWS
            = "select news.id, news.idUser, news.title, news.text, news.timestamp, news.rating, images_news.image, images_news.content " +
            "from news " +
            "inner join images_news on news.id=images_news.idNews where timestamp >(NOW() - INTERVAL 7 DAY) order by rating desc limit 3";
    public static final String UPDATE_IMAGE_BY_ID_USER
            = "update images_users set  image=?, content=?  where idUser=?";
    public static final String UPDATE_IMAGE_BY_ID_NEWS
            = "update images_news set image=?, content=?  where idNews=?";



    public static final String ID = "id";//значения соглавно имению столбцов в БД
    public static final String EMAIL = "email";
    public static final String TITLE = "title";
    public static final String TEXT = "text";
    public static final String ID_USER = "idUser";
    public static final String DATE = "timestamp";
    public static final String RATING = "rating";
    public static final String CONTENT = "content";
    public static final String NAME = "image";

    public static final String INSERT_USER_BY_LOGIN_AND_PASSWORD_AND_EMAIL
            = "insert into users (login,password,email) values (?,?,?)";
    public static final String INSERT_USER_IMAGE =
            "insert into images_users(idUser) select id from users where users.id = (select max(id) from users)";
    public static final String INSERT_NEWS
            = "insert into news (title,text,idUser) values (?,?,?)";


    public static final String DELETE_NEWS_BY_ID = "delete from news where id=?";
    public static final String DELETE_IMAGE_NEWS_BY_ID = "delete from images_news where idNews=?";
    public static final String UPDATE_NEWS
            = "update news set title=?,text=? where idUser=? and id=?";
    /*public static final String UPDATE_NEWS_RATING
            = "update news set rating=(rating+?) where id=? ";*/

    public static final String UPDATE_NEWS_RATING
            = "update news  " +
            "set news.rating=news.rating+?-(select if(?=-1,(count(*)-1),count(*)) from likes where likes.idNews=? and likes.idUser=?)" +
            " where news.id=? and news.idUser=?";


    public static final String DELETE_LIKE_TABLE
            = "delete from likes where idNews=? and idUser=?";
    public static final String INSERT_LIKE_TABLE
            = "insert into likes (idNews, idUser) values (?,?)";


    public static final String EXISTS_NEWS_RATING =
            "select idNews, idUser from likes where idNews=? and idUser=?";


    public static final String INSERT_IMAGE_NEWS = "insert into images_news(idNews,image,content) values(?,?,?)";


}
