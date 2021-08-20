import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPage;
import static manager.DriverFactory.getDriver;
import static manager.DriverFactory.killDriver;

public class LoginTest {
    LoginPage loginPage = new LoginPage();

    @Before
    public void acessarTelaInicial(){
        getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    @After
    public void finalizar(){
        killDriver();
    }

    @Test
    public void efetuarLoginComSucesso(){
        loginPage.preencherEmail("padilha.ga@gmail.com");
        loginPage.preencherSenha("gABRIEL");
        loginPage.entrar();
        Assert.assertEquals("Bem vindo, Gabriel!", loginPage.validarMensagemSucesso());
    }

    @Test
    public void efetuarLoginComEmailInvalido(){
        loginPage.preencherEmail("padilha123.ga@gmail.com");
        loginPage.preencherSenha("gABRIEL");
        loginPage.entrar();
        Assert.assertEquals("Problemas com o login do usuário", loginPage.validarMensagemErro());
    }

    @Test
    public void efetuarLoginComSenhaInvalida(){
        loginPage.preencherEmail("padilha.ga@gmail.com");
        loginPage.preencherSenha("gABRIEL123");
        loginPage.entrar();
        Assert.assertEquals("Problemas com o login do usuário", loginPage.validarMensagemErro());
    }
}
