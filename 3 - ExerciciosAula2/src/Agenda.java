
public class Agenda extends Pessoa{
	private Pessoa agenda[] = new Pessoa[10];
	
	public void armazenarPessoa(String nome, int idade, float altura) {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome(nome);
		pessoa1.setAltura(altura);
		pessoa1.setDataNasc(" ");
		pessoa1.setIdade(idade);
		
		byte posicao = retornarPosicaoLivre();
		if(posicao >= 0) {
			this.agenda[posicao] = pessoa1;
		}
		else
			System.out.println("Não há mais espaço na agenda!");
	}
	
	public void removerPessoa(String nome) {
		byte posicao = buscarPosicaoPessoa(nome);
		if(posicao == agenda.length)
			System.out.println("Nome não está na Agenda!");
		else
			this.agenda[posicao] = null;
	}
	
	public byte buscarPosicaoPessoa(String nome) {
		byte i;
		for (i = 0; i < agenda.length; i++)
			if(this.agenda[i].getNome().equalsIgnoreCase(nome)){
				return i;
			}		
		return i;
	}
	
	public Pessoa buscarPessoa(String nome) {
		byte i = buscarPosicaoPessoa(nome);
		if(i == agenda.length)
			return null;
		else
			return this.agenda[i];
	}
	
	private byte retornarPosicaoLivre() {
		for (byte i = 0; i < agenda.length; i++)
			if(agenda[i] == null) 
				return i;
		
		return -1;
	}

	public void imprimirAgenda() {
		//precisará percorrer a agenda por inteiro pois podem haver posições null no array
		for(byte i = 0; i < agenda.length; i++)
			if(this.agenda[i] != null)
				imprimirPessoa(i);
	}
	
	public void imprimirPessoa(byte i) {
		System.out.println("O nome é: " + this.agenda[i].getNome());
		System.out.println("A data de nasciemento é: " + this.agenda[i].getDataNasc());
		System.out.println("A Aultura é: " + this.agenda[i].getAltura());
		System.out.println("A idade de " +this.agenda[i].getNome()+ " é: " +this.agenda[i].getIdade()+ "\n");
	}
	
	public Pessoa[] getAgenda() {
		return agenda;
	}

	public void setAgenda(Pessoa agenda[]) {
		this.agenda = agenda;
	}
	
}
