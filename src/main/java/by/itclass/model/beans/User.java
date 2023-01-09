package by.itclass.model.beans;


public class User {

    private int id;

    private String login;

    private String email;

    private Image image;

    public User() {
    }

    public User(int id, String login, String email, Image image) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.image = image;
    }

    public User(String login) {
        this.login = login;
    }

    public User(int id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", image=" + image +
                '}';
    }
}
