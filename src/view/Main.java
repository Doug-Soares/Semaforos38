package view;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

import controller.Grid;
import controller.ThreadCarro;

public class Main {
	
	public static void main(String[] args) {
		Grid g = new Grid();
		double [] tempos = new double [14];
		String [] carros = new String [14];
		
		int permissoesPista = 5;
		Semaphore sPista = new Semaphore(permissoesPista);
		
		int menu = 0;
		while(menu!=9) {
		menu = Integer.parseInt(JOptionPane.showInputDialog("1-iniciar Treino\n2-Ver Grid\n9-finalizar"));
		switch(menu) {
		case 1:
		for(int idEscuderia = 0; idEscuderia<7; idEscuderia++) {
			for (int idCarro = 0; idCarro < 2 ; idCarro++) {
				Thread tCarro = new ThreadCarro (idCarro, idEscuderia, sPista);
				tCarro.start();
			}
		}
		break;
		case 2:
			carros = g.largada(tempos,carros);
			for (int i = 0; i < carros.length; i++) {
				System.out.println(carros[i] + " é o "+(i+1)+"° a largar" );
			}
			break;
		case 9:
			System.out.println("Programa Finalizado");
		default:
		}
			
		}
	}
}
