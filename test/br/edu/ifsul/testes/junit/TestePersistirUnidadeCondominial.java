package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominal;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirUnidadeCondominial {

  EntityManager em;

  public TestePersistirUnidadeCondominial() {
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
      UnidadeCondominal uc = new UnidadeCondominal();
      uc.setArea(50.00);
      uc.setDescricao("2º Andar");
      uc.setNumero("1550");
      uc.setNumeroQuarto(200);
      uc.setCondominio(em.find(Condominio.class, 2));
      uc.setPessoa(em.find(Pessoa.class, 5));
      em.getTransaction().begin();
      em.persist(uc);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
}
