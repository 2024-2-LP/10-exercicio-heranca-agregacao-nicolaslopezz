package school.sptech;

import java.util.Collection;

public class Desenvolvedor {
    protected String nome;
    protected Integer qtdHoras;
    protected Double valorHora;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Desenvolvedor() {
    }

    public Double calcularSalario(){
        return valorHora * qtdHoras;
    }

    public double getSalario() {
        return calcularSalario();
    }


}
