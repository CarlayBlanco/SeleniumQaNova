package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CargaInformacion {

    @FindBy(id = "imPgTitle")
    private WebElement titulo;

    @FindBy(xpath = "//input[@id='imObjectForm_1_2']")
    private WebElement campoTexto;

    @FindBy(xpath = "//input[@id='imObjectForm_1_3']")
    private WebElement campoCorreo;

    @FindBy(xpath = "//textarea[@id='imObjectForm_1_4']")
    private WebElement campoTextArea;

    @FindBy(xpath = "//input[@id='imObjectForm_1_5']")
    private WebElement campoFecha;

    @FindBy(xpath = "//select[@id='imObjectForm_1_6']")
    private WebElement campoLista;

    @FindBy(id = "imObjectForm_1_7_0")
    private WebElement chckbxSeleccionMultiple1;

    @FindBy(id = "imObjectForm_1_7_1")
    private WebElement chckbxSeleccionMultiple2;

    @FindBy(id = "imObjectForm_1_7_2")
    private WebElement chckbxSeleccionMultiple3;

    @FindBy(id = "imObjectForm_1_8_0")
    private WebElement rdbtnCombo1;

    @FindBy(id = "imObjectForm_1_8_1")
    private WebElement rdbtnCombo2;

    @FindBy(id = "imObjectForm_1_8_2")
    private WebElement rdbtnCombo3;

    @FindBy(id = "imObjectForm_1_submit")
    private WebElement btnEnviar;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_buttonswrap\"]/input[2]")
    private WebElement btnReset;

    @FindBy(id = "imObjectForm_1_5_icon")
    private WebElement iconoCalendario;

    @FindBy(id = "imDPleft")
    private WebElement btnRetrocederMes;

    @FindBy(id = "imDPright")
    private WebElement btnAvanzarMes;

    public CargaInformacion() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public String recuperarTitulo() {
        Validaciones.validarObjeto(titulo, "titulo");
        PdfQaNovaReports.addWebReportImage("Despliegue carga de informacion", "Se ha desplegado de manera exitosa la pagina carga de informacion", EstadoPrueba.PASSED, false);
        String texto = titulo.getText();
        return texto;
    }

    public void rellenarCampoTexto(String texto) {
        campoTexto.sendKeys(texto);
    }

    public void rellenarCampoMail(String mail) {
        campoCorreo.sendKeys(mail);
    }

    public void rellenarCampoAreaTexto(String areaTexto) {
        campoTextArea.sendKeys(areaTexto);
    }

    public void rellenarFecha(String fecha) {
        campoFecha.sendKeys(fecha);
    }

    public void rellenarLista(String valor) {
        Select select = new Select(campoLista);
        select.selectByVisibleText(valor);
    }

    public void seleccionMultiple(String indicador) {
        String[] indicadores = indicador.split(",");
        for (String nro : indicadores) {
            int numero = Integer.parseInt(nro);
            switch (numero) {
                case 1:
                    chckbxSeleccionMultiple1.click();
                    break;
                case 2:
                    chckbxSeleccionMultiple2.click();
                    break;
                case 3:
                    chckbxSeleccionMultiple3.click();
                    break;
                default:
                    System.out.println("Valor no procesable");
            }
        }
    }

    public void seleccionRadioButton(int indicador) {
        switch (indicador) {
            case 1:
                rdbtnCombo1.click();
                break;
            case 2:
                rdbtnCombo2.click();
                break;
            case 3:
                rdbtnCombo3.click();
                break;
            default:
                System.out.println("Valor no procesable");
        }
    }

    public void seleccionarFechaCalendario(String fecha) throws ParseException {
        iconoCalendario.click();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = simpleDateFormat.format(new Date());
        Date hoyDate = simpleDateFormat.parse(hoy);
        Date fechaDate = simpleDateFormat.parse(fecha);
        long diferencia = ChronoUnit.MONTHS.between(LocalDate.parse(hoy).withDayOfMonth(1), LocalDate.parse(fecha).withDayOfMonth(1));
        int dia = Integer.parseInt(fecha.substring(fecha.length()-2));
        int meses;
        if (hoyDate.after(fechaDate)) {
            meses = (int) (diferencia * -1);
            for (int x = 0; x <= meses - 1; x++) {
                btnRetrocederMes.click();
            }
        } else {
            meses = (int) diferencia;
            for (int x = 0; x <= meses - 1 ; x++) {
                btnAvanzarMes.click();
            }
        }
        PdfQaNovaReports.addWebReportImage("Seleccion Fecha Calendario", "Se selecciona fecha: " + fecha + ", desde el calendario", EstadoPrueba.PASSED, false);
        DriverContext.getDriver().findElement(By.xpath("//div[@id = 'imDPcal']//td[text() = '" + dia + "']")).click();
    }

    public void clickBtnEnviar() {
        PdfQaNovaReports.addWebReportImage("Datos Formulario", "Se ingresan datos al formulario", EstadoPrueba.PASSED, false);
        btnEnviar.click();
    }

    public void clickBtnReset() {
        btnReset.click();
    }
}
