package model;

public class Avalia {
	private String professor_id;
	private String aluno_id;
	private int avaliacao;
	private String comentario;
	
	/*Construtores*/
	//Construtor com todos parametros
	public Avalia(String professor_id, String aluno_id, int avaliacao, String comentario) {
		super();
		this.professor_id = professor_id;
		this.aluno_id = aluno_id;
		this.avaliacao = avaliacao;
		this.comentario = comentario;
	}
	
	//Construtor sem Parametros
	public Avalia() {
		this("professor_id", "aluno_id", 0, "comentario");
	}

	public String getProfessorId() {
		return professor_id;
	}
	
	public void setProfessorId(String professor_id) {
		this.professor_id = professor_id;
	}
	
	public String getAlunoId() {
		return aluno_id;
	}
	
	public void setAlunoId(String aluno_id) {
		this.aluno_id = aluno_id;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Professor [professor_id=" + professor_id + ", aluno_id=" + aluno_id + ", avaliacao=" + avaliacao + ", comentario="
				+ comentario + "]";
	}
	
	
}
