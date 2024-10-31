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
        int count = 0;

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                count++;
            }
        }
        return count;
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

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();


        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedor = desenvolvedores.get(i);


            if (desenvolvedor instanceof DesenvolvedorWeb) {
                if ((((DesenvolvedorWeb) desenvolvedor).getBackend().equalsIgnoreCase(tecnologia)) ||
                        (((DesenvolvedorWeb) desenvolvedor).getFrontend().equalsIgnoreCase(tecnologia)) ||
                        (((DesenvolvedorWeb) desenvolvedor).getSgbd().equalsIgnoreCase(tecnologia))) {
                    resultado.add(desenvolvedor);
                }
            }


            if (desenvolvedor instanceof DesenvolvedorMobile) {

                if ((((DesenvolvedorMobile) desenvolvedor).getLinguagem().equalsIgnoreCase(tecnologia)) ||
                        (((DesenvolvedorMobile) desenvolvedor).getPlataforma().equalsIgnoreCase(tecnologia))) {
                    resultado.add(desenvolvedor);
                }
            }
        }
        return resultado;
    }


    public Double getTotalSalariosPorTecnologia(String tecnologia){
        double salario = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {

        }
        return salario;
    }

}
