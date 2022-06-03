package util;

import dao.OdontologoDAOH2;
import org.apache.log4j.Logger;
import dao.OdontologoDAOH2;
import java.sql.Connection;
import java.sql.SQLException;

public class Aplicacion {
    public static final Logger logger = Logger.getLogger(Aplicacion.class);

    public static void main(String[] args) {
        Connection connection = null;
        try {
            LogGestor.inicializar();
            connection= H2Gestor.getConnection();
            if(!connection.isClosed()){
                logger.info("La conexión está abierta");
            }
            OdontologoDAOH2 odontologoH2 = new OdontologoDAOH2();
            OdontologoDAOH2.crearTabla();
            OdontologoDAOH2.guardar(connection, 1234,"Martin", "Ramirez");
            OdontologoDAOH2.guardar(connection, 5678,"Maria", "Perez");
            OdontologoDAOH2.listar(connection);
            connection.isClosed();
            logger.info("la conexion esta cerrada");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
}
