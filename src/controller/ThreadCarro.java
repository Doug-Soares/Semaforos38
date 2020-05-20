package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int numCarro;
	private int idEscuderia;
	private Semaphore sPista;
	private int voltas;
	
	private static boolean esc0 = false;
	private static boolean esc1 = false;
	private static boolean esc2 = false;
	private static boolean esc3 = false;
	private static boolean esc4 = false;
	private static boolean esc5 = false;
	private static boolean esc6 = false;
	
	public static double[][] grid = new double [2][7];
	public static String[][] ordemGrid = new String [2][7];
	
	
	Grid g = new Grid();

	public ThreadCarro(int numCarro, int idEscuderia, Semaphore sPista) {
		this.numCarro = numCarro;
		this.idEscuderia = idEscuderia;
		this.sPista = sPista;
	}

	public void run() {
		try {
			boxEspera();
			sPista.acquire();
			carroCorrendo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("Carro %d da escuderia %d saiu da pista %n", numCarro, idEscuderia);
			saida();
			sPista.release();
		}
	}

	private void carroCorrendo() {
		String dados;
		double voltaRapida = 9999.9;
		System.out.printf("Carro %d da escuderia %d entrou na pista %n", numCarro, idEscuderia);
		while (voltas < 3) {
			voltas++;
			double tempo = ((Math.random() * 2.5) + 1.5);
			try {
				sleep((long) (tempo*300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (tempo < voltaRapida) {
				voltaRapida = tempo;
			}
			System.out.printf("Carro %d da escuderia %d completou a volta %d em %.3f %n", numCarro, idEscuderia, voltas,
					tempo);
		}
		
			dados = "Carro "+ numCarro+ " da Escuderia "+idEscuderia;
			
			grid[numCarro][idEscuderia]=voltaRapida;
			ordemGrid[numCarro][idEscuderia]=dados;
	}
	
	private void boxEspera (){
		try {
			sleep((long) (Math.random()*100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (idEscuderia == 0) {
			while (esc0 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc0 = false;
		} else if (idEscuderia == 1) {
			while (esc1 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc1 = true;
		} else if (idEscuderia == 2) {
			while (esc2 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc2 = true;
		} else if (idEscuderia == 3) {
			while (esc3 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc3 = true;
		} else if (idEscuderia == 4) {
			while (esc4 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc4 = true;
		} else if (idEscuderia == 5) {
			while (esc5 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc5 = true;
		} else {
			while (esc6 == true) {
				try {
					sleep(300);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			esc6 = true;
		}
	}
	
	private void saida() {
		if (idEscuderia == 0) {
			esc0 = false;
		} else if (idEscuderia == 1) {
			esc1 = false;
		} else if (idEscuderia == 2) {
			esc2 = false;
		} else if (idEscuderia == 3) {
			esc3 = false;
		} else if (idEscuderia == 4) {
			esc4 = false;
		} else if (idEscuderia == 5) {
			esc5 = false;
		} else if (idEscuderia == 6) {
			esc6 = false;
		}
	}


}
