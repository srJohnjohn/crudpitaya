package john.lima.crudpitaya.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "naves")
public class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String modelo;
    private String classeNave;
    private String fabricante;
    private String tamanho;
    private String capacidadedeCarga;
    private Integer velocidadeMaxima;
    @ManyToMany
    private List<Personagem> pilotos;

    public Nave() {}

    public Nave(String nome, String modelo, String classeNave, String fabricante, String tamanho, String capacidadedeCarga, Integer velocidadeMaxima, List<Personagem> pilotos) {
        this.nome = nome;
        this.modelo = modelo;
        this.classeNave = classeNave;
        this.fabricante = fabricante;
        this.tamanho = tamanho;
        this.capacidadedeCarga = capacidadedeCarga;
        this.velocidadeMaxima = velocidadeMaxima;
        this.pilotos = pilotos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getClasseNave() {
        return classeNave;
    }

    public void setClasseNave(String classeNave) {
        this.classeNave = classeNave;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCapacidadedeCarga() {
        return capacidadedeCarga;
    }

    public void setCapacidadedeCarga(String capacidadedeCarga) {
        this.capacidadedeCarga = capacidadedeCarga;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public List<Personagem> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Personagem> pilotos) {
        this.pilotos = pilotos;
    }
}
