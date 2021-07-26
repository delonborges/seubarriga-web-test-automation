package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.delonborges.utils.PageUtils.clicaBotaoEditarContaTabela;

public class ContaPage extends BasePage {
    // Elements
    @FindBy(id = "nome")
    private WebElement campoNome;
    @FindBy(css = "button[type=submit]")
    private WebElement botaoSalvar;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaDeSucesso;
    @FindBy(css = "div[class='alert alert-danger']")
    private WebElement alertaDeErro;

    // Methods
    public void preencheCampoNome(String nome) {
        this.campoNome.sendKeys(nome);
    }

    public void clicaBotaoSalvar() {
        this.botaoSalvar.click();
    }

    public String retornaMensagemDoAlertaDeSucesso() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeSucesso));
        return this.alertaDeSucesso.getText();
    }

    public String retornaMensagemDoAlertaDeErro() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeErro));
        return this.alertaDeErro.getText();
    }

    public void clicaAlterarConta(String nome) {
        clicaBotaoEditarContaTabela("Conta", nome, "Ações", "tabelaContas");
    }
}
