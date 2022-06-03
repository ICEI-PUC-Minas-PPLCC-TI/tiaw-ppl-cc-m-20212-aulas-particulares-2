package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Avalia;

public class AvaliaDao extends DAO {

	public AvaliaDao() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Avalia a) {
		boolean status = false;
		try {
			String query = "INSERT INTO avalia(professor_id,aluno_id,avaliacao,comentario) VALUES ('"			//Inserir a SQL String
					+ a.getProfessorId() + "', '" + a.getAlunoId()  + "', '" + a.getAvaliacao() + "', '" + a.getComentario() + "');";
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
	
	public boolean update(Avalia a) {
		boolean status = false;
		if(delete(a.getProfessorId(), a.getAlunoId()) == true) {
			status = insert(a);
			
		}
		return status;
	}
	
	public boolean delete(String professor_id, String aluno_id) {
		boolean status = false;
		
		try {
			String query = "DELETE FROM avalia WHERE professor_id='" + professor_id + "' AND aluno_id='" + aluno_id + "';";
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			st.close();
			status = true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}

	public List<Avalia> get(){
		List<Avalia> avalias = new ArrayList<Avalia>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM avalia";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Avalia avalia = new Avalia(rs.getString("professor_id"),rs.getString("aluno_id"),
						rs.getInt("avaliacao"),rs.getString("comentario"));		//Inserir parametros
				avalias.add(avalia);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return avalias;
	}

	public Avalia getAvalia(String id) {
		Avalia avalia = new Avalia();
		
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM avalia WHERE id=" + id);
			if(rs.next()) {
				avalia = new Avalia(rs.getString("professor_id"),rs.getString("aluno_id"),
						rs.getInt("avaliacao"),rs.getString("comentario"));		//Inserir parametros

			}
			
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return avalia;
	}
}
