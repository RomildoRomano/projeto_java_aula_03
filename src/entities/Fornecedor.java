package entities;

import java.util.UUID;

public class Fornecedor {
	
	private UUID id;
	private String nome;
	private String cnpj;
	
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
