package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTests extends BaseTest {

    private final HomePage homePage = new HomePage();

    @Test
    public void saldoContaTest() {
        String valorEsperado = "123.45";
        String valorAtual = homePage.retornaSaldoConta("Conta de teste alterada");

        Assert.assertEquals(valorEsperado, valorAtual);
    }
}
