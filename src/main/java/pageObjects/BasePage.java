package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static manager.DriverFactory.getDriver;

public class BasePage {

    public void preencherCampo(String campo, String informacao){
        WebElement element = getDriver().findElement(By.xpath("//*[text()='" + campo + "']/following::input[1]"));
        element.sendKeys(informacao);
    }

    public void clicarBotao(String campo){
        WebElement element = getDriver().findElement(By.xpath("//*[text()='" + campo + "']"));
        element.click();
    }

    public String obterTexto(By xpath){
        return getDriver().findElement(xpath).getText();
    }
}
