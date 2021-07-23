package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContasPage extends BasePage {
    // Elements
    @FindBy(id = "nome")
    private WebElement campoNome;
    @FindBy(css = "button[type=submit]")
    private WebElement botaoSalvar;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaContaAdicionada;

    // Methods
    public void adicionaConta(String nome) {
        this.preencheCampoNome(nome);
        this.clicaBotaoSalvar();
    }
    public String retornaMensagemDoAlerta() {
        wait.until(ExpectedConditions.visibilityOf(alertaContaAdicionada));
        return this.alertaContaAdicionada.getText();
    }

    // Helpers
    private void preencheCampoNome(String nome) {
        this.campoNome.sendKeys(nome);
    }
    private void clicaBotaoSalvar() {
        this.botaoSalvar.click();
    }
}
