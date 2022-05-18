package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

public class Login {

    @FindBy(xpath = "//label[@for='imUname']")
    private WebElement labelUsuario;

    @FindBy(id = "imUname")
    private WebElement inputUsuario;

    @FindBy(id = "imPwd")
    private WebElement inputClave;

    @FindBy(xpath = "//input[@value='Ingresar a Demo']")
    private WebElement btnIngresar;

    public Login(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void ingresarUsuario(String usuario){
        Validaciones.validarObjeto(inputUsuario, "input usuario");
        PdfQaNovaReports.addWebReportImage("Despliegue login", "Se ha desplegado de manera exitosa la pagina login", EstadoPrueba.PASSED, false);
        inputUsuario.sendKeys(usuario);
    }

    public void ingresarClave(String clave){
        inputClave.sendKeys(clave);
    }

    public void clickBtnIngresar(){
        PdfQaNovaReports.addWebReportImage("Datos Login", "Se ingresa usuario y contraseña", EstadoPrueba.PASSED, false);
        btnIngresar.click();
    }

    public void validarTextoUsuario(String texto){
        Validaciones.validarTexto(labelUsuario, texto);
    }
}
