package service;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import spark.*;
import model.Aluno;
import model.Leciona;
import model.Materia;
import model.Professor;
import dao.AlunoDao;
import dao.LecionaDao;
import dao.MateriaDao;
import dao.ProfessorDao;

@SuppressWarnings("unchecked")

public class Service {
	
	/*Área métodos gerais*/
	public static String search(Request request) {
		ProfessorDao professorDao = new ProfessorDao();
		professorDao.conectar();
		MateriaDao materiaDao = new MateriaDao();
		materiaDao.conectar();
		String resultado = new String();

		List<Professor> professores = professorDao.search(request.params("query"));
		JSONArray professoresJsonList = new JSONArray();
			
		List<Materia> materias = materiaDao.search(request.params("query"));	//Recupera uma lista das materias da busca com os professores das matérias
		for(int i = 0; i < materias.size(); i++) {
			//System.out.println("Materia " + i + ": " + materias.get(i).toString());
			//Adiciona ao arrayList cada professor da disciplina
			Professor p = professorDao.getProfessor(materias.get(i).getProfessor());	//Seleciona a materia e busca o professor pelo ID
			professores.add(p);	//Adiciona na lista
		}
			
		for(int i = 0; i < professores.size(); i++) {
			Professor p = professores.get(i);				
			String mat = professorDao.getProfessorMateria(p.getId()).toString();
			p.setMaterias(mat);
			System.out.println(mat);
			JSONObject professorJsonObj = new JSONObject();
			professorJsonObj.put("id",p.getId());
			professorJsonObj.put("username",p.getUsername());
			professorJsonObj.put("nome",p.getNome());
			professorJsonObj.put("email",p.getEmail());
			professorJsonObj.put("telefone",p.getTelefone());
			professorJsonObj.put("password",p.getPassword());
			professorJsonObj.put("genero",p.getGenero());
			professorJsonObj.put("dataNascimento",p.getDataNasc());
			professorJsonObj.put("cep",p.getCep());
			professorJsonObj.put("cidade",p.getCidade());
			professorJsonObj.put("estado",p.getEstado());
			professorJsonObj.put("papel",p.getPapel());
			professorJsonObj.put("experiencia",p.getExperiencia());
			professorJsonObj.put("descricao",p.getDescricao());
			professorJsonObj.put("materia",p.getMaterias());
			professoresJsonList.add(professorJsonObj);
		}
		
		professorDao.close();
		
		resultado = professoresJsonList.toJSONString();
		
		return resultado;
	}
	
	public static String login(Request request) {
		
		String email = request.params(":email");
		String senha = request.params(":senha");
		JSONArray jsonArray = new JSONArray();

		try {
			ProfessorDao professorDao = new ProfessorDao();
			professorDao.conectar();
			Professor professor = professorDao.login(email,senha);
			
			
			if(professor.getId().length() != 0) {
				JSONObject professorJsonObj = new JSONObject();
				professorJsonObj.put("id",professor.getId());
				professorJsonObj.put("username",professor.getUsername());
				professorJsonObj.put("nome",professor.getNome());
				professorJsonObj.put("email",professor.getEmail());
				professorJsonObj.put("telefone",professor.getTelefone());
				professorJsonObj.put("password",professor.getPassword());
				professorJsonObj.put("genero",professor.getGenero());
				professorJsonObj.put("dataNascimento",professor.getDataNasc());
				professorJsonObj.put("cep",professor.getCep());
				professorJsonObj.put("cidade",professor.getCidade());
				professorJsonObj.put("estado",professor.getEstado());
				professorJsonObj.put("papel",professor.getPapel());
				professorJsonObj.put("experiencia",professor.getExperiencia());
				professorJsonObj.put("descricao",professor.getDescricao());
				professorJsonObj.put("materia",professor.getMaterias());
				jsonArray.add(professorJsonObj);
			}
		} catch(Exception e){
			AlunoDao alunoDao = new AlunoDao();
			alunoDao.conectar();
			Aluno aluno = alunoDao.login(email,senha);


			if(aluno.getId().length() != 0) {
			    JSONObject alunoJsonObj = new JSONObject();
			    alunoJsonObj.put("id",aluno.getId());
			    alunoJsonObj.put("username",aluno.getUsername());
			    alunoJsonObj.put("nome",aluno.getNome());
			    alunoJsonObj.put("email",aluno.getEmail());
			    alunoJsonObj.put("telefone",aluno.getTelefone());
			    alunoJsonObj.put("password",aluno.getPassword());
			    alunoJsonObj.put("genero",aluno.getGenero());
			    alunoJsonObj.put("dataNascimento",aluno.getDataNasc());
			    alunoJsonObj.put("cep",aluno.getCep());
			    alunoJsonObj.put("cidade",aluno.getCidade());
			    alunoJsonObj.put("estado",aluno.getEstado());
			    alunoJsonObj.put("papel",aluno.getPapel());
			    alunoJsonObj.put("descricao",aluno.getDescricao());
			    
			    jsonArray.add(alunoJsonObj);
			}
		}
		return jsonArray.toJSONString();
		
	}
	
