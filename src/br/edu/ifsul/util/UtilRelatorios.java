package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominal;
import java.util.ArrayList;
import java.util.List;

public class UtilRelatorios {

  public static List<Condominio> carregaCondominios() {
    List<Condominio> lista = new ArrayList<>();
    Pessoa p = new Pessoa();
    p.setId(1);
    p.setNome("Matheus Xavier");
    p.setCpf("000.111.222-77");
    p.setTelefone("(54) 99617-1919");
    p.setEmail("matheusxavier@hotmail.com");

    UnidadeCondominal uc = new UnidadeCondominal();
    uc.setId(1);
    uc.setNumero("101");
    uc.setDescricao("1º Andar");
    uc.setNumeroQuarto(3);
    uc.setArea(70.00);
    uc.setPessoa(p);

    Condominio c = new Condominio();
    c.setId(1);
    c.setNome("Condominio Boulevard");
    c.setEndereco("Av. Pátria");
    c.setNumero("1150");
    c.setCep("99500-000");
    c.adicionarUnidadeCondominal(uc);
    
    lista.add(c);
    return lista;

  }
}
