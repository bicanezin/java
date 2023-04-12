/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if66j.codigos;

/**
 *
 * @author erica
 */
public class Calculadora {

        /**
	 * Método retorna a soma de dois números inteiros
	 * @param a, b
	 * @return total
	 */
        public int somarInt(int a, int b){
           int total = a + b;
           
           return total;
         }
        
          /**
	 * Método retorna a divisão de dois números float. Pode gerar uma exception se a divisão for por zero
	 * @param a
         * @param b
	 * @return total
         * @throws java.lang.Exception
	 */
        public float divide(float a,  float b) throws Exception{
            
        if (b == 0) {
            throw new Exception("Não é possível dividir por zero");
        }
           float total = a/b;          
           return total;
        }
		
	/**
	 * Método retorna a multiplicação todos os números que estão no vetor
	 * @param vet
	 * @return total
	 */
	public int multiplicar(int[] vet){
		
		int total = 1;
		
		for (int i=0; i<vet.length; i++){
			total *= vet[i];
		}
		
		return total;
	}
	
	
    /**
	 * Método retorna a soma todos os números que estão no vetor
	 * @param vet
	 * @return total
	 */
	public int somarVet(int[] vet){
		
		int total = 0;
		
		for (int i=0; i<vet.length; i++){
			total += vet[i];
		}
		
		return total;
	}
	
}
