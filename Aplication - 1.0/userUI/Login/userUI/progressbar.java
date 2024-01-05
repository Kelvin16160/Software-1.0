package Login.userUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import java.awt.Font;

class progressbar {

	JProgressBar progress = new JProgressBar();
	JFrame frame = new JFrame();

	public class temp extends Thread {
		public void run() {
			while (progress.getValue() <= 100) {
				try {
					sleep(45);
					progress.setValue(progress.getValue() + 10);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void janelaconfig() {
		bar();
		frame.setTitle("Carregamento");
		frame.setVisible(true);
		frame.setSize(619, 185);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(progress);
		
	}
	public void bar() {
		new temp().start();
		progress.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		progress.setBounds(40, 40, 500, 50);
		progress.setStringPainted(true);
		progress.setValue(0);
		progress.setMaximum(100);
		progress.setForeground(new Color(50, 200, 50));

	}


	/*
	 * public static void main(String[] args) { progressbar barra = new
	 * progressbar(); barra.bar();
	 * 
	 * }
	 */
}
