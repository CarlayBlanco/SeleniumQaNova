package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    WebElement inputBuscar;

    @FindBy(xpath = "(//input[@value='Buscar con Google'])[2]")
    WebElement btnBuscar;

    public Google(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void ingresarBusqueda(String busqueda){
        inputBuscar.sendKeys(busqueda);
        inputBuscar.sendKeys(Keys.ESCAPE);
    }

    public void clickBtnBuscar() {
        btnBuscar.click();
    }
}
