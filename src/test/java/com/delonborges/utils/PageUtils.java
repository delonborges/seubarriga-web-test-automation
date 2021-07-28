package com.delonborges.utils;

import com.delonborges.common.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.delonborges.common.DriverFactory.getDriver;

public class PageUtils {

    //Methods
    public static String obtemTituloPagina() {
        return getDriver().getTitle();
    }

    public static String obtemValorCelula(String colunaBusca, String valor, String colunaBotao, WebElement tabela) {
        return obtemCelula(colunaBusca, valor, colunaBotao, tabela).getText();
    }

    public static void clicaBotaoEditarContaTabela(String colunaBusca, String valor, String colunaBotao, WebElement tabela) {
        WebElement celula = obtemCelula(colunaBusca, valor, colunaBotao, tabela);

        celula.findElement(By.cssSelector("a[href^='/editarConta']")).click();
    }

    public static void clicaBotaoRemoverContaTabela(String colunaBusca, String valor, String colunaBotao, WebElement tabela) {
        WebElement celula = obtemCelula(colunaBusca, valor, colunaBotao, tabela);

        celula.findElement(By.cssSelector("a[href^='/removerConta']")).click();
    }

    // Helpers
    private static WebElement obtemCelula(String colunaBusca, String valor, String colunaBotao, WebElement tabela) {
        int idColuna = obtemIndiceColuna(colunaBusca, tabela);
        int idLinha = obtemIndiceLinha(valor, tabela, idColuna);
        int idColunaBotao = obtemIndiceColuna(colunaBotao, tabela);

        return tabela.findElement(By.cssSelector("tr:nth-child(" + idLinha + ") > td:nth-child(" + idColunaBotao + ")"));
    }

    private static Integer obtemIndiceLinha(String valor, WebElement tabela, Integer idColuna) {
        List<WebElement> linhas = tabela.findElements(By.cssSelector("tbody > tr > td:nth-child(" + idColuna + ")"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    private static Integer obtemIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.tagName("th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }
}
