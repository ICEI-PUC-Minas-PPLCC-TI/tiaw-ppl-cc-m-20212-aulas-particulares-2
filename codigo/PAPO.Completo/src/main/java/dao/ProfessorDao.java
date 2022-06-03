package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Professor;
import java.security.*;
import java.math.*;

public class ProfessorDao extends DAO {

	public ProfessorDao() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Professor p) throws Exception {
		boolean status = false;
		
		try {
			String senha = p.getPassword();
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
			String senhaMD5 = new BigInteger(1,m.digest()).toString(64);
			p.setPassword(senhaMD5);
			System.out.println("senha normal: " + senha);
			System.out.println("senha md5: " + senhaMD5);
			String query = "INSERT INTO Professor(Id,Username,Nome,Email,Telefone,Senha,Genero,DataNasc,Cep,"
					+ "Cidade,Estado,Papel,Experiencia,Descricao) VALUES ('"			//Inseriri a SQL String
					+ p.getId() + "', '" + p.getUsername()  + "', '" + p.getNome() + "', '" + p.getEmail()
					+ "', '" + p.getTelefone() + "', '" + p.getPassword() + "', '" +p.getGenero() + "', '"
					+ p.getDataNasc() + "', '" + p.getCep() + "', '" + p.getCidade() + "', '" + p.getEstado()
					+ "', '" + p.getPapel() + "', " + p.getExperiencia() + ", '" + p.getDescricao() + "');";
			System.out.println(query);
			PreparedStatement st = conexao.prepareStatement(query);
			st.executeUpdate();
			st.close();
			status = true;
		} catch(SQLException u) {
			throw new RuntimeException(u);
		}
		
		return status;
	}
	
	public boolean insertUpdate(Professor p) throws Exception {
		boolean status = false;
		
		try {
			String query = "INSERT INTO Professor(Id,Username,Nome,Email,Telefone,Senha,Genero,DataNasc,Cep,"
					+ "Cidade,Estado,Papel,Experiencia,Descricao) VALUES ('"			//Inseriri a SQL String
					+ p.getId() + "', '" + p.getUsername()  + "', '" + p.getNome() + "', '" + p.getEmail()
					+ "', '" + p.getTelefone() + "', '" + p.getPassword() + "', '" +p.getGenero() + "', '"
					+ p.getDataNasc() + "', '" + p.getCep() + "', '" + p.getCidade() + "', '" + p.getEstado()
					+ "', '" + p.getPapel() + "', " + p.getExperiencia() + ", '" + p.getDescricao() + "');";
			System.out.println("insert update: " + query);
			PreparedStatement st = conexao.prepareStatement(query);
			st.executeUpdate();
			st.close();
			status = true;
		} catch(SQLException u) {
			throw new RuntimeException(u);
		}
		
		return status;
	}
	
	public boolean update(Professor p) {
		boolean status = false;
		try {
			if(delete(p.getId()) == true) {
				status = insertUpdate(p);
				
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
	public boolean delete(String id) {
		boolean status = false;
		
		try {
			String query = "DELETE FROM professor WHERE id='" + id + "';";
			System.out.println(query);
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			st.close();
			status = true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}

	public List<Professor> get(){
		List<Professor> professores = new ArrayList<Professor>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM Professor";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Professor professor = new Professor(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getInt("experiencia"),
						rs.getString("descricao"));		//Inserir parametros
				String materias = this.getProfessorMateria(professor.getId()).toString();
				professor.setMaterias(materias);
				professores.add(professor);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return professores;
	}

	public Professor getProfessor(String id) {
		Professor professor = new Professor();
		
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM professor WHERE id='" + id + "';");
			if(rs.next()) {
				professor = new Professor(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getInt("experiencia"),
						rs.getString("descricao"));		//Inserir parametros
				String materias = this.getProfessorMateria(professor.getId()).toString();
				professor.setMaterias(materias);
			}
			
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return professor;
	}
	
	public List<Professor> search(String busca){
		List<Professor> professores = new ArrayList<Professor>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//String query = "SELECT * FROM Professor WHERE nome LIKE '" + busca + "%' OR username LIKE '" + busca
					//+ "%' OR cidade LIKE '" + busca + "%' OR estado LIKE '" + "%' OR cidade LIKE '" + busca + "';" ;
			String query = "SELECT * FROM Professor WHERE nome LIKE '" + busca + "%' OR username LIKE '" + busca
					+ "%' OR cidade LIKE '" + busca + "%' OR estado LIKE '" + busca + "%';";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Professor professor = new Professor(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getInt("experiencia"),
						rs.getString("descricao"));		//Inserir parametros
				String materias = this.getProfessorMateria(professor.getId()).toString();
				professor.setMaterias(materias);
				professores.add(professor);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return professores;
	}
	
	public Professor login(String email,String senha) throws Exception {
		Professor professor = new Professor();
		
		try {
			
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
			String senhaMD5 = new BigInteger(1,m.digest()).toString(64);
			System.out.println("MD5: "+ senhaMD5 + " len: " + senhaMD5.length());
			
			String query = "SELECT * FROM professor WHERE email= ? AND senha= ?";
			PreparedStatement st = conexao.prepareStatement(query);
			st.setString(1,email);
			st.setString(2, senhaMD5);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				professor = new Professor(rs.getString("id"),rs.getString("username"),
						rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("senha"),
						rs.getString("genero"),rs.getString("datanasc"),rs.getString("cep"),rs.getString("cidade"),
						rs.getString("estado"),rs.getString("papel"),rs.getInt("experiencia"),
						rs.getString("descricao"));		//Inserir parametros
				String materias = this.getProfessorMateria(professor.getId()).toString();
				professor.setMaterias(materias);
			}
			
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		if(professor.getUsername().equals("username")) {
			throw new Exception("Email ou senha incorretos");
		}
		return professor;
	}

	public List<String> getProfessorMateria(String idProfessor){
		List<String> resultado = new ArrayList<String>();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT professor.username, leciona.professor_id, "
					+ "leciona.materia_sigla, materia.nome "
					+ "FROM professor "
					+ "INNER JOIN leciona ON professor.id = leciona.professor_id "
					+ "INNER JOIN materia ON leciona.materia_sigla = materia.sigla "
					+ "WHERE professor.id = '" + idProfessor + "';";
			//System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				resultado.add(rs.getString("nome"));
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}
}
