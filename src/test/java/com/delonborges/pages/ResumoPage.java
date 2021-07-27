package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResumoPage extends BasePage {

    // Elements
    @FindBy(css = "span[class='glyphicon glyphicon-remove-circle']")
    private WebElement linkRemoverMovimentacao;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement alertaDeSucesso;

    // Methods
    public void clicaLinkRemoverMovimentacao() {
        this.linkRemoverMovimentacao.click();
    }

    public String retornaMensagemDoAlertaDeSucesso() {
        wait.until(ExpectedConditions.visibilityOf(alertaDeSucesso));
        return this.alertaDeSucesso.getText();
    }
}
