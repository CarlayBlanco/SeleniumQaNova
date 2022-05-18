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

    public void CasoLogin1(String usuario, String clave) throws ParseException {
        login = new Login();
        cargaInformacion = new CargaInformacion();
        descargarArchivos = new DescargarArchivos();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        //Desde aca se agregan los llamados a las funciones que llenan el formulario
        cargaInformacion.rellenarCampoTexto("Prueba 3 Carlay Blanco");
        cargaInformacion.rellenarCampoCorreo("carlay.blanco@externos.bci.cl");//Agregada para evaluación 3
        cargaInformacion.rellenarCampoAreaTexto("Esta es le evaluacion numero 3 realizada por Carlay Blanco");
        cargaInformacion.rellenarFecha("16-11-1988");
        cargaInformacion.rellenarLista("valor 2");
        cargaInformacion.seleccionMultiple("2,3");
        cargaInformacion.seleccionRadioButton(2);
        cargaInformacion.seleccionarFechaCalendario("2020-11-16");
        cargaInformacion.clickBtnEnviar();
        //cargaInformacion.clickBtnReset();
        //Hasta aca se agregan los llamados a las funciones que llenan el formulario
    }
}
