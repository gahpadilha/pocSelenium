package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "login")
    public WebElement login;

    @FindBy(name = "pass")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement btnLogOn;

    public void preencherEmail(String email){
        login.sendKeys(email);
    }

    public void preencherSenha(String senha){
        password.sendKeys(senha);
    }

    public void entrar(){
        clicarBotao("Confirmar");
    }

    public String validarTexto(String texto){
        return obterTexto(By.xpath("//*[text()='" + texto + "']"));
    }

    public String validarMensagemErro(){
        return obterTexto(By.xpath("//*[@class='alert alert-danger']"));
    }
}
