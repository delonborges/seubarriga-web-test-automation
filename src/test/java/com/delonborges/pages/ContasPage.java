package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.delonborges.utils.Utils.clicaBotaoEditarContaTabela;

public class ContasPage extends BasePage {
    // Elements
    @FindBy(id = "nome")
    private WebElement campoNome;
    @FindBy(css = "button[type=submit]")
    private WebElement botaoSalvar;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaContaAdicionada;

    // Methods
    public void preencheCampoNome(String nome) {
        this.campoNome.sendKeys(nome);
    }
    public void clicaBotaoSalvar() {
        this.botaoSalvar.click();
    }
    public String retornaMensagemDoAlerta() {
        wait.until(ExpectedConditions.visibilityOf(alertaContaAdicionada));
        return this.alertaContaAdicionada.getText();
    }
    public void clicaAlterarConta(String nome) {
        clicaBotaoEditarContaTabela("Conta", nome, "Ações", "tabelaContas");
    }
}
