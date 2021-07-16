package com.delonborges.tests;

import com.delonborges.common.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AutenticacaoTests extends BaseTest {

    @Test
    public void efetuaLoginComSucessoTest() {
        String mensagemEsperada = "Bem vindo, Delon!";
        String mensagemAtual = loginPage.retornaMensagemDoAlerta();

        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }
}
