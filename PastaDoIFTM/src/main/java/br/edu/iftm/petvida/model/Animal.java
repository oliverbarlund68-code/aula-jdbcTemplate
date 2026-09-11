public package br.edu.iftm.petvida.model;

public class Animal {
    private int idAnimal;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private int idTutor;

    public Animal() {}

    public Animal(int idAnimal, String nome, String especie, String raca, int idade, int idTutor) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.idTutor = idTutor;
    }

    public int getIdAnimal() { return idAnimal; }
    public void setIdAnimal(int idAnimal) { this.idAnimal = idAnimal; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public int getIdTutor() { return idTutor; }
    public void setIdTutor(int idTutor) { this.idTutor = idTutor; }
} Animal {
    
}
