package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // Elements
    @FindBy(id = "email")
    private WebElement campoEmail;
    @FindBy(id = "senha")
    private WebElement campoSenha;
    @FindBy(css = "button[type=submit]")
    private WebElement botaoEntrar;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaBemVindo;

    // Methods
    public void efetuaLogin(String email, String senha) {
        this.preencheCampoEmail(email);
        this.preencheCampoSenha(senha);
        this.clicaBotaoEntrar();
    }

    public String retornaMensagemDoAlerta() {
        wait.until(ExpectedConditions.visibilityOf(alertaBemVindo));
        return this.alertaBemVindo.getText();
    }

    // Helpers
    private void preencheCampoEmail(String email) {
        this.campoEmail.sendKeys(email);
    }

    private void preencheCampoSenha(String senha) {
        this.campoSenha.sendKeys(senha);
    }

    private void clicaBotaoEntrar() {
        this.botaoEntrar.click();
    }
}
