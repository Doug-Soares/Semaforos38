package controller;

public class Grid {

	public String [] largada(double [] tempo, String [] posicoes) {
		int k = 0;
		double [] largada = new double [14];
		String [] ordemLargada = new String [14];
		String auxCarro;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				largada [k]= ThreadCarro.grid[i][j];
				ordemLargada[k] = ThreadCarro.ordemGrid[i][j];
				k++;
			}
		}
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 14; j++) {
				if(largada[i]>largada[j]) {
				  auxCarro = ordemLargada[i];
				  ordemLargada[i]=ordemLargada[j];
				  ordemLargada[j]=auxCarro;
				}
			}
		}
		return (ordemLargada);
	}
}