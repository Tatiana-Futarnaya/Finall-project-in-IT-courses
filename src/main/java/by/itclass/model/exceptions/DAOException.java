package by.itclass.model.exceptions;
//Класс описывае ошибку в DAO прослойке
public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
