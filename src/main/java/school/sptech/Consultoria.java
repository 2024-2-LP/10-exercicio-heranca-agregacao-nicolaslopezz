package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;


public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() && desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Double getTotalSalarios() {
        double salario = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            salario += desenvolvedor.getSalario();

        }
        return salario;
    }

    public Integer qtdDesenvolvedoresMobile() {
        return (int) desenvolvedores.stream()
                .filter(d -> d instanceof DesenvolvedorMobile)
                .count();
    }
    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.getSalario() >= salario) {
                resultado.add(desenvolvedor);
            }
        }
        return resultado;
    }
    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        Desenvolvedor menorSalarioDev = desenvolvedores.get(0);
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.getSalario() < menorSalarioDev.getSalario()) {
                menorSalarioDev = dev;
            }
        }
        return menorSalarioDev;
    }

}
