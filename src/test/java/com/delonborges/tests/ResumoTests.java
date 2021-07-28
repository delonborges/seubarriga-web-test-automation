package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTests extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final ResumoPage resumoPage = new ResumoPage();

    @Test
    public void excluiMovimentacaoComSucessoTest() {
        this.menuComponent.acessaPaginaResumoMensal();
        this.resumoPage.clicaLinkRemoverMovimentacao();

        String mensagemEsperada = "Movimentação removida com sucesso!";
        String mensagemAtual = this.resumoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void resumoMensalTest() {
        this.menuComponent.acessaPaginaResumoMensal();

        Integer quantidadeEsperada = 6;
        Integer quantidadeAtual = this.resumoPage.retornaQuantidadeLinhasTabela();

        Assert.assertEquals(quantidadeEsperada, quantidadeAtual);
    }
}
