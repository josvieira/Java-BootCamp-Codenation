
public class CPFApplication {

	public static void main(String[] args) {
		String cpf = "03357455551";
		//boolean result = Cpf.validarCpf(cpf);
		int arrayCpf[]	= new int[10];
		arrayCpf = ValidarCpf.transformarStringEmInt(cpf);
		if(!(ValidarCpf.isElementosIguais(arrayCpf))) {
			System.out.println(ValidarCpf.verificarPrimDigito(arrayCpf) ? "Primeiro dígito do CPF "
					+ "verificado" : "O cpf não é válido - Primeiro dígito não confere");
			System.out.println(ValidarCpf.verificarSegDigito(arrayCpf) ? "Segundo dígito do CPF "
					+ "verificado" : "O cpf não é válido - Segundo dígito não confere");
			ValidarCpf.isDigitosIguais(arrayCpf);
		}
		else {
			System.out.println("CPF inválido, todos os elementos são iguais");
		}
		}
	}
