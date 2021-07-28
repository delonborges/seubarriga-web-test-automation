package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.delonborges.utils.PageUtils.obtemTituloPagina;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTests extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final ResumoPage resumoPage = new ResumoPage();

    @Test
    public void t01_excluiMovimentacaoComSucessoTest() {
        menuComponent.acessaPaginaResumoMensal();
        resumoPage.clicaLinkRemoverMovimentacao();

        String mensagemEsperada = "Movimentação removida com sucesso!";
        String mensagemAtual = resumoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void t02_resumoMensalTest() {
        menuComponent.acessaPaginaResumoMensal();

        String tituloEsperado = "Seu Barriga - Extrato";
        String tituloAtual = obtemTituloPagina();

        Assert.assertEquals(tituloEsperado, tituloAtual);
    }
}
