package app;

import static spark.Spark.*;
import dao.ProfessorDao;
import spark.*;
import service.Service;

public class Aplicacao {
	public static void main(String[] args){
		ProfessorDao pessoaDao = new ProfessorDao();
		
		pessoaDao.conectar();
		port(3001);
		after((Filter) (request,response) -> {
			response.header("Access-Control-Allow-Origin","*");
			response.header("Access-Control-Allow-Methods", "GET");
			response.header("Access-Control-Allow-Methods", "POST");
		});
		
		get("/",(request,response) -> Service.getAll());
		
		get("/login/:email/:senha",(request,response) -> Service.login(request));
		get("/search/:query",(request,response) -> Service.search(request));
		
		/*--------------------Área professor--------------------*/
		get("/getProfessores",(request,response) -> Service.getProfessores());
		get("/removeProfessor/:id",(request,response) -> Service.deleteProfessor(request));
		get("/insertProfessor/:id/:username/:nome/:email/:telefone/:password/:genero/:dataNasc/:cep/:cidade/:estado/:papel/:Experiencia/:descricao/:materias",
				(request,response) -> Service.insertProfessor(request));
		get("/updateProfessor/:id/:username/:nome/:email/:telefone/:password/:genero/:dataNasc/:cep/:cidade/:estado/:papel/:Experiencia/:descricao/:materias",
				(request,response) -> Service.updateProfessor(request));
		/*------------------------------------------------------*/
		
		/*--------------------Área Aluno--------------------*/
		get("/getAlunos",(request,response) -> Service.getAlunos());
		get("/removeAluno/:id",(request,response) -> Service.deleteAluno(request));
		get("/insertAluno/:id/:username/:nome/:email/:telefone/:password/:genero/:dataNasc/:cep/:cidade/:estado/:papel",
				(request,response) -> Service.insertAluno(request));
		get("/updateAluno/:id/:username/:nome/:email/:telefone/:password/:genero/:dataNasc/:cep/:cidade/:estado/:papel",
				(request,response) -> Service.updateAluno(request));
		/*------------------------------------------------------*/
		
		/*--------------------Área Materia--------------------*/
		get("/getMateria/:idProfessor",(request,response) -> Service.getMateria(request));
		get("/searchMateria/:query",(request,response) -> Service.searchMaterias(request));
		/*------------------------------------------------------*/
	}
}
