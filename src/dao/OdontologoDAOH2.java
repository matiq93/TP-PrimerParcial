package dao;
import model.Odontologo;
import util.ConsultasSQL;
import util.H2Gestor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class OdontologoDAOH2 implements PatronDAO<Odontologo> {


    private H2Gestor utilDb;

    final static Logger log = Logger.getLogger(OdontologoDAOH2.class);

    public OdontologoDAOH2() {
        this.utilDb = new H2Gestor();
    }

    public void crearTabla() throws SQLException {
        log.debug("Se crea la tabla de Odontologo.");

        Connection conn = utilDb.getConnection();
        utilDb.executeSQL(conn, ConsultasSQL.SQL_CREATE_TABLE);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        log.debug("Registrando un nuevo odontologo : " + odontologo.toString());

        Connection connection;
        PreparedStatement preparedStatement;

        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement(ConsultasSQL.SQL_INSERT);
            //2.2 Colocar los parametros
            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            //3 Ejecutar una sentencia SQL
            //utilDb.executeSQL(psInsert);

        } catch (SQLException  e) {
            log.error(e.getMessage());
        }
        return odontologo;
    }


    @Override
    public void listar(Connection connection) throws SQLException {

            ResultSet rs = utilDb.executeQuery(connection, ConsultasSQL.SQL_LISTAR);

            while (rs.next()){
                Odontologo odontologo = new Odontologo();
                odontologo.setNumeroMatricula(rs.getString("NUMEROMATRICULA"));
                odontologo.setNombre(rs.getString("NOMBRE"));
                odontologo.setApellido(rs.getString("APELLIDO"));
                //logger.info(odontologo);

            }

            rs.close();
        }
    }





