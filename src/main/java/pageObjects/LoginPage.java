package pageObjects;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public void preencherEmail(String informacao){
        preencherCampo("Email", informacao);
    }

    public void preencherSenha(String informacao){
        preencherCampo("Senha", informacao);
    }

    public void entrar(){
        clicarBotao("Entrar");
    }

    public String validarMensagemSucesso(){
        return obterTexto(By.xpath("//*[@class='alert alert-success']"));
    }

    public String validarMensagemErro(){
        return obterTexto(By.xpath("//*[@class='alert alert-danger']"));
    }
}
