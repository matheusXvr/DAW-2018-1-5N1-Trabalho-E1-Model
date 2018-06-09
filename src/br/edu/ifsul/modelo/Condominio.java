package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "condominio")
public class Condominio implements Serializable {

  @Id
  @SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_unidade", strategy = GenerationType.SEQUENCE)
  private Integer id;
  @NotNull(message = "O nome não pode ser nulo")
  @NotBlank(message = "O nome não pode ser em branco")
  @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
  @Column(name = "nome", length = 40, nullable = false)
  private String nome;
  @NotNull(message = "O endereço não pode ser nulo")
  @NotBlank(message = "O endereço não pode ser em branco")
  @Length(max = 40, message = "O endereço não pode ter mais que {max} caracteres")
  @Column(name = "endereco", length = 40, nullable = false)
  private String endereco;
  @NotNull(message = "O número não pode ser nulo")
  @NotBlank(message = "O número não pode ser em branco")
  @Length(max = 12, message = "O número não pode ter mais que {max} caracteres")
  @Column(name = "numero", length = 12, nullable = false)
  private String numero;
  @NotNull(message = "O CEP deve ser informado")
  @NotBlank(message = "O CEP não pode ser em branco")
  @Length(max = 9, message = "O CEP não pode ter mais que {max} caracteres")
  @Column(name = "cep", length = 9, nullable = false)
  private String cep;
  @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<UnidadeCondominal> unidadeCondominal = new ArrayList<>();
  @ManyToMany
  @JoinTable(name = "recursos_condominio",
          joinColumns
          = @JoinColumn(name = "condominio_id", referencedColumnName = "id", nullable = false),
          inverseJoinColumns
          = @JoinColumn(name = "recursos_id", referencedColumnName = "id", nullable = false))
  private List<Recursos> recursos = new ArrayList<>();

  public Condominio() {
  }

  public void adicionarUnidadeCondominal(UnidadeCondominal obj) {
    obj.setCondominio(this);
    this.unidadeCondominal.add(obj);
  }

  public void removerUnidadeCondominal(int index) {
    this.unidadeCondominal.remove(index);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public List<UnidadeCondominal> getUnidadeCondominal() {
    return unidadeCondominal;
  }

  public void setUnidadeCondominal(List<UnidadeCondominal> unidadeCondominal) {
    this.unidadeCondominal = unidadeCondominal;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final Condominio other = (Condominio) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public List<Recursos> getRecursos() {
    return recursos;
  }

  public void setRecursos(List<Recursos> recursos) {
    this.recursos = recursos;
  }

}
