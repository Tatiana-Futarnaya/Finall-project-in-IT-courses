package by.itclass.model.files;

import by.itclass.model.beans.Image;
import org.apache.commons.fileupload.FileItem;

import java.io.*;

public class ImageManager {
    public static void createImage(String path, Image image) {
        try (OutputStream out = new FileOutputStream(path + File.separator + image.getName())) {
            out.write(image.getContent());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createImage(FileItem file, String path){
        try (OutputStream out = new FileOutputStream(path + File.separator + file.getName())) {//заисывает файл физически
            out.write(file.getInputStream().readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
