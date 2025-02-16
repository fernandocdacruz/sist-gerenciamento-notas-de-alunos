package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private int id;
	private String nome;
	
	private List<Nota> notas = new ArrayList<>();
	
	public Aluno() {
	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarNota(Nota nota) {
		notas.add(nota);
	}

	@Override
	public String toString() {
		return "ID: " + id + " - Nome: " + nome;
	}
	
	public double calcularMedia() {
	    return notas.stream()
	                .mapToDouble(Nota::getNota)
	                .average()
	                .orElse(0.0); 
	}
	
	public String mediaFinal() {
		return "ID: " + id + " - Nome: " + nome + " - Média Final: " + String.format("%.2f", calcularMedia());
	}

	
}
