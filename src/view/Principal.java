package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPorta;

public class Principal {
	
	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore porta = new Semaphore(permissoes);

		for (int pessoa = 1; pessoa <= 4; pessoa++) {
			Thread threadPorta = new ThreadPorta(pessoa, porta);
			threadPorta.start();
		}
	}
}