package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDao extends DAO {

	public AlunoDao() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Aluno a) {
		boolean status = false;
		try {
			
			String senha = a.getPassword();
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
			String senhaMD5 = new BigInteger(1,m.digest()).toString(64);
			a.setPassword(senhaMD5);
			
			String query = "INSERT INTO aluno(Id,Username,Nome,Email,Telefone,Senha,Genero,DataNasc,Cep,"
					+ "Cidade,Estado,Papel,Descricao) VALUES ('"			//Inseriri a SQL String
					+ a.getId() + "', '" + a.getUsername()  + "', '" + a.getNome() + "', '" + a.getEmail()
					+ "', '" + a.getTelefone() + "', '" + a.getPassword() + "', '" +a.getGenero() + "', '"
					+ a.getDataNasc() + "', '" + a.getCep() + "', '" + a.getCidade() + "', '" + a.getEstado()
					+ "', '" + a.getPapel() + "', '" + a.getDescricao() + "');";
			//System.out.println(query);
			PreparedStatement st = conexao.prepareStatement(query);
			st.executeUpdate();
			st.close();
			status = true;
			System.out.println(query);
		} catch(SQLException u) {
			throw new RuntimeException(u);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
	public boolean update(Aluno a) {
		boolean status = false;
		if(delete(a.getId()) == true) {
			status = insert(a);
			
		}
		return status;
	}
	
	public boolean delete(String id) {
		boolean status = false;
		
		try {
			String query = "DELETE FROM aluno WHERE id='" + id + "';";
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			st.close();
			status = true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}

	public List<Aluno> get(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM aluno";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Aluno aluno = new Aluno(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getString("descricao"));		//Inserir parametros
				alunos.add(aluno);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return alunos;
	}

	public Aluno getAluno(String id) {
		Aluno aluno = new Aluno();
		
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM aluno WHERE id=" + id);
			if(rs.next()) {
				aluno = new Aluno(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getString("descricao"));		//Inserir parametros

			}
			
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return aluno;
	}
	
	public List<Aluno> search(String busca){
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//String query = "SELECT * FROM Professor WHERE nome LIKE '" + busca + "%' OR username LIKE '" + busca
					//+ "%' OR cidade LIKE '" + busca + "%' OR estado LIKE '" + "%' OR cidade LIKE '" + busca + "';" ;
			String query = "SELECT * FROM aluno WHERE nome LIKE '" + busca + "%' OR username LIKE '" + busca
					+ "%' OR cidade LIKE '" + busca + "%' OR estado LIKE '" + busca + "%';";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Aluno aluno = new Aluno(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getString("descricao"));		//Inserir parametros
				alunos.add(aluno);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return alunos;
	}
	
	public Aluno login(String email,String senha) {
		Aluno aluno = new Aluno();
		
		try {
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
			String senhaMD5 = new BigInteger(1,m.digest()).toString(64);
			System.out.println("MD5: "+ senhaMD5 + " len: " + senhaMD5.length());
			
			String query = "SELECT * FROM aluno WHERE email= ? AND senha= ?";
			PreparedStatement st = conexao.prepareStatement(query);
			st.setString(1,email);
			st.setString(2, senhaMD5);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				aluno = new Aluno(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getString("descricao"));		//Inserir parametros

			}
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(aluno.getUsername().equals("username")) {
			throw new RuntimeException("Email ou senha incorretos");
		}
		return aluno;
	}
}
