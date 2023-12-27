package userDAO;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import userDTO.UserDTO;

class Connection {

	public java.sql.Connection connection(UserDTO user) {
		
		final String host = "localhost";
		final String port = "3306";
		final String user1 = "root";
		final String password = "16160";
		
		
		java.sql.Connection conn = null;
		
	try {
		
		String url = "jdbc:Mysql://"+ host+ ":"+ port +"/project_equipe_6_kelvin_henrique?"+" user="+ user1+"&password=" + password;
		conn = DriverManager.getConnection(url);
		
	} catch (SQLException e) {
	
		JOptionPane.showMessageDialog(null, "Error de Conecxão\n" + e.getMessage());
	}
	return conn;
	}
}