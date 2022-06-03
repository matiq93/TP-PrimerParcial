package util;

public class ConsultasSQL {
    public static final String SQL_CREATE_TABLE=
            "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO "
                    + "("
                    + " ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                    + " NUMEROMATRICULA varchar(100) NOT NULL, "
                    + " NOMBRE varchar(100) NOT NULL, "
                    + " APELLIDO varchar(100) NOT NULL "
                    + " )";


    public static final String SQL_INSERT=
            "INSERT INTO ODONTOLOGO (NUMEROMATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";

    public static final String SQL_LISTAR=
            "SELECT * FROM ODONTOLOGO";
}

