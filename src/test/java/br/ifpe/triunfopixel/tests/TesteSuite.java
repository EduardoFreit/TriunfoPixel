package br.ifpe.triunfopixel.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.ifpe.triunfopixel.tests.GameTestes.class,
    br.ifpe.triunfopixel.tests.LoginRegisterTestes.class,
    br.ifpe.triunfopixel.tests.ConsoleTestes.class,
})
public class TesteSuite {
    
}
