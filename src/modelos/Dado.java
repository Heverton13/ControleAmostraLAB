package modelos;

public class Dado {
	
	private int valorFace;

	public int getValorFace() {
		return valorFace;
	}

	public void setValorFace() {
          
			 valorFace = (int) (1 + Math.random() * 6); 
			/* pegando n�mero aleat�rio de 1 a 6, o int faz com que o met�do retorne 
			  um valor inteiro o met�do matg.rondom gera n�meros aleat�rios double po isso
			  se faz necess�ria a inser��o do int antes do met�do afim de converter o valor
			  multiplica o n�mero alet�rio por 6 n�o entendi bem...;
			*/
	}
	
	
}
