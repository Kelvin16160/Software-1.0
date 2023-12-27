package userDTO;


/*Classe que Recebe os valores de Usuario e senha como parametro vindo da Classe de Login, e Atribuindo para as Variaveis de Classe */
public class UserDTO {

	private static String usuario;
	private static String senha;
	private static String Cad_Login;
	private static String Cad_Senha;

	public String getCad_Login() {
		return Cad_Login;
	}

	public void setCad_Login(String cad_Login) {
	   UserDTO.Cad_Login = cad_Login;
	}

	public String getCad_Senha() {
		return Cad_Senha;
	}

	public void setCad_Senha(String cad_Senha) {
		UserDTO.Cad_Senha = cad_Senha;
	}
    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		UserDTO.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		UserDTO.senha = senha;
	}

		
	}

