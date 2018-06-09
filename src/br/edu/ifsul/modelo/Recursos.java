package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "recursos")
public class Recursos implements Serializable {

  @Id
  @SequenceGenerator(name = "seq_recursos", sequenceName = "seq_pessoa_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_recursos", strategy = GenerationType.SEQUENCE)
  private Integer id;
  @NotNull(message = "A descrição não pode ser nula")
  @NotBlank(message = "A descrição não pode ser em branco")
  @Column(name = "descricao", columnDefinition = "text", nullable = false)
  private String descricao;

  public Recursos() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Recursos other = (Recursos) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

}
