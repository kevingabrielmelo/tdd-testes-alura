package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void bonusDeviaSer0PorContaDoSalarioAlto() {

        BonusService bonusService = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario(
                        "Lucas", LocalDate.now(), new BigDecimal("25000"))));

    }

    @Test
    void bonusDeviaSer10PorCentoDoSalario() {

        BonusService bonusService = new BonusService();

        BigDecimal bigDecimal =
                bonusService.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("6000")));

        assertEquals(new BigDecimal("600.0"), bigDecimal);
    }

    @Test
    void bonusParaFuncionarioComSalarioExatamente10000() {

        BonusService bonusService = new BonusService();

        BigDecimal bigDecimal =
                bonusService.calcularBonus(new Funcionario("Kevin", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bigDecimal);
    }
}
