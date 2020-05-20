package controller;

public class Grid {

	public String [] largada() {
		int k = 0;
		double [] largada = new double [14];
		String [] ordemLargada = new String [14];
		String auxCarro;
		double auxTempo;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				largada [k]= ThreadCarro.grid[i][j];
				ordemLargada[k] = ThreadCarro.ordemGrid[i][j];
				k++;
			}
		}
		for (int i = 0; i < 13; i++) {
			for (int j = i; j < 14; j++) {
				if(largada[i]>largada[j]) {
				  auxCarro = ordemLargada[i];
				  ordemLargada[i]=ordemLargada[j];
				  ordemLargada[j]=auxCarro;
				  auxTempo = largada[i];
				  largada [j] = largada[i];
				  largada[i]=auxTempo;
				}
			}
		}
		return (ordemLargada);
	}
}
