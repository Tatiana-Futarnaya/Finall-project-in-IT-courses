package by.itclass.model.beans;

import javax.persistence.*;
import java.sql.Timestamp;


public class News {
    private int id;
    private int idUser;
    private String title;
    private String text;
    private int rating;
    private Timestamp timestamp;
    private Image imageNews;

    public News() {
    }

    public News(String id, int idUser, String title, String text,Image imageNews) {
        if (id != null) {
            this.id = Integer.parseInt(id);
        }
        this.idUser = idUser;
        this.title = title;
        this.text = text;
        this.imageNews=imageNews;
    }

    public News(int id, int idUser, String title, String text) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.text = text;
    }

    public News(int id, int idUser, String title, String text, Image imageNews) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.text = text;
        this.imageNews=imageNews;
    }

    public News(int id,int idUser, String title, String text, int rating, Image imageNews) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.text = text;
        this.rating=rating;
        this.imageNews=imageNews;
    }

    public News(int id, int idUser, String title, String text, int rating, Timestamp timestamp, Image imageNews) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.timestamp = timestamp;
        this.imageNews=imageNews;
    }




    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Image getImage() {
        return imageNews;
    }

    public void setImage(Image imageNews) {
        this.imageNews = imageNews;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", timestamp=" + timestamp +
                ", image=" + imageNews +
                '}';
    }
}
