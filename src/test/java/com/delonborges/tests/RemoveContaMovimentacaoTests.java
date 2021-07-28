package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.ContaPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoveContaMovimentacaoTests extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final ContaPage contaPage = new ContaPage();

    @Test
    public void removeContaComMovimentacaoTest() {
        menuComponent.acessaPaginaListarContas();
        contaPage.clicaRemoverConta("Conta de teste alterada");

        String mensagemEsperada = "Conta em uso na movimentações";
        String mensagemAtual = contaPage.retornaMensagemDoAlertaDeErro();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
