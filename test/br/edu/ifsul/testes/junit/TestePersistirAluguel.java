package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.UnidadeCondominal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirAluguel {

  EntityManager em;

  public TestePersistirAluguel() {
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
      Aluguel a = new Aluguel();
      a.setDiaVencimento(21);
      a.setInicioContrato(Calendar.getInstance());
      Calendar fim = Calendar.getInstance();
      fim.add(Calendar.YEAR, 1);
      a.setFimContrato(fim);
      a.setValor(900.00);
      a.setLocatario(em.find(Locatario.class, 2));
      a.setUnidadeCondominal(em.find(UnidadeCondominal.class, 3));
      em.getTransaction().begin();
      em.persist(a);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
}
