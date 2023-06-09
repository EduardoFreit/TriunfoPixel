package br.ifpe.triunfopixel.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.ifpe.triunfopixel.tests.game.GameTestes.class,
    br.ifpe.triunfopixel.tests.game.GameValidationTestes.class,
    br.ifpe.triunfopixel.tests.user.LoginRegisterTestes.class,
    br.ifpe.triunfopixel.tests.user.UserValidationTestes.class,
    br.ifpe.triunfopixel.tests.console.ConsoleTestes.class,
    br.ifpe.triunfopixel.tests.console.ConsoleValidationTestes.class
})
public class TesteSuite {
    
}