	public static String getAll() {
		AlunoDao ad = new AlunoDao();
		ProfessorDao pd = new ProfessorDao();
		
		ad.conectar();
		ad.conectar();
		
		List<Professor> professores = pd.get();
		List<Aluno> alunos = ad.get();
		
		JSONArray listTudoJSON = new JSONArray();
		
		for(int i = 0; i < professores.size(); i++) {
			Professor p = professores.get(i);
			String mat = pd.getProfessorMateria(p.getId()).toString();
			p.setMaterias(mat);
			JSONObject professorJsonObj = new JSONObject();
			professorJsonObj.put("id",p.getId());
			professorJsonObj.put("username",p.getUsername());
			professorJsonObj.put("nome",p.getNome());
			professorJsonObj.put("email",p.getEmail());
			professorJsonObj.put("telefone",p.getTelefone());
			professorJsonObj.put("password",p.getPassword());
			professorJsonObj.put("genero",p.getGenero());
			professorJsonObj.put("dataNascimento",p.getDataNasc());
			professorJsonObj.put("cep",p.getCep());
			professorJsonObj.put("cidade",p.getCidade());
			professorJsonObj.put("estado",p.getEstado());
			professorJsonObj.put("papel",p.getPapel());
			professorJsonObj.put("experiencia",p.getExperiencia());
			professorJsonObj.put("descricao",p.getDescricao());
			professorJsonObj.put("materia",p.getMaterias());
			listTudoJSON.add(professorJsonObj);
		}
		
		for(int i = 0; i < alunos.size(); i++) {
		    Aluno a = alunos.get(i);
		    JSONObject alunoJsonObj = new JSONObject();
		    alunoJsonObj.put("id",a.getId());
		    alunoJsonObj.put("username",a.getUsername());
		    alunoJsonObj.put("nome",a.getNome());
		    alunoJsonObj.put("email",a.getEmail());
		    alunoJsonObj.put("telefone",a.getTelefone());
		    alunoJsonObj.put("password",a.getPassword());
		    alunoJsonObj.put("genero",a.getGenero());
		    alunoJsonObj.put("dataNascimento",a.getDataNasc());
		    alunoJsonObj.put("cep",a.getCep());
		    alunoJsonObj.put("cidade",a.getCidade());
		    alunoJsonObj.put("estado",a.getEstado());
		    alunoJsonObj.put("papel",a.getPapel());
		    alunoJsonObj.put("descricao",a.getDescricao());
		    
		    listTudoJSON.add(alunoJsonObj);
		}
		
		return listTudoJSON.toJSONString();
	}
	
	/*-------------------*/
	
