package com.delonborges.suites;

import com.delonborges.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContasTests.class,
        MovimentacaoTests.class,
        RemoveContaMovimentacaoTests.class,
        SaldoTests.class,
        ResumoTests.class
}
)
public class GeneralSuite {
}
