package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTests extends BaseTest {

    private final HomePage homePage = new HomePage();

    @Test
    public void saldoContaTest() {
        String valorEsperado = "534.00";
        String valorAtual = this.homePage.retornaSaldoConta("Conta para saldo");

        Assert.assertEquals(valorEsperado, valorAtual);
    }
}
