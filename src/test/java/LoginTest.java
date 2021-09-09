import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPage;
import static manager.DriverFactory.getDriver;
import static manager.DriverFactory.killDriver;

public class LoginTest {
    LoginPage loginPage = new LoginPage(getDriver());

    @Before
    public void acessarTelaInicial(){
        getDriver().get("https://www.lenain.com.br/restrito/index.php?pagina=login");
    }

    @After
    public void finalizar(){
        killDriver();
    }

    @Test
    public void efetuarLoginComSucesso(){
        loginPage.preencherEmail("usuarioteste@lenain.com.br");
        loginPage.preencherSenha("123!@#as");
        loginPage.entrar();
        Assert.assertEquals("Online", loginPage.validarTexto(" Online"));
    }
    
}
