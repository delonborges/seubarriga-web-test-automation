package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import com.delonborges.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class AutenticacaoTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    public void efetuaLoginComSucessoTest() {
        String mensagemEsperada = "Bem vindo, Delon!";
        String mensagemAtual = this.loginPage.retornaMensagemDoAlerta();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
