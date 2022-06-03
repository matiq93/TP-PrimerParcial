package service;

import dao.OdontologoDAOH2;
import model.Odontologo;
import util.H2Gestor;

import java.sql.SQLException;
import java.util.logging.Logger;

public class OdontologoService {
    final static Logger log = Logger.getLogger(String.valueOf(OdontologoService.class));
    private OdontologoDAOH2 odontologoDAOH2;


    // Se define para la injeccion del de la dependencia
    public OdontologoService(OdontologoDAOH2 odontologoDAOH2) {
        this.odontologoDAOH2 = odontologoDAOH2;
    }

    // Se define los metodos del crud
    public Odontologo guardar(Odontologo odontologo){

        return odontologoDAOH2.guardar(odontologo);

    }
    public void listar(){

        //odontologoDAOH2.listar(H2Gestor.getConnection());
    }

    public void crearTablasDB() {
        try {
            odontologoDAOH2.crearTabla();

        } catch (SQLException e) {
          //  log.error(e.getMessage());
        }
    }

}
