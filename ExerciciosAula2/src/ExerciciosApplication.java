import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExerciciosApplication {

	private static Date data;

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
		data = f.parse("30/03/1989");
		Pessoa pessoa1 = new Pessoa();;
		pessoa1 .setNome("Rodrigo");
		pessoa1.setAltura((float) 1.74);
		pessoa1.setDataNasc("24/04/1986");
		pessoa1.calcularIdade(data);
	
		pessoa1.imprimir();
		
		Agenda agenda1 = new Agenda();
		agenda1.armazenarPessoa("Josiene",30,(float) 1.64);
		agenda1.armazenarPessoa("Rodrigo",30,(float) 1.74);
		
		agenda1.imprimirAgenda();
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3 = agenda1.buscarPessoa("rodrigo");
		if(pessoa3 != null)
			pessoa3.imprimir();
		else
			System.out.println("Pessoa não encontrada");
		
		agenda1.removerPessoa("josiene");
		agenda1.imprimirAgenda();
		
		//agenda1.armazenarPessoa(pessoa);
		
		agenda1.imprimirAgenda();
	}

}
