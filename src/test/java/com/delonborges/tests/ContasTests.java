package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ContaPage;
import org.junit.Assert;
import org.junit.Test;

public class ContasTests extends BaseTest {

    MenuComponent menuComponent = new MenuComponent();
    ContaPage contaPage = new ContaPage();

    @Test
    public void insereContaComSucessoTest() {
        menuComponent.acessaPaginaAdicionarConta();
        contaPage.preencheCampoNome("Conta de teste");
        contaPage.clicaBotaoSalvar();

        String mensagemEsperada = "Conta adicionada com sucesso!";
        String mensagemAtual = contaPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alteraContaComSucessoTest() {
        menuComponent.acessaPaginaListarContas();
        contaPage.clicaAlterarConta("Conta de teste");
        contaPage.preencheCampoNome("Conta de teste alterada");
        contaPage.clicaBotaoSalvar();

        String mensagemEsperada = "Conta alterada com sucesso!";
        String mensagemAtual = contaPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void insereContaComMesmoNomeTest() {
        menuComponent.acessaPaginaAdicionarConta();
        contaPage.preencheCampoNome("Conta de teste alterada");
        contaPage.clicaBotaoSalvar();

        String mensagemEsperada = "Já existe uma conta com esse nome!";
        String mensagemAtual = contaPage.retornaMensagemDoAlertaDeErro();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
