package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MovimentacaoPage extends BasePage {

    // Elements
    @FindBy(id = "data_transacao")
    private WebElement campoDataMovimentacao;
    @FindBy(id = "data_pagamento")
    private WebElement campoDataPagamento;
    @FindBy(id = "descricao")
    private WebElement campoDescricao;
    @FindBy(id = "interessado")
    private WebElement campoInteressado;
    @FindBy(id = "valor")
    private WebElement campoValor;
    @FindBy(id = "conta")
    private WebElement comboConta;
    @FindBy(id = "status_pago")
    private WebElement radioStatus;
    @FindBy(css = "button[type=submit]")
    private WebElement botaoSalvar;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaDeSucesso;
    @FindBy(css = "div[class='alert alert-danger']")
    private WebElement alertaDeErro;

    // Methods
    public void preencheFormularioMovimentacao(String dataMovimentacao, String dataPagamento, String descricao, String interessado, String valor, String conta) {
        this.preencherDataMovimentacao(dataMovimentacao);
        this.preencherDataPagamento(dataPagamento);
        this.preencherDescricao(descricao);
        this.preencherInteressado(interessado);
        this.preencherValor(valor);
        this.selecionarConta(conta);
        this.marcaStatusPago();
        this.clicaBotaoSalvar();
    }

    public String retornaMensagemDoAlertaDeSucesso() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeSucesso));
        return this.alertaDeSucesso.getText();
    }

    public String retornaMensagemDoAlertaDeErro() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeErro));
        return this.alertaDeErro.getText();
    }

    // Helpers
    private void preencherDataMovimentacao(String data) {
        this.campoDataMovimentacao.sendKeys(data);
    }

    private void preencherDataPagamento(String data) {
        this.campoDataPagamento.sendKeys(data);
    }

    private void preencherDescricao(String descricao) {
        this.campoDescricao.sendKeys(descricao);
    }

    private void preencherInteressado(String interessado) {
        this.campoInteressado.sendKeys(interessado);
    }

    private void preencherValor(String valor) {
        this.campoValor.sendKeys(valor);
    }

    private void selecionarConta(String conta) {
        Select combo = new Select(this.comboConta);
        combo.selectByVisibleText(conta);
    }

    private void marcaStatusPago() {
        this.radioStatus.click();
    }

    private void clicaBotaoSalvar() {
        this.botaoSalvar.click();
    }
}
