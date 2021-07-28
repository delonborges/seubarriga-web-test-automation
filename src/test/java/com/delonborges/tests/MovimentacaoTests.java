package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.components.MenuComponent;
import com.delonborges.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.delonborges.utils.DataUtils.obtemDataAtual;
import static com.delonborges.utils.DataUtils.obtemDataAtualEAdicionaDias;

public class MovimentacaoTests extends BaseTest {

    private final MenuComponent menuComponent = new MenuComponent();
    private final MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void insereMovimentacaoComSucessoTest() {
        this.menuComponent.acessaPaginaAdicionarMovimentacao();
        this.movimentacaoPage.preencheDataMovimentacao(obtemDataAtual());
        this.movimentacaoPage.preencheDataPagamento(obtemDataAtual());
        this.movimentacaoPage.preencheDescricao("Movimentação");
        this.movimentacaoPage.preencheInteressado("Delon");
        this.movimentacaoPage.preencheValor("123.45");
        this.movimentacaoPage.selecionaConta("Conta para movimentacoes");
        this.movimentacaoPage.marcaStatusPago();
        this.movimentacaoPage.clicaBotaoSalvar();

        String mensagemEsperada = "Movimentação adicionada com sucesso!";
        String mensagemAtual = this.movimentacaoPage.retornaMensagemDoAlertaDeSucesso();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void insereMovimentacaoSemCamposObrigatoriosTest() {
        this.menuComponent.acessaPaginaAdicionarMovimentacao();
        this.movimentacaoPage.clicaBotaoSalvar();

        List<String> mensagemEsperada = Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Valor é obrigatório",
                "Interessado é obrigatório",
                "Valor deve ser um número"
        );
        List<String> mensagemAtual = this.movimentacaoPage.retornaListaMensagemDoAlertaDeErro();

        Assert.assertTrue(mensagemAtual.containsAll(mensagemEsperada));
        Assert.assertEquals(6, mensagemAtual.size());
    }

    @Test
    public void insereMovimentacaoComDataFuturaTest() {
        this.menuComponent.acessaPaginaAdicionarMovimentacao();
        this.movimentacaoPage.preencheDataMovimentacao(obtemDataAtualEAdicionaDias(10));
        this.movimentacaoPage.preencheDataPagamento(obtemDataAtualEAdicionaDias(10));
        this.movimentacaoPage.preencheDescricao("Movimentação");
        this.movimentacaoPage.preencheInteressado("Delon");
        this.movimentacaoPage.preencheValor("123.45");
        this.movimentacaoPage.selecionaConta("Conta para movimentacoes");
        this.movimentacaoPage.marcaStatusPago();
        this.movimentacaoPage.clicaBotaoSalvar();

        String mensagemEsperada = "Data da Movimentação deve ser menor ou igual à data atual";
        String mensagemAtual = this.movimentacaoPage.retornaMensagemDoAlertaDeErro();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
