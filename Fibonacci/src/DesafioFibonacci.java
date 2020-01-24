import java.util.ArrayList;
import java.util.List;

public class DesafioFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesafioApplication listaFibonacci = new DesafioApplication();
		List<Integer> fibonacci =  new ArrayList<Integer>();
		fibonacci = DesafioApplication.fibonacci();
		/*
		Integer index =0;
		while(fibonacci.get(index) != null) {
			System.out.println(fibonacci.get(index));
			index ++;
		}
		*/	
	    Integer i = 18;
	    boolean n = DesafioApplication.isFibonacci(i);
	    System.out.println( n ? "O número "+i+" pertence à sequencia de Fibonacci" : 
	    					   "O número "+i+" não pertence à sequencia de Fibonacci");
	    

	}

}
