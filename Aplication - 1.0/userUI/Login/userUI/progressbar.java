package Login.userUI;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import java.awt.Font;

class progressbar  {

	JProgressBar progress = new JProgressBar();
	JFrame frame = new JFrame();

	public class temp extends Thread {
		public void run() {
			while (progress.getValue() <= 100) {
				try {
					sleep(45);
					progress.setValue(progress.getValue() + 10);
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}

			}
			
		
		}

	}
	public void bar() {
		new temp().start();
		janelaconfig();
		progress.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		progress.setBounds(40, 40, 500, 50);
		progress.setStringPainted(true);
		if (progress.getValue() == 100) {
			progress.setValue(100);
		} else {
              
		}
		progress.setMaximum(100);
		progress.setForeground(new Color(50, 200, 50));
	
	}

	public void janelaconfig() {

		frame.setTitle("Carregamento");
		frame.setVisible(true);
		frame.setSize(600, 170);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(progress);

	}


/*	public static void main(String[] args) {
		progressbar barra = new progressbar();
		barra.bar();
		
	}*/
}
