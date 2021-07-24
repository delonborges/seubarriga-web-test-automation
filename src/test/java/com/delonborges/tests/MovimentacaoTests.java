package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTests extends BaseTest {

    MenuComponent menuComponent = new MenuComponent();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void inserirMovimentacaoComSucessoTest() {
        menuComponent.acessarPaginaAdicionarMovimentacao();
        movimentacaoPage.preencheFormularioMovimentacao(
                "24/07/2021",
                "24/07/2021",
                "Movimentação",
                "Delon",
                "123.45",
                "Conta de teste alterada"
        );

        String mensagemEsperada = "Movimentação adicionada com sucesso!";
        String mensagemAtual = movimentacaoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