	/*Área de Professor*/
	public static boolean insertProfessor(Request request) {
		ProfessorDao pd = new ProfessorDao();
		pd.conectar();
		
		Professor professor = new Professor();
		
		professor.setId(request.params(":id"));
		professor.setUsername(request.params(":username").toLowerCase());
		professor.setNome(request.params(":nome").toLowerCase());
		professor.setEmail(request.params(":email"));
		professor.setTelefone(request.params(":telefone"));
		professor.setPassword(request.params(":password"));
		professor.setGenero(request.params(":genero"));
		professor.setDataNasc(request.params(":dataNasc"));
		professor.setCep(request.params(":cep"));
		professor.setCidade(request.params(":cidade"));
		professor.setEstado(request.params(":estado"));
		professor.setPapel(request.params(":papel"));
		professor.setExperiencia(Integer.parseInt(request.params(":experiencia")));
		professor.setMaterias(request.params(":materias").toLowerCase());
		professor.setDescricao(request.params(":descricao"));
		
		boolean resp = false;
		try {
			resp = pd.insert(professor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pd.close();
		
		return resp;
		
	}
	
	public static boolean deleteProfessor(Request request) {
		ProfessorDao pd = new ProfessorDao();
		pd.conectar();
		
		String id = request.params(":id");
		boolean resp = pd.delete(id);
		pd.close();
		
		return resp;
	}
	
	public static boolean updateProfessor(Request request) {
		ProfessorDao pd = new ProfessorDao();
		LecionaDao ld = new LecionaDao();
		pd.conectar();
		ld.conectar();
		
		Professor professor = new Professor();
		
		professor.setId(request.params(":id"));
		professor.setUsername(request.params(":username"));
		professor.setNome(request.params(":nome"));
		professor.setEmail(request.params(":email"));
		professor.setTelefone(request.params(":telefone"));
		professor.setPassword(request.params(":password"));
		professor.setGenero(request.params(":genero"));
		professor.setDataNasc(request.params(":dataNasc"));
		professor.setCep(request.params(":cep"));
		professor.setCidade(request.params(":cidade"));
		professor.setEstado(request.params(":estado"));
		professor.setPapel(request.params(":papel"));
		professor.setExperiencia(Integer.parseInt(request.params(":experiencia")));
		professor.setMaterias(request.params(":materias"));
		professor.setDescricao(request.params(":descricao"));
		System.out.println(professor.toString());
		boolean resp = pd.update(professor);
		/*Insere as materias em leciona*/
		String materias = professor.getMaterias();
        materias = materias.substring(1,materias.length()-1);
        String[] materiasVet = materias.split(",");
        for (int i = 0; i < materiasVet.length; i++) {
            materiasVet[i] = materiasVet[i].replaceAll("í", "i")
            .replaceAll("á", "a").replaceAll("à", "a")
            .replaceAll("é", "e").replaceAll("ê", "e").replaceAll(" ","");
        }

        ld.deleteByProfessor(professor.getId());
        for (int i = 0; i < materiasVet.length; i++) {
            resp &= ld.insert(new Leciona(professor.getId(),"000000000000000000000000000000000000",materiasVet[i].substring(0,5),"",0,""));
        }
		
		pd.close();
		
		return resp;
	}
	
	public static String getProfessores(){
		ProfessorDao pd = new ProfessorDao();
		pd.conectar();
		MateriaDao materiaDao = new MateriaDao();
		materiaDao.conectar();
		String resultado = new String();
		
		List<Professor> professores = pd.get();
		JSONArray professoresJson = new JSONArray();
		
		List<Materia> materias = materiaDao.get();	//Recupera uma lista das materias da busca com os professores das matérias
		for(int i = 0; i < materias.size(); i++) {
			//System.out.println("Materia " + i + ": " + materias.get(i).toString());
			//Adiciona ao arrayList cada professor da disciplina
			Professor p = pd.getProfessor(materias.get(i).getProfessor());	//Seleciona a materia e busca o professor pelo ID
			professores.add(p);	//Adiciona na lista
		}
		
		for(int i = 0; i < professores.size(); i++) {
			Professor p = professores.get(i);
			String mat = pd.getProfessorMateria(p.getId()).toString();
			p.setMaterias(mat);
			JSONObject professorJsonObj = new JSONObject();
			professorJsonObj.put("id",p.getId());
			professorJsonObj.put("username",p.getUsername());
			professorJsonObj.put("nome",p.getNome());
			professorJsonObj.put("email",p.getEmail());
			professorJsonObj.put("telefone",p.getTelefone());
			professorJsonObj.put("password",p.getPassword());
			professorJsonObj.put("genero",p.getGenero());
			professorJsonObj.put("dataNascimento",p.getDataNasc());
			professorJsonObj.put("cep",p.getCep());
			professorJsonObj.put("cidade",p.getCidade());
			professorJsonObj.put("estado",p.getEstado());
			professorJsonObj.put("papel",p.getPapel());
			professorJsonObj.put("experiencia",p.getExperiencia());
			professorJsonObj.put("descricao",p.getDescricao());
			professorJsonObj.put("materia", p.getMaterias());
			System.out.println(professorJsonObj);
			professoresJson.add(professorJsonObj);
		}
		return professoresJson.toJSONString();
	}
	
	public static String getMateria(Request request) {
		ProfessorDao pd = new ProfessorDao();
		pd.conectar();
		
		List<String> arrayMaterias = pd.getProfessorMateria(request.params(":idProfessor"));
		JSONArray arrayJsonMaterias = new JSONArray();
		
		for(int i = 0; i < arrayMaterias.size(); i++) {
			JSONObject materiaObj = new JSONObject();
			materiaObj.put("nome", arrayMaterias.get(i));
			arrayJsonMaterias.add(materiaObj);
		}
		
		return arrayJsonMaterias.toJSONString();
	}
	/*---------------------*/
	
	/*Área de Aluno*/
	public static boolean insertAluno(Request request) {
	    AlunoDao alunoDao = new AlunoDao();
	    alunoDao.conectar();
	    
	    Aluno aluno = new Aluno();
	    
	    aluno.setId();
	    aluno.setUsername(request.params(":username"));
	    aluno.setNome(request.params(":nome"));
	    aluno.setEmail(request.params(":email"));
	    aluno.setTelefone(request.params(":telefone"));
	    aluno.setPassword(request.params(":password"));
	    aluno.setGenero(request.params(":genero"));
	    aluno.setDataNasc(request.params(":dataNasc"));
	    aluno.setCep(request.params(":cep"));
	    aluno.setCidade(request.params(":cidade"));
	    aluno.setEstado(request.params(":estado"));
	    aluno.setPapel(request.params(":papel"));
	    aluno.setDescricao(request.params(":descricao"));
	    
	    boolean resp = alunoDao.insert(aluno);
	    
	    alunoDao.close();
	    
	    return resp;
	    
	}
	
	public static boolean deleteAluno(Request request) {
	    AlunoDao alunoDao = new AlunoDao();
	    alunoDao.conectar();
	    
	    String id = request.params(":id");
	    boolean resp = alunoDao.delete(id);
	    alunoDao.close();
	    
	    return resp;
	}
	
	public static boolean updateAluno(Request request) {
	    AlunoDao alunoDao = new AlunoDao();
	    alunoDao.conectar();
	    
	    Aluno aluno = new Aluno();
	    
	    aluno.setId(request.params(":id"));
	    aluno.setUsername(request.params(":username"));
	    aluno.setNome(request.params(":nome"));
	    aluno.setEmail(request.params(":email"));
	    aluno.setTelefone(request.params(":telefone"));
	    aluno.setPassword(request.params(":password"));
	    aluno.setGenero(request.params(":genero"));
	    aluno.setDataNasc(request.params(":dataNasc"));
	    aluno.setCep(request.params(":cep"));
	    aluno.setCidade(request.params(":cidade"));
	    aluno.setEstado(request.params(":estado"));
	    aluno.setPapel(request.params(":papel"));
	    aluno.setDescricao(request.params(":descricao"));
	    
	    boolean resp = alunoDao.update(aluno);
	    
	    alunoDao.close();
	    
	    return resp;
	}
	
	public static String getAlunos(){
	    AlunoDao alunoDao = new AlunoDao();
	    alunoDao.conectar();
	    
	    List<Aluno> alunos = alunoDao.get();
	    JSONArray alunosJson = new JSONArray();
	    
	    for(int i = 0; i < alunos.size(); i++) {
	        Aluno p = alunos.get(i);
	        JSONObject alunoJsonObj = new JSONObject();
	        alunoJsonObj.put("id",p.getId());
	        alunoJsonObj.put("username",p.getUsername());
	        alunoJsonObj.put("nome",p.getNome());
	        alunoJsonObj.put("email",p.getEmail());
	        alunoJsonObj.put("telefone",p.getTelefone());
	        alunoJsonObj.put("password",p.getPassword());
	        alunoJsonObj.put("genero",p.getGenero());
	        alunoJsonObj.put("dataNascimento",p.getDataNasc());
	        alunoJsonObj.put("cep",p.getCep());
	        alunoJsonObj.put("cidade",p.getCidade());
	        alunoJsonObj.put("estado",p.getEstado());
	        alunoJsonObj.put("papel",p.getPapel());
	        alunoJsonObj.put("descricao",p.getDescricao());
	        
	        alunosJson.add(alunoJsonObj);
	    }
	    
	    return alunosJson.toJSONString();
	}
	
	/*---------------------*/
	
	/*Área de Materia*/
	public static String searchMaterias(Request request) {
		MateriaDao materiaDao = new MateriaDao();
		materiaDao.conectar();
		
		String resultado = new String();

		List<Materia> materias = materiaDao.search(request.params("query"));
		System.out.println("tamanho materia: " + materias.size());
		JSONArray materiasJsonList = new JSONArray();
		
		for(int i = 0; i < materias.size(); i++) {
			Materia m = materias.get(i);
			
					
			JSONObject materiaJsonObj = new JSONObject();
			materiaJsonObj.put("sigla",m.getSigla());
			materiaJsonObj.put("nome",m.getNome());
			materiaJsonObj.put("professor",m.getProfessor());
			
			materiasJsonList.add(materiaJsonObj);
		}
		
		materiaDao.close();
		
		resultado = materiasJsonList.toJSONString();

		
		return resultado;
	}
	
	/*---------------------*/
}
