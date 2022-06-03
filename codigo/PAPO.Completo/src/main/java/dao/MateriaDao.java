package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Materia;

public class MateriaDao extends DAO {

	public MateriaDao() {
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Materia a) {
		boolean status = false;
		try {
			String query = "INSERT INTO materia(sigla,nome) VALUES ('"			//Inserir a SQL String
					+ a.getSigla() + "', '" + a.getNome() + "');";
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
	
	public boolean update(Materia a) {
		boolean status = false;
		if(delete(a.getSigla()) == true) {
			status = insert(a);
			
		}
		return status;
	}
	
	public boolean delete(String sigla) {
		boolean status = false;
		
		try {
			String query = "DELETE FROM materia WHERE sigla='" + sigla + "';";
			Statement st = conexao.createStatement();
			st.executeUpdate(query);
			st.close();
			status = true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}

	public List<Materia> get(){
		List<Materia> materias = new ArrayList<Materia>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM materia";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Materia materia = new Materia(rs.getString("sigla"),rs.getString("nome"));		//Inserir parametros
				materias.add(materia);
			}
			
			st.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return materias;
	}

	public Materia getMateria(String id) {
		Materia materia = new Materia();
		
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM materia WHERE id=" + id);
			if(rs.next()) {
				materia = new Materia(rs.getString("sigla"),rs.getString("nome"));		//Inserir parametros

			}
			
			st.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return materia;
	}

	public List<Materia> search(String busca){
	    List<Materia> materias = new ArrayList<Materia>();
	    
	    try {
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        String query = "SELECT materia.sigla,materia.nome,professor.id AS professor\r\n"
	        		+ "FROM materia\r\n"
	        		+ "INNER JOIN leciona\r\n"
	        		+ "ON materia.sigla = leciona.materia_sigla\r\n"
	        		+ "INNER JOIN professor\r\n"
	        		+ "ON leciona.professor_id = professor.id\r\n"
	        		+ "WHERE materia.nome LIKE '" + busca + "%';";
	        //System.out.println(query);
	        ResultSet rs = st.executeQuery(query);
	        while(rs.next()) {
	            Materia materia = new Materia(rs.getString("sigla"),rs.getString("nome"),rs.getString("professor"));
	            materias.add(materia);
	        }
	        
	        st.close();
	    } catch(Exception e) {
	        System.err.println(e.getMessage());
	    }
	    
	    return materias;
	}
}
