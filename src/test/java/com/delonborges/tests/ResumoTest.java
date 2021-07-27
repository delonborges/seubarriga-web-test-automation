package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final ResumoPage resumoPage = new ResumoPage();

    @Test
    public void excluiMovimentacaoComSucessoTest() {
        menuComponent.acessaPaginaResumoMensal();
        resumoPage.clicaLinkRemoverMovimentacao();

        String mensagemEsperada = "Movimentação removida com sucesso!";
        String mensagemAtual = resumoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
