package testClasses;

import page.CargaInformacion;
import page.DescargarArchivos;
import page.Login;
import page.MatrizInformacion;

import java.io.IOException;
import java.text.ParseException;

public class Logeo {

    private Login login;
    private CargaInformacion cargaInformacion;
    private MatrizInformacion matrizInformacion;
    private DescargarArchivos descargarArchivos;

    public Logeo(){
    }

    public void CasoLogin1(String usuario, String clave) throws ParseException, IOException {
        login = new Login();
        cargaInformacion = new CargaInformacion();
        descargarArchivos = new DescargarArchivos();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
    }
}
