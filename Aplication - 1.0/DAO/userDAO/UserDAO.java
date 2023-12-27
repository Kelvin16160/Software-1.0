package userDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import userDTO.UserDTO;

public class UserDAO {

	/* Essas Variaveis de Classe recebem os Identificadores Ex: a Tabela do Banco + BD, e as Colunas Ex idusuario e Senha */
	public java.sql.Connection conn;
	String BD = "usuarios";
	String idusuario = "nome_usuario";
	String senha = "senha_usuario";

	/* Autenticação com o banco passando os get das Vaviaveis de Classe UserDTO, e utilizando os metodos de PreparedStatemant e ResultSet para a comparação com o Banco*/

	public ResultSet authentication01(UserDTO user) {


		conn = new Connection().connection(user);

		try {
			String sql = "select * from " + BD + " where " + idusuario + " = ?" + " and " + senha + " = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUsuario());
			pstm.setString(2, user.getSenha());
			return pstm.executeQuery();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Comparação com os Dados do Banco esta Errada " + e);

		}
		return null;
		
	}

	public ResultSet authentication(UserDTO  user) {


		conn = new Connection().connection(user);
		try {
			// Preparar a consulta SQL para inserir os dados
			String cad = "INSERT INTO usuarios (nome_usuario , senha_usuario)" + "VALUES" + "(? , ?)";
			PreparedStatement pstm = conn.prepareStatement(cad);
			pstm.setString(1, user.getCad_Login());
			pstm.setString(2, user.getCad_Senha());
			
			// Executar a consulta.
			
			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso");
			// Fechar a conexão com o banco de dados.
		} catch (SQLException err) {
			// Lidar com qualquer exceção que possa ocorrer durante a execução da consulta
			JOptionPane.showMessageDialog(null, "Erro ao Inserir dados no Bando de Dados\n" + err);
		}
	return null;
    }

}