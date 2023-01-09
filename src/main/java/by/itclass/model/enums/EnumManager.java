package by.itclass.model.enums;

public class EnumManager {

    public static ActionNews getKindActionNews(String action){
        try{
            return  ActionNews.valueOf(action.toUpperCase());//преобразуем к enum
        }catch (IllegalArgumentException e){
            throw e;
        }
    }

    public  static RatingNews getKindRatingNews(String rating){
        try{
            return RatingNews.valueOf(rating.toUpperCase());
        }catch (IllegalArgumentException e){
            throw e;
        }
    }
}
