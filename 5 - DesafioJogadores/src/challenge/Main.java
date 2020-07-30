package challenge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Main {
		
	public void imprimirPlayer(List<Player> players) {
		int i = 0;
		while(i < players.size()) {
			System.out.println(players.get(i).getFull_name());
			i++;
		}
		
	}
	
	public List<Player> lerArquivo(){
			/*
			 * Stream <String> file = Files.lines(Paths.get("/home/josiene/codenation/java-3/src/main/resources/data.csv")); 
			 * return file;
			 * Interessante utilizar Stream para ler o arquivo CSV, mas dificultaria a manipulação posterior
			 */
			Scanner scanner = null;
			List<Player> players = null;
			try {
			File arquivo = new File("/home/josiene/codenation/java-3/src/main/resources/data.csv");
			scanner = new Scanner(arquivo);
			
			players = new ArrayList<Player>();
			/*
			 * Player jogador = new Player();
			 * quando jogador estava sendo criado fora do while o array players 
			 * estava com todas as posições apontadas para o último elemento lindo no arquivo.
			 */
			
			while(scanner.hasNext()){
				String registro[] = scanner.nextLine().split(",");
				
				Player jogador = new Player();
				jogador.setId(registro[0]);
				jogador.setName(registro[1]);
				jogador.setFull_name(registro[2]);
				jogador.setClub(registro[3]);
				jogador.setAge(registro[6]);
				jogador.setBirth_date(registro[8]);
				jogador.setNationality(registro[14]);
				jogador.setEurwage(registro[17]);
				jogador.setEur_release(registro[18]);
				
				players.add(jogador);
			}
			}catch(IOException e) {
				e.getMessage();
			}
			scanner.close();
		
			players.remove(0);
			return players;
		}
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
		public int q1() throws IOException{
			List<Player> players = players = lerArquivo();
			return (int) players.stream().map(Player::getNationality).distinct().count();
		}

		// Quantos clubes (coluna `club`) diferentes existem no arquivo?
		// Obs: Existem jogadores sem clube.
		public int q2() throws IOException {
			List<Player> players = players = lerArquivo();
			//return (int) players.stream().filter(cl -> cl.getClub().toString() != " ").map(Player::getClub).distinct().count();
			return (int) players.stream().filter(cl -> !cl.getClub().isEmpty()).map(Player::getClub).distinct().count();
		}

		// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
		public List<String> q3() throws IOException{
			List<Player> players = players = lerArquivo();
			
			List<String> stream = players.stream().limit(20).map(Player::getFull_name).collect(Collectors.toList());
			return stream;
		}

		// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
		// (utilize as colunas `full_name` e `eur_release_clause`)
		public List<String> q4() throws IOException {
			List<Player> players = players = lerArquivo();
			//
			List<String> list = players.stream().filter(erc -> !erc.getEur_release().isEmpty()).sorted(Comparator.comparing((Player j) -> Double.parseDouble(j.getEur_release())).reversed()).
					map(Player::getFull_name).limit(10).collect(Collectors.toList());

			System.out.println(list);

			return list;

		}

		// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
		// (utilize as colunas `full_name` e `birth_date`)
		public List<String> q5() throws IOException {
			List<Player> players = players = lerArquivo();
			List<String> list = players.stream().sorted(Comparator.comparing(Player::getBirth_date)).
					map(Player::getFull_name).limit(10).collect(Collectors.toList());
			System.out.println(list);
			return list;	
		}

		// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
		// (utilize a coluna `age`)
		public Map<Integer, Integer> q6() throws IOException {
			List<Player> players = players = lerArquivo();
			Map<Integer, Long> quant = players.stream().collect(Collectors.groupingBy(Player::getAge, Collectors.counting()));
			System.out.println(quant);
			Map<Integer, Integer> map = quant.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().intValue()));
			System.out.println(map);
			return map;
		}

	}
//https://www.devmedia.com.br/explorando-a-classecomo contar qua-arraylist-no-java/24298

