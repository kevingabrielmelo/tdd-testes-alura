package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcento() {

        ReajusteService reajusteService = new ReajusteService();

        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcento() {

        ReajusteService reajusteService = new ReajusteService();

        Funcionario funcionario = new Funcionario("Mariana", LocalDate.now(), new BigDecimal("2000"));

        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeTrintaPorcento() {

        ReajusteService reajusteService = new ReajusteService();

        Funcionario funcionario = new Funcionario("Renata", LocalDate.now(), new BigDecimal("3000"));

        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("3900.00"), funcionario.getSalario());
    }
}
