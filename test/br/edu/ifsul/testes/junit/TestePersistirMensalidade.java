package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Mensalidades;
import br.edu.ifsul.modelo.UnidadeCondominal;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirMensalidade {

  EntityManager em;

  public TestePersistirMensalidade() {
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
      Mensalidades m = new Mensalidades();
      Calendar vencimento = Calendar.getInstance();
      vencimento.add(Calendar.MONTH, 1);
      m.setVencimento(vencimento);
      Calendar pagamento = Calendar.getInstance();
      pagamento.add(Calendar.MONTH, 1);
      pagamento.add(Calendar.DAY_OF_MONTH, 10);
      m.setDataPagamento(pagamento);
      m.setValor(900.00);
      m.setValorPagamento(900.00);
      m.setAluguel(em.find(Aluguel.class, 3));
      
      em.getTransaction().begin();
      em.persist(m);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
}
