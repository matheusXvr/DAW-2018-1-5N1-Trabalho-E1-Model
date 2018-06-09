package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "unidade_condominal")
public class UnidadeCondominal implements Serializable {

  @Id
  @SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_unidade", strategy = GenerationType.SEQUENCE)
  private Integer id;
  @NotNull(message = "O número não pode ser nulo")
  @NotBlank(message = "O número não pode ser em branco")
  @Length(max = 30, message = "O número não pode ter mais que {max} caracteres.")
  @Column(name = "numero", length = 30, nullable = false)
  private String numero;
  @NotNull(message = "A descrição não pode ser nula")
  @NotBlank(message = "A descrição não pode ser em branco")
  @Column(name = "descricao", columnDefinition = "text")
  private String descricao;
  @Min(value = 0, message = "A área não pode ser negativa")
  @NotNull(message = "A área deve ser informada")
  @Column(name = "area", nullable = false, columnDefinition = "decimal(10,2)")
  private Double area;
  @Min(value = 1, message = "O número do quarto não pode ser negativo")
  @NotNull(message = "O número do quarto deve ser informado")
  @Column(name = "numero_quarto", nullable = false)
  private Integer numeroQuarto;
  @NotNull(message = "A pessoa deve ser informada")
  @ManyToOne
  @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
  @ForeignKey(name = "fk_unidade_pessoa")
  private Pessoa pessoa;
  @NotNull(message = "O condominio deve ser informado")
  @ManyToOne
  @JoinColumn(name = "condominio_id", referencedColumnName = "id", nullable = false)
  @ForeignKey(name = "fk_unidade_condominio")
  private Condominio condominio;

  public UnidadeCondominal() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getArea() {
    return area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public Integer getNumeroQuarto() {
    return numeroQuarto;
  }

  public void setNumeroQuarto(Integer numeroQuarto) {
    this.numeroQuarto = numeroQuarto;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  @Override
  public int hashCode() {
    int hash = 3;
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
    final UnidadeCondominal other = (UnidadeCondominal) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public Condominio getCondominio() {
    return condominio;
  }

  public void setCondominio(Condominio condominio) {
    this.condominio = condominio;
  }

}
