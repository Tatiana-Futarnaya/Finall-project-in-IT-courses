package by.itclass.model.beans;


public class Image {

    private int id;

    private String name;

    private byte[] content;


    public Image() {

    }

    public Image(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getContent() {
        return content;
    }
}
