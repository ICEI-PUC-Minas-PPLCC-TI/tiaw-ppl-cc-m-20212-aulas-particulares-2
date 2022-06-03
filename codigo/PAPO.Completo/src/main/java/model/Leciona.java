package model;

import java.util.Random;
import java.math.BigInteger;
import java.util.Date;
public class Leciona {
	private String id;
	private String professor_id;
	private String aluno_id;
	private String materia_sigla;
	private String descricao;
	private double valor;
	private String horario;
	
	/*Construtores*/
	//Construtor com todos parametros
	public Leciona(String id, String professor_id, String aluno_id, String materia_sigla, String descricao, double valor,
			String horario) {
		super();
		this.id = id;
		this.professor_id = professor_id;
		this.aluno_id = aluno_id;
		this.materia_sigla = materia_sigla;
		this.descricao = descricao;
		this.valor = valor;
		this.horario = horario;
	}
	
	//Construtor sem o id
	public Leciona(String professor_id, String aluno_id, String materia_sigla, String descricao, double valor,
			String horario) {
		super();
		this.professor_id = professor_id;
		this.aluno_id = aluno_id;
		this.materia_sigla = materia_sigla;
		this.descricao = descricao;
		this.valor = valor;
		this.horario = horario;
		String id = genRandomID();
        String bigNum = new String();
        for (int i = 0; i < id.length(); i++) {
            bigNum += (int)id.charAt(i)/10;
        }
		setId(bigNum.substring(0,9));
	}
	
	//Construtor sem Parametros
	public Leciona() {
		this("", "professor_id", "aluno_id", "materia_sigla", "descricao", 0.0,"horario");
		String id = genRandomID();
        String bigNum = new String();
        for (int i = 0; i < id.length(); i++) {
            bigNum += (int)id.charAt(i)/10;
        }
		setId(bigNum.substring(0,9));
	}
	
	public String genRandomID() {
		Random gen = new Random();
		String id = new String();
		String alphanumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-";
		for(int i = 0; i < 36;i++) {
			gen.setSeed(new Date().getTime() * gen.nextInt());
			int num = gen.nextInt() % 64;
			num = ((num < 0) ? num * -1 : num);
			id += alphanumber.charAt(num);
		}
		return id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public String getMateriaSigla() {
		return materia_sigla;
	}
	
	public void setMateriaSigla(String materia_sigla) {
		this.materia_sigla = materia_sigla;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", professor_id=" + professor_id + ", aluno_id=" + aluno_id + ", materia_sigla=" + materia_sigla + ", descricao="
				+ descricao + ", valor=" + valor + ", horario=" + horario + "]";
	}
	
	
}
