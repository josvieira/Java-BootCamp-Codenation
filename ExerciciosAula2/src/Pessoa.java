import java.util.Date;

public class Pessoa {
	private String nome;
	private String dataNasc;
	private float altura;
	private int idade;
	


	public void calcularIdade(Date dataNasc) {
		Date hoje = new Date();
		
		// não é a melhor opção pois não considera a data atual completa
		int idade = hoje.getYear() - dataNasc.getYear();
		this.idade = idade;
		
	}	
	
	public void imprimir() {
		System.out.println("O nome é: " + this.nome);
		System.out.println("A data de nascimento é: " + this.dataNasc);
		System.out.println("A altura é: " + this.altura);
		System.out.println("A idade de " +this.nome+ " é: " +this.idade+ "\n");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public final String getDataNasc() {
		return dataNasc;
	}
	public final void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public final float getAltura() {
		return altura;
	}
	public final void setAltura(float altura) {
		this.altura = altura;
	}
	public final int getIdade() {
		return idade;
	}

	public final void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

}
