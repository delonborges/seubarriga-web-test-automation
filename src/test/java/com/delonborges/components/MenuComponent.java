package com.delonborges.components;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuComponent extends BasePage {
    // Elements
    @FindBy(linkText = "Contas")
    private WebElement linkContas;
    @FindBy(linkText = "Adicionar")
    private WebElement linkAdicionar;

    // Methods
    public void acessarPaginaAdicionarConta() {
        this.linkContas.click();
        this.linkAdicionar.click();
    }
}
