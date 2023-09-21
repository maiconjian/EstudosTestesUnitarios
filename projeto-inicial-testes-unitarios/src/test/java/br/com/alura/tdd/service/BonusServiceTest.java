package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
     void bonusDeveriaSerZeroParaSalarioAlto(){
         BonusService service = new BonusService();
         assertThrows(IllegalArgumentException.class,()->service.calcularBonus(new Funcionario("Maicon", LocalDate.now(), new BigDecimal(25000))));

//        assertEquals(BigDecimal.ZERO,bonus);

//        Bom para capturar a mensagem da exeption
//        try{
//            service.calcularBonus(new Funcionario("Maicon", LocalDate.now(), new BigDecimal(25000)));
//            fail("erro");
//        }catch (Exception e){
//            assertEquals("Funcionario com salario maior de R$ 10.000,00,não pode ter bonus",e.getMessage());
//        }
     }


    @Test
    void bonusDeveriaSer10PorCentodoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Maicon", LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.0"),bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentodoParaSalarioDe10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Maicon", LocalDate.now(), new BigDecimal(1000)));

        assertEquals(new BigDecimal("100.0"),bonus);
    }

}