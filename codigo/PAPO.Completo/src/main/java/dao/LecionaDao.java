package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Leciona;

public class LecionaDao extends DAO {

	public LecionaDao() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Leciona a) {
		boolean status = false;
		try {
			String query = "INSERT INTO leciona(id,professor_id,aluno_id,descricao,valor,materia_sigla,horario) VALUES ('"			//Inserir a SQL String
					+ a.getId() + "', '" + a.getProfessorId()  + "', '" + a.getAlunoId() + "', '" + a.getDescricao()
					+ "', '" + a.getValor() + "', '" + a.getMateriaSigla() + "', '" +a.getHorario() + "');";
			//System.out.println(query);
			PreparedStatement st = conexao.prepareStatement(query);
			st.executeUpdate();
			st.close();
			status = true;
		} catch(SQLException u) {
			throw new RuntimeException(u);
		}
		
		return status;
	}
	
	public boolean update(Leciona a) {
		boolean status = false;
		if(delete(a.getId()) == true) {
			status = insert(a);
			
		}
		return status;
	}
	
	public boolean delete(String id) {
		boolean status = false;
		
		try {
			String query = "DELETE FROM leciona WHERE id='" + id + "';";
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			st.close();
			status = true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}
	
	public boolean deleteByProfessor(String id) {
		boolean status = false;
		
		try {
			String query = "DELETE FROM leciona WHERE professor_id='" + id + "';";
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			st.close();
			status = true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}

	public List<Leciona> get(){
		List<Leciona> lecionas = new ArrayList<Leciona>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM leciona";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Leciona leciona = new Leciona(rs.getString("id"),rs.getString("professor_id"),
						rs.getString("aluno_id"),rs.getString("materia_sigla"),rs.getString("descricao"),rs.getInt("valor"),
						rs.getString("horario"));		//Inserir parametros
				lecionas.add(leciona);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return lecionas;
	}

	public Leciona getLeciona(String id) {
		Leciona leciona = new Leciona();
		
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM leciona WHERE id=" + id);
			if(rs.next()) {
				leciona = new Leciona(rs.getString("id"),rs.getString("professor_id"),
						rs.getString("aluno_id"),rs.getString("materia_sigla"),rs.getString("descricao"),rs.getInt("valor"),
						rs.getString("horario"));		//Inserir parametros

			}
			
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return leciona;
	}
}
