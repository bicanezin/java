/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if66j.testes;

import if66j.codigos.Calculadora;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erica
 */
public class CalculadoraTeste {
    
Calculadora calculadora;
	/**
	  * Este método é invocado antes de cada teste, a annotation facilita isso
	  */
	@Before
	public void setUp() {
		//Tudo aqui será executado antes, servindo por exemplo para inicializar.
		calculadora = new Calculadora();
	}
        
     
	/**
          * Teste comum, o método assertEquals realiza a operação de teste de igualdade.
          */
	@Test
	public void testeSimples() {
		int result;
		result = calculadora.somarInt(1, 2);
		assertEquals(3, result); //compara resultado esperado com resultado retornado
	}

	/**
	  * Teste para números de ponto flutuante.
	  * Destaque para o terceiro parâmetro, o delta, que define qual a diferença decimal entre cada parâmetro.
          * O propósito do parâmetro delta desse método é determinar o valor máximo da diferença entre os números 
          * expected e actual para que eles sejam considerados o mesmo valor.
	  */
	@Test
	public void testeDePontoFlutuante() throws Exception {
		float result;
		result = calculadora.divide(5, 3);
		//O terceiro parâmetro é a diferença máxima entre os floats
		assertEquals(1.7, result, 0.1);
	}

	/**
	  * Teste para exceções
	  * Se não disparar a exceção, o método falha.
	  */
        @Test
	public void testeDeExcecao() {
		float result;
                try {        
                    result = calculadora.divide(5, 0);
                    fail("não deveria chegar aqui!");
                }catch (Exception ex1) {
            assertEquals("Não é possível dividir por zero", ex1.getMessage());
        }
    }
}
