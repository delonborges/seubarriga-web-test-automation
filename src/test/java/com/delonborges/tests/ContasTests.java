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
        contasPage.preencheCampoNome("Conta de teste");
        contasPage.clicaBotaoSalvar();

        String mensagemEsperada = "Conta adicionada com sucesso!";
        String mensagemAtual = contasPage.retornaMensagemDoAlerta();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alterarContaComSucessoTest() {
        menuComponent.acessarPaginaListarContas();
        contasPage.clicaAlterarConta("Conta de teste");
        contasPage.preencheCampoNome("Conta de teste alterada");
        contasPage.clicaBotaoSalvar();

        String mensagemEsperada = "Conta alterada com sucesso!";
        String mensagemAtual = contasPage.retornaMensagemDoAlerta();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
