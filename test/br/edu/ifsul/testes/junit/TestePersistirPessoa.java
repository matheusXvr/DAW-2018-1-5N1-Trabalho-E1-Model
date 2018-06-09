package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Recursos;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirPessoa {

  EntityManager em;

  public TestePersistirPessoa() {
  }

  @Before
  public void setUp() {
    em = EntityManagerUtil.getEntityManager();
  }

  @After
  public void tearDown() {
    em.close();
  }

  @Test
  public void teste() {
    boolean exception = false;
    try {
      Pessoa p = new Pessoa();
      p.setNome("Julio Castro");
      p.setEmail("julio@teste.com");
      p.setTelefone("(54) 99876-1321");
      p.setCpf("169.468.880-14");
      em.getTransaction().begin();
      em.persist(p);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
}
