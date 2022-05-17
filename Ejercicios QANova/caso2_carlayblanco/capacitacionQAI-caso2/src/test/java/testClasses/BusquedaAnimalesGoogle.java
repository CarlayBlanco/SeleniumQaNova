package testClasses;

import org.openqa.selenium.WebDriver;
import page.Google;

public class BusquedaAnimalesGoogle {

    private Google google;
    WebDriver webDriver;

    public BusquedaAnimalesGoogle(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void busquedaPerro(){
        google = new Google(webDriver);
        google.ingresarBusqueda("Perro");
        google.clickBtnBuscar();
    }

    public void busquedaGato(){
        google = new Google(webDriver);
        google.ingresarBusqueda("Gato");
        google.clickBtnBuscar();
    }
}
