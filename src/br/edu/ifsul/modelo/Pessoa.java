package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

  @Id
  @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
  private Integer id;
  @NotNull(message = "O nome não pode ser nulo")
  @NotBlank(message = "O nome não pode ser em branco")
  @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres.")
  @Column(name = "nome", length = 40, nullable = false)
  private String nome;
  @NotNull(message = "O CPF não pode ser nulo")
  @NotBlank(message = "O CPF não pode ser em branco")
  @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
  @Column(name = "cpf", length = 14, nullable = false, unique = true)
  @CPF(message = "O CPF informado não é válido")
  private String cpf;
  @NotNull(message = "O telefone não pode ser nulo")
  @NotBlank(message = "O telefone não pode ser em branco")
  @Length(max = 15, message = "O telefone não pode ter mais que {max} caracteres")
  @Column(name = "telefone", length = 15, nullable = false)
  private String telefone;
  @NotNull(message = "O email não pode ser nulo")
  @NotBlank(message = "O email não pode ser em branco")
  @Length(max = 40, message = "O email não pode ter mais que {max} caracteres")
  @Column(name = "email", length = 40, nullable = false)
  @Email(message = "O email deve ser informado")
  private String email;

  public Pessoa() {
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.id);
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
    final Pessoa other = (Pessoa) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
  
}
