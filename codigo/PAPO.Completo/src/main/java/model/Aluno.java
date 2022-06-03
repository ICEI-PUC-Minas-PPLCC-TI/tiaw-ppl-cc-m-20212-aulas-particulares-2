package model;

import java.util.Random;
import java.util.Date;
public class Aluno {
	private String id;
	private String username;
	private String nome;
	private String email;
	private String telefone;
	private String password;
	private String genero;
	private String dataNasc;
	private String cep;
	private String cidade;
	private String estado;
	private String papel;
	private String descricao;
	
	/*Construtores*/
	//Construtor com todos parametros
	public Aluno(String id, String username, String nome, String email, String telefone, String password,
			String genero, String dataNasc, String cep, String cidade, String estado, String papel, String descricao) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
		this.genero = genero;
		this.dataNasc = dataNasc;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.papel = papel;
		this.descricao = descricao;
	}

	//Construtor com os mesmos atributos que em cadastro.html
	public Aluno(String nome, String email, String telefone, String password, String genero, String dataNasc,
			String cep, String cidade, String estado, String papel) {
		super();
		this.id = genRandomID();
		this.nome = nome;
		this.username = nome.replaceAll(" ", "") + id;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
		this.genero = genero;
		this.dataNasc = dataNasc;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.papel = papel;
	}
	
	//Construtor sem o id
	public Aluno(String username, String nome, String email, String telefone, String password,
			String genero, String dataNasc, String cep, String cidade, String estado, String papel,
			String descricao) {
		super();
		this.id = genRandomID();
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
		this.genero = genero;
		this.dataNasc = dataNasc;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.papel = papel;
		this.descricao = descricao;
	}
	
	//Construtor sem Parametros
	public Aluno() {
		this("", "username", "nome", "e-mail", "00000000000", "admin","none","1900/01/01","00000-000",
				"cidade", "estado","aluno","Lorem Ipsum");
		setId(genRandomID());
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
	
	public void setId() {
		this.id = genRandomID();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", username=" + username + ", nome=" + nome + ", email=" + email + ", telefone="
				+ telefone + ", password=" + password + ", genero=" + genero + ", dataNasc=" + dataNasc + ", cep=" + cep
				+ ", cidade=" + cidade + ", estado=" + estado + ", papel=" + papel + ", descricao=" + descricao + "]";
	}
	
	
}
