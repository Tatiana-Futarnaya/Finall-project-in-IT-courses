package by.itclass.constants;

public final class AppConstant {
    public static final String AUTHORIZATION_CONT = "/authorization";
    public static final String REGISTRATION_CONT = "/registration";
    public static final String LOGOUT_CONT = "/logout";
    public static final String USER_NEWS_LIST_CONT ="/userNewsList" ;
    public static final String REMOVE_CONT = "/remove";
    public static final String SAVE_NEWS_CONT = "/addNews";
    public static final String CHOICE_EDIT_NEWS_CONT = "/choiceEditNews";
    public static final String VIEW_CONT = "/view";
    public static final String RATING_NEWS_CONT = "/rating";
    public static final String MAIN_PAGE_CONT = "/mainPage";
    public static final String FILE_UPLOAD_CONT ="/upload";


    public static final String LOGIN_PARAMETER = "login";
    public static final String PASSWORD_PARAMETER = "password";
    public static final String PASSWORD_REPEATED_PARAMETER = "passwordRepeated";
    public static final String EMAIL_PARAMETER ="email" ;
    public static final String ID_PARAMETER = "id";
    public static final String ID_USER_PARAMETER = "idUser";
    public static final String TITLE_PARAMETER = "titleNews";
    public static final String TEXT_PARAMETER = "textNews";
    public static final String IMG_PARAMETER = "imgNews";
    public static final String ACTION_PARAMETER = "action";
    public static final String NEWS_PARAMETER = "news";
    public static final String NEWS_FOR_EDIT_PARAMETER = "newsEdit";
    public static final String RATING_PARAMETER = "rating";
    public static final String FILE_PARAMETER = "file";


    public static final String USER_ATTR = "user";
    public static final String MESSAGE_ATTR = "message";
    public static final String NEWS_LIST_ATTR = "newsList";
    public static final String NEWS_TOP_ATTR = "newsTop";
    public static final String NEWS_ONE_ATTR = "newsOne";
    public static final String IMAGE_ATTR = "image";
    //По этому имени атрибута можно получить временную (буферную папку), котору. томкат использует
    // для хранения временных оперативных данных
    //В зависимости от того где установлен и как настроен сервер эта папка может иметь разный путь,
    // но его всегда можно получить по названию этого атрибута
    public static final String CONTEXT_TEMPDIR_ATTR = "javax.servlet.context.tempdir";



    public static final String CABINET_JSP = "/cabinet.jsp";
    public static final String AUTH_JSP = "/auth.jsp";
    public static final String REG_JSP ="/reg.jsp" ;
    public static final String INDEX_JSP = "/index.jsp";
    public static final String MYNEWS_JSP = "/mynews.jsp";
    public static final String ADD_NEWS_JSP = "/addnews.jsp";
    public static final String NEWS_JSP = "/news.jsp";


    public static final String INCORRECT_LOGIN_OR_PASSWORD_MESSAGE = "Incorrect login or password";
    public static final String REPEAT_LOGIN_OR_EMAIL = "Already exists login or email";
    public static final String SESSION_TIMEOUT_MESSAGE ="Session timeout" ;


    public static final String DB_PROPERTIES_FILE = "db.properties";
    public static final String URL_PROPERTY = "url";

    public static final String ADD_ACTION_VALUE = "add";
    public static final String EDIT_ACTION_VALUE = "edit";
    public static final String DRIVER_PROPERTY = "driver" ;


    public static final int UPP_RATING_VALUE = 1;
    public static final int DOWN_RATING_VALUE = -1;
    public static final int LIMIT_VIEW_TOP_NEWS = 2;

    public static final String IMAGE_FOLDER = "image";



}
