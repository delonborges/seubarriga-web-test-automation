package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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
    public void preencheDataMovimentacao(String data) {
        this.campoDataMovimentacao.sendKeys(data);
    }

    public void preencheDataPagamento(String data) {
        this.campoDataPagamento.sendKeys(data);
    }

    public void preencheDescricao(String descricao) {
        this.campoDescricao.sendKeys(descricao);
    }

    public void preencheInteressado(String interessado) {
        this.campoInteressado.sendKeys(interessado);
    }

    public void preencheValor(String valor) {
        this.campoValor.sendKeys(valor);
    }

    public void selecionaConta(String conta) {
        Select combo = new Select(this.comboConta);
        combo.selectByVisibleText(conta);
    }

    public void marcaStatusPago() {
        this.radioStatus.click();
    }

    public void clicaBotaoSalvar() {
        this.botaoSalvar.click();
    }

    public String retornaMensagemDoAlertaDeSucesso() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeSucesso));
        return this.alertaDeSucesso.getText();
    }

    public List<String> retornaListaMensagemDoAlertaDeErro() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeErro));
        List<WebElement> listaDeElementos = this.alertaDeErro.findElements(By.cssSelector("li"));
        List<String> listaDeErros = new ArrayList<>();
        for (WebElement elemento: listaDeElementos) {
            listaDeErros.add(elemento.getText());
        }
        return listaDeErros;
    }
}
