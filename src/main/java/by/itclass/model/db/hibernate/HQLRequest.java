package by.itclass.model.db.hibernate;

public class HQLRequest {
    public static final String SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "From User  where login=?1 and password=?2";
    public static final String SELECT_NEWS_BY_ID_USER =
            "From News where idUser=?1";
    public static final String DELETE_NEWS_BY_ID =
            "delete from News where id=?1";
    public static final String UPDATE_IMAGE_BY_ID_USER =
            "update from Image set  image=?1, content=?2 where idUser=?3";
}
