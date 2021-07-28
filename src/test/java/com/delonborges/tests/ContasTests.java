package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ContaPage;
import org.junit.Assert;
import org.junit.Test;

public class ContasTests extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final ContaPage contaPage = new ContaPage();

    @Test
    public void insereContaComSucessoTest() {
        this.menuComponent.acessaPaginaAdicionarConta();
        this.contaPage.preencheCampoNome("Conta de teste");
        this.contaPage.clicaBotaoSalvar();

        String mensagemEsperada = "Conta adicionada com sucesso!";
        String mensagemAtual = this.contaPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alteraContaComSucessoTest() {
        this.menuComponent.acessaPaginaListarContas();
        this.contaPage.clicaAlterarConta("Conta para alterar");
        this.contaPage.preencheCampoNome("Conta alterada");
        this.contaPage.clicaBotaoSalvar();

        String mensagemEsperada = "Conta alterada com sucesso!";
        String mensagemAtual = this.contaPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void insereContaComMesmoNomeTest() {
        this.menuComponent.acessaPaginaAdicionarConta();
        this.contaPage.preencheCampoNome("Conta mesmo nome");
        this.contaPage.clicaBotaoSalvar();

        String mensagemEsperada = "Já existe uma conta com esse nome!";
        String mensagemAtual = this.contaPage.retornaMensagemDoAlertaDeErro();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void removeContaComMovimentacaoTest() {
        this.menuComponent.acessaPaginaListarContas();
        this.contaPage.clicaRemoverConta("Conta com movimentacao");

        String mensagemEsperada = "Conta em uso na movimentações";
        String mensagemAtual = this.contaPage.retornaMensagemDoAlertaDeErro();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
