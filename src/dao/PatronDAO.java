package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface PatronDAO <T> {
    public T guardar(T t);
    void listar(Connection connection) throws SQLException;
}
