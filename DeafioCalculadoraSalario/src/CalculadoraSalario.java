
public class CalculadoraSalario {
	
	public static long calcularSalarioLiquido(double salario) {
		if(testarSalarioMinimo(salario)) {
			double salBrutoMenosInss, salarioLiquido;
			salBrutoMenosInss = salario - descontarINSS(salario);
			
			//testar se é isento de pagar imposto de renda antes de calcular o desconto
			if(isentoIrrf(salBrutoMenosInss)) {
				return Math.round(salBrutoMenosInss);
			}else{
				salarioLiquido = salBrutoMenosInss - descontarIrrf(salBrutoMenosInss);
				return Math.round(salarioLiquido);
			}
		}else{
			return Math.round(0.0);
		}
	}
	public static boolean testarSalarioMinimo(double salario) {
		return (salario >= 1039 ? true : false);// além de testar se é salario mínimo já testa se é negativo
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

}//Fim da Classe CalculadoraSalario

//file:///home/josiene/codenation/java-13/build/reports/tests/test/index.html
