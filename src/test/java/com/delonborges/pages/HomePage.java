package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.delonborges.utils.PageUtils.obtemValorCelula;

public class HomePage extends BasePage {
    // Elements
    @FindBy(id = "tabelaSaldo")
    private WebElement tabelaSaldo;
    @FindBy(linkText = "reset")
    private WebElement linkReset;

    // Methods
    public void clicaLinkReset() {
        this.linkReset.click();
    }

    public String retornaSaldoConta(String nome) {
        return obtemValorCelula("Conta", nome, "Saldo", this.tabelaSaldo);
    }
}
