package john.lima.crudpitaya.model;

import javax.persistence.*;

@Entity
@Table(name = "personagens")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Integer altura;
    private Integer peso;
    private String sexo;
    private String anoDeNacimento;
    @ManyToOne
    private Especie especie;

    public Personagem() {

    }

    public Personagem(long id, String nome, Integer altura, Integer peso, String sexo, String anoDeNacimento, Especie especie) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.anoDeNacimento = anoDeNacimento;
        this.especie = especie;
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAltura() { return altura; }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAnoDeNacimento() {
        return anoDeNacimento;
    }

    public void setAnoDeNacimento(String anoDeNacimento) {
        this.anoDeNacimento = anoDeNacimento;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
