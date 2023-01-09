package by.itclass.model.memory;

import by.itclass.model.beans.News;

import java.util.ArrayList;
import java.util.List;

public class NewsMemory {
    private static List<News> newsList;

    static {
        newsList =new ArrayList<>();
        newsList.add(new News(1,1,"Title1","Text1"));
        newsList.add(new News(2,2,"Title2","Text2"));
        newsList.add(new News(3,1,"Title3","Text3"));
    }

    public static List<News> selectNewsByIdUser(int idUser){
       List<News> newsList=new ArrayList<>();
       for(News news: NewsMemory.newsList){
           if(news.getIdUser()==idUser){
               newsList.add(news);
           }
       }
       return newsList;
    }

    public static void deleteNewsById(int id){
        for (News news: newsList){
            if(news.getId()==id){
                newsList.remove(news);
                return;//выходит из метода
            }
        }
    }

    public static News editNewById(int id){
        News newsOne=null;
        for (News news: NewsMemory.newsList) {
            if(news.getId()==id){
                newsOne=newsList.get(id-1);
            }
        }
        return newsOne;
    }

    public static void setNews(News news){
        for(int i=0; i< newsList.size(); i++){
            if(news.getId()==newsList.get(i).getId() && news.getIdUser()==newsList.get(i).getIdUser()){
                newsList.set(i,news);
            }
        }
    }

    public static int newIdNews(int idUser) {
        int id = 0;
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.get(i).getIdUser() == idUser) {
                id = newsList.get(i).getId() + 1;
            }
        }
        return id;
    }

    public static void addNews(News news){
        News newsNews=new News(newIdNews(news.getIdUser()),news.getIdUser(), news.getTitle(), news.getText());
        newsList.add(newsNews);
    }
}
