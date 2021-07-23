package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ContasPage;
import org.junit.Assert;
import org.junit.Test;

public class ContasTests extends BaseTest {

    MenuComponent menuComponent = new MenuComponent();
    ContasPage contasPage = new ContasPage();

    @Test
    public void inserirContaComSucessoTest() {
        menuComponent.acessarPaginaAdicionarConta();
        contasPage.adicionaConta("Conta do Teste");

        String mensagemEsperada = "Conta adicionada com sucesso!";
        String mensagemAtual = contasPage.retornaMensagemDoAlerta();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
