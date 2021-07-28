package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResumoPage extends BasePage {

    // Elements
    @FindBy(css = "span[class='glyphicon glyphicon-remove-circle']")
    private WebElement linkRemoverMovimentacao;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaDeSucesso;
    @FindBy(id = "tabelaExtrato")
    private WebElement tabelaExtrato;

    // Methods
    public void clicaLinkRemoverMovimentacao() {
        this.linkRemoverMovimentacao.click();
    }

    public String retornaMensagemDoAlertaDeSucesso() {
        wait.until(ExpectedConditions.visibilityOf(this.alertaDeSucesso));
        return this.alertaDeSucesso.getText();
    }

    public Integer retornaQuantidadeLinhasTabela() {
        wait.until(ExpectedConditions.visibilityOf(this.tabelaExtrato));
        return this.tabelaExtrato.findElements(By.cssSelector("tbody > tr")).size();
    }
}
