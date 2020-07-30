package br.com.codenation.calculadora;



public class CalculadoraSalario {


	public long calcularSalarioLiquido(double salarioBase) {

		//Use o Math.round apenas no final do método para arredondar o valor final.

		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if(testarSalarioMinimo(salarioBase)) {

			double salBrutoMenosInss, salarioLiquido;

			salBrutoMenosInss = salarioBase - descontarINSS(salarioBase);

			

			//testar se é isento de pagar imposto de renda antes de calcular o desconto

			if(isentoIrrf(salBrutoMenosInss)) {

				return Math.round(salBrutoMenosInss);

			}//não coloquei else pois se o if for verdadeiro sai do método

			salarioLiquido = salBrutoMenosInss - descontarIrrf(salBrutoMenosInss);

			return Math.round(salarioLiquido);

		}

		return Math.round(0.0);

	}

	

	

	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo

	public static boolean testarSalarioMinimo(double salario) {

		return (salario >= 1039.00 ? true : false);

	}

	

	public static double descontarINSS(double salario) {

		if(salario <= 1500) {

			return salario * 0.08;

		}

		else if(salario <= 4000) {

			return salario * 0.09;

		}

		else {

			return salario * 0.11;

		}

	}//fim método descontoINSS

	

	public static boolean isentoIrrf(double salario) {

		return (salario <= 3000 ? true : false);

	}

	

	public static double descontarIrrf(double salario) {

		return (salario <= 6000 ? salario * 0.075 : salario * 0.15);

	}//Fim método descontoIrrf



}

/*Dúvidas ou Problemas?

Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 

*/
