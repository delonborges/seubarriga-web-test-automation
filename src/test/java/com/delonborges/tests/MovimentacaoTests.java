package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.delonborges.utils.DataUtils.*;

public class MovimentacaoTests extends BaseTest {

    MenuComponent menuComponent = new MenuComponent();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void insereMovimentacaoComSucessoTest() {
        menuComponent.acessaPaginaAdicionarMovimentacao();
        movimentacaoPage.preencheDataMovimentacao(obtemDataAtual());
        movimentacaoPage.preencheDataPagamento(obtemDataAtual());
        movimentacaoPage.preencheDescricao("Movimentação");
        movimentacaoPage.preencheInteressado("Delon");
        movimentacaoPage.preencheValor("123.45");
        movimentacaoPage.selecionaConta("Conta de teste alterada");
        movimentacaoPage.marcaStatusPago();
        movimentacaoPage.clicaBotaoSalvar();

        String mensagemEsperada = "Movimentação adicionada com sucesso!";
        String mensagemAtual = movimentacaoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void insereMovimentacaoSemCamposObrigatoriosTest() {
        menuComponent.acessaPaginaAdicionarMovimentacao();
        movimentacaoPage.clicaBotaoSalvar();

        List<String> mensagemEsperada = Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Valor é obrigatório",
                "Interessado é obrigatório",
                "Valor deve ser um número"
        );
        List<String> mensagemAtual = movimentacaoPage.retornaListaMensagemDoAlertaDeErro();

        Assert.assertTrue(mensagemAtual.containsAll(mensagemEsperada));
        Assert.assertEquals(6, mensagemAtual.size());
    }

    @Test
    public void insereMovimentacaoComDataFuturaTest() {
        menuComponent.acessaPaginaAdicionarMovimentacao();
        movimentacaoPage.preencheDataMovimentacao(obtemDataAtualEAdicionaDias(10));
        movimentacaoPage.preencheDataPagamento(obtemDataAtualEAdicionaDias(10));
        movimentacaoPage.preencheDescricao("Movimentação");
        movimentacaoPage.preencheInteressado("Delon");
        movimentacaoPage.preencheValor("123.45");
        movimentacaoPage.selecionaConta("Conta de teste alterada");
        movimentacaoPage.marcaStatusPago();
        movimentacaoPage.clicaBotaoSalvar();

        String mensagemEsperada = "Data da Movimentação deve ser menor ou igual à data atual";
        String mensagemAtual = movimentacaoPage.retornaMensagemDoAlertaDeErro();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
