package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.delonborges.utils.PageUtils.clicaBotaoEditarContaTabela;
import static com.delonborges.utils.PageUtils.clicaBotaoRemoverContaTabela;

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
    @FindBy(id = "tabelaContas")
    private WebElement tabelaContas;

    // Methods
    public void preencheCampoNome(String nome) {
        this.campoNome.clear();
        this.campoNome.sendKeys(nome);
    }

    public void clicaBotaoSalvar() {
        this.botaoSalvar.click();
    }

    public String retornaMensagemDoAlertaDeSucesso() {
        wait.until(ExpectedConditions.visibilityOf(this.alertaDeSucesso));
        return this.alertaDeSucesso.getText();
    }

    public String retornaMensagemDoAlertaDeErro() {
        wait.until(ExpectedConditions.visibilityOf(this.alertaDeErro));
        return this.alertaDeErro.getText();
    }

    public void clicaAlterarConta(String nome) {
        clicaBotaoEditarContaTabela("Conta", nome, "Ações", this.tabelaContas);
    }

    public void clicaRemoverConta(String nome) {
        clicaBotaoRemoverContaTabela("Conta", nome, "Ações", this.tabelaContas);
    }
}
