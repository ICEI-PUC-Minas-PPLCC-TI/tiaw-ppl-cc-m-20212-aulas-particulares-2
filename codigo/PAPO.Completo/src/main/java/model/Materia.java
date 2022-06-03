package model;

public class Materia {
	private String sigla;
	private String nome;
	private String professor;
	/*Construtores*/
	//Construtor com todos parametros
	public Materia(String sigla, String nome){
		super();
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public Materia(String sigla, String nome,String professor){
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.professor= professor; 
	}
	
	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	//Construtor sem a sigla
	public Materia(String nome) {
		super();
		this.nome = nome;
	}
	
	//Construtor sem Parametros
	public Materia() {
		this("sigla", "nome","professor");
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Materia [sigla=" + sigla + ", nome=" + nome + "]";
	}
}
