import java.util.ArrayList;
import java.util.List;


public class DesafioApplication{ 
	
	public static List<Integer> fibonacci() {
		
		List<Integer> listaFibonacci = new ArrayList<Integer>();
		listaFibonacci.add(0);
		listaFibonacci.add(1);
		
		int index = 2;
		Integer element = 1;
		while(element <= 350) {
			//ficará com essa sequencia de instruções para adicionar o valor 377
			element = listaFibonacci.get(index-2) + listaFibonacci.get(index-1);
			listaFibonacci.add(element);
			index ++;			
		}
		return listaFibonacci;
		
	}
	
	public static Boolean isFibonacci(Integer a) {
		//esse código está muito cara de C, provavelmente pode ser melhorado
		
		List<Integer> listaFibonacci = new ArrayList<Integer>();
		listaFibonacci = fibonacci();
		Integer element;
		for(byte index = 0; index < 15; index++ ) {
			element = listaFibonacci.get(index);
		//Deve-se usar equals pois o operador == funciona apenas para valores entre -128 e 127
			if(element.equals(a)) {
				return true;
			}		
		}
		return false;
		
		/*Todo o código acima poderia ter sido substituido por esta única linha 
		 *return fibonacci().contains(a);
		 *Mas acabei utilizando o código acima na resoluçaõ do exercicio pois a solução abaixo não é minha.
		 */
		//return fibonacci().contains(a);
	}
}

		
	   

