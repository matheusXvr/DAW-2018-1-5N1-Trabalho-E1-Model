package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Locatario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirLocatario {

  EntityManager em;

  public TestePersistirLocatario() {
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
      Locatario l = new Locatario();
      l.setNome("Luiza Pereira");
      l.setEmail("luiza@teste.com");
      l.setTelefone("(54) 99876-8976");
      l.setCpf("446.648.280-20");
      l.setLocalTrabalho("Stara");
      l.setTelefoneTrabalho("(54) 99988-1133");
      l.setRenda(2850.50);
      em.getTransaction().begin();
      em.persist(l);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
}
