package modelos;
import java.util.Scanner;

public class Jogo {
	
	private int resultado;
	
	Jogador j1 = new Jogador();
	Jogador j2 = new Jogador();
	
	Dado d1 = new Dado();
	Dado d2 = new Dado();
	
	Scanner input = new Scanner(System.in);
	
	public void inserirJogadores() {
		
		//System.out.println("-- DADOS JOGADOR 1 --");
		System.out.print("Informe seu nome jogador 1: ");
		String nome1 = input.next();
		j1.setNome(nome1);
		
		//Segundo Jogador ->
		
		//System.out.println("-- DADOS JOGADOR 2 --");
		System.out.print("Informe seu nome jogador 2: ");
		String nome2 = input.next();
		j2.setNome(nome2);
		
	}
	//Lembre-se de que a modularização e reutilização de código em java é primordiau
	//NADA DE CLASSES GRANDES E METÓDOS GIGANTES
	public void inserirApostas() {
		
		System.out.print("Informe sua aposta, " +  j1.getNome() + ":");
		int valor1 = input.nextInt();
		
		while(valor1 < 2 || valor1 > 12) {
			System.out.print("Valor fora do intervalo! Digite Novamente:");
			valor1 = input.nextInt();			
		}
			j1.setValorAposta(valor1);
			
		// Segundo jogador
		
		System.out.print("Informe sua aposta, " +  j2.getNome() + ":");
		int valor2 = input.nextInt();
		
		while(valor2 < 2 || valor2 > 12 || valor1 == valor2) {
			System.out.print("Valor fora do intervalo! Digite Novamente:");
			valor2 = input.nextInt();			
		}
			j2.setValorAposta(valor2);
		
	}
		
	public void jogarDados() {
		

		d1.setValorFace();
		d2.setValorFace();
		System.out.printf("Valores obtidos pelo dado: %d e %d%n", d1.getValorFace(),d2.getValorFace());
		
	}
	
	public void mostrarResultado() {
		
		resultado = d1.getValorFace()+d2.getValorFace();
		System.out.println("O valor obtido foi: "+ resultado);
	}
	
	public void mostrarVencedor() {
		
		if(resultado == j1.getValorAposta()) {
			System.out.println("Jagador " +  j1.getNome() + " ganhou !");
		}
		else if(resultado == j2.getValorAposta()) {
			System.out.println("Jagador " +  j2.getNome() + " ganhou !");
			
		}else {
			System.out.println("O computador venceu!");
		}
	}
}
