package controller;

import java.util.concurrent.Semaphore;

public class ThreadPorta extends Thread {

	private int pessoa;
	private Semaphore porta;

	public ThreadPorta(int pessoa, Semaphore porta) {
		this.porta = porta;
		this.pessoa = pessoa;
	}

	@Override
	public void run() {

		anda();
		try {
			System.out.println("Pessoa #" + pessoa + " chegou na porta");
			// --------P (Acquire)-----------
			porta.acquire();
			Thread.sleep((int) (Math.random() * 1000) + 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		} finally {
			// --------V (Release)-----------
			porta.release();
			pessoaPassou();
		}
	}

	private void anda() {
		
		int distancia = 0;
		System.out.println("Pessoa #" + pessoa + " começou a andar");
		
		while (distancia < 200) {
			distancia += (int) (Math.random() * 2) + 4;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void pessoaPassou() {
		System.out.println("Pessoa #" + pessoa + " passou a porta");
	}
}
