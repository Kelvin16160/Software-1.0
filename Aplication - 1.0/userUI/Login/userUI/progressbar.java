package Login.userUI;

import javax.swing.JFrame;

public class progressbar extends JFrame {
	public JFrame barra;
	public progressbar(){
		progressconfig();
	}
public void progressconfig (){

	setTitle("Carregamento");
	setVisible(true);
	setSize(300, 120);
	setLocationRelativeTo(null);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	
}

public static void main(String[] args ) {
	new progressbar();
}
}
