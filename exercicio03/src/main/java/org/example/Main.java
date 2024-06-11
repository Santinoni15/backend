package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Atores ator1 = context.getBean(Atores.class);
        ator1.setNome("Ana");
        ator1.setNacionalidade("Brasileira");
        ator1.setNumeroDeIndicacoes((short) 0);
        ator1.setElegivel(false);

        Atores ator2 = context.getBean(Atores.class);
        ator2.setNome("Julia");
        ator2.setNacionalidade("Brasileira");
        ator2.setNumeroDeIndicacoes((short) 0);
        ator2.setElegivel(true);

        Filmes filme1 = context.getBean(Filmes.class);
        filme1.setNome("Guerra infinita");
        filme1.setGenero("ação");
        filme1.setNumeroDeIndicacoes((short) 0);
        filme1.setElegivel(true);


        OscarService oscarService = context.getBean(OscarService.class);
        oscarService.adicionarIndicacao(ator2, "");
        oscarService.adicionarIndicacao(ator2, "");
        oscarService.adicionarIndicacao(ator2, "");


        oscarService.adicionarIndicacao(filme1, "");
        oscarService.adicionarIndicacao(filme1, "");
        oscarService.adicionarIndicacao(filme1, "");

        oscarService.mostrarListaDeIndicados();
    }
}
