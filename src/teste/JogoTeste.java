package teste;

import modelos.Jogo;


public class JogoTeste {

	public static void main(String[] args) {
		
		Jogo jogo1 = new Jogo();
		jogo1.inserirJogadores();
		jogo1.inserirApostas();
		jogo1.jogarDados();
		jogo1.mostrarResultado();
		jogo1.mostrarVencedor();

	}

}
