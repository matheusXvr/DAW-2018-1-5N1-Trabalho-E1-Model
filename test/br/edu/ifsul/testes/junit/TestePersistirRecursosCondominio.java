package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recursos;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirRecursosCondominio {

  EntityManager em;

  public TestePersistirRecursosCondominio() {
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
      Condominio c = em.find(Condominio.class, 2);
      Recursos r1 = em.find(Recursos.class, 10);
      Recursos r2 = em.find(Recursos.class, 11);
      c.getRecursos().add(r1);
      c.getRecursos().add(r2);
      em.getTransaction().begin();
      em.persist(c);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
}
