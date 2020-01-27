
public class ValidarCpf {	
	
	public static boolean tamanhoString(String cpf) {
		return (cpf.length() == 11 ? true : false);
	}
	
	public static int[] transformarStringEmInt(String cpf) {
		int cpfNumeros [] = new int[11];
		for(int i = 0; i < 11; i++) {
			cpfNumeros[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));	
		}
		return cpfNumeros;
	}
	//Este método compara se todos os elementos do CPF são iguais
	public static boolean isElementosIguais(int cpf[]) {
		int flag=0;
		for(int i =0; i< cpf.length -1; i++) {
			if(cpf[i] == cpf[i+1])
				flag++;
		}
		System.out.println(flag);
		return (flag == 10 ? true : false);//o procedimento acima fará apenas 10 comparações
	}
	
	public static int somarDigitos(int cpf[]) {
		int soma = 0;
		for(int i = 0; i < 11; i++) {
			soma += cpf[i];
		}
		return soma;
	}
	//Este método compara se o número resultante da soma dos numeros do cpf resultou em um número com dois dígitos iguais
	public static void isDigitosIguais(int cpf[]) {
		int soma = somarDigitos(cpf);
		int soma2[] = new int[2];
		soma2[0] = soma / 10;
		soma2[1] = soma % 10;
		//System.out.println(soma2[0] + " " + soma2[1]);
		if(soma2[0] == soma2[1])
			System.out.println("A soma dos digitos do CPF gerou um número com dois "
					+ "dígitos iguais " + soma2[0] +" e "+ soma2[1]);
		else
			System.out.println("CPF INVÁLIDO! A soma dos digitos do CPF gerou um número com dois "
					+ "dígitos diferentes " + soma2[0] +" e "+ soma2[1]);
	}
	//verificação do cpf pelo primeiro dígito após o -
	public static boolean verificarPrimDigito(int cpf[]) {
		int soma = 0;
		for(int i = 0; i < 9; i++) 
			soma += cpf[i] * (10-i);
		
		soma = (soma * 10) % 11;
		soma = (soma == 10 ? 0 : soma);
		return (soma == cpf[9] ? true : false );
	}
	
	//verificação do cpf pelo segundo dígito após o -
	public static boolean verificarSegDigito(int cpf[]) {
		int soma = 0;
		for(int i = 0; i < 10; i++) 
			soma += cpf[i] * (11-i);
		
		soma = (soma * 10) % 11;
		soma = (soma == 10 ? 0 : soma);
		return (soma == cpf[10] ? true : false );				
	}
	
	public static String verificarEstado(int cpf[]) {
		String estado[] = {"Rio Grande do Sul","Distrito Federal – Goiás – "
				+ "Mato Grosso – Mato Grosso do Sul – Tocantins", 
				"Pará – Amazonas – Acre – Amapá – Rondônia – Roraima",
				"Ceará – Maranhão – Piauí", " Pernambuco – Rio Grande do Norte – "
				+ "Paraíba – Alagoas", "Bahia – Sergipe", "Minas Gerais", 
				" Rio de Janeiro – Espírito Santo", "São Paulo", "Paraná – Santa Catarina"}; 
		return estado[cpf[8]];
	}

}
