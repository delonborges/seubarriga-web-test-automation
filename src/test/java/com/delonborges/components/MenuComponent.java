package com.delonborges.components;

import com.delonborges.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuComponent extends BasePage {
    // Elements
    @FindBy(linkText = "Contas")
    private WebElement linkContas;
    @FindBy(linkText = "Adicionar")
    private WebElement linkAdicionarConta;
    @FindBy(linkText = "Listar")
    private WebElement linkListarContas;
    @FindBy(linkText = "Criar Movimentação")
    private WebElement linkAdicionarMovimentacao;
    @FindBy(linkText = "Resumo Mensal")
    private WebElement linkResumoMensal;

    // Methods
    public void acessaPaginaAdicionarConta() {
        this.linkContas.click();
        this.linkAdicionarConta.click();
    }

    public void acessaPaginaListarContas() {
        this.linkContas.click();
        this.linkListarContas.click();
    }

    public void acessaPaginaAdicionarMovimentacao() {
        this.linkAdicionarMovimentacao.click();
    }

    public void acessaPaginaResumoMensal() {
        this.linkResumoMensal.click();
    }
}
