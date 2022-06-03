package util;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class LogGestor {


        public static final String RUTA_ABSOLUTA_ARCHIVO_PROPIEDADES = "C:\\BackEnd I\\Parcial\\src\\util\\log4j.properties";

        public static void inicializar() {
            File log4jfile = new File(RUTA_ABSOLUTA_ARCHIVO_PROPIEDADES);
            PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        }
    }

