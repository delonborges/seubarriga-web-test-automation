package com.delonborges.suites;

import com.delonborges.tests.ContasTests;
import com.delonborges.tests.MovimentacaoTests;
import com.delonborges.tests.ResumoTests;
import com.delonborges.tests.SaldoTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContasTests.class,
        MovimentacaoTests.class,
        SaldoTests.class,
        ResumoTests.class
})

public class GeneralSuite {
}
