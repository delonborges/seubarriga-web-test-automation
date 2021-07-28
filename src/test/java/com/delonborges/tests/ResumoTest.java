package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

import static com.delonborges.utils.PageUtils.obtemTituloPagina;

public class ResumoTest extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final ResumoPage resumoPage = new ResumoPage();

    @Test
    public void resumoMensalTest() {
        menuComponent.acessaPaginaResumoMensal();

        String tituloEsperado = "Seu Barriga - Extrato";
        String tituloAtual = obtemTituloPagina();

        Assert.assertEquals(tituloEsperado, tituloAtual);
    }

    @Test
    public void excluiMovimentacaoComSucessoTest() {
        menuComponent.acessaPaginaResumoMensal();
        resumoPage.clicaLinkRemoverMovimentacao();

        String mensagemEsperada = "Movimentação removida com sucesso!";
        String mensagemAtual = resumoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
