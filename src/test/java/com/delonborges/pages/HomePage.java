package com.delonborges.pages;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.delonborges.utils.PageUtils.obtemValorCelula;

public class HomePage extends BasePage {
    // Elements
    @FindBy(id = "tabelaSaldo")
    private WebElement tabelaSaldo;

    // Methods
    public String retornaSaldoConta(String nome) {
        return obtemValorCelula("Conta", nome, "Saldo", this.tabelaSaldo);
    }
}
