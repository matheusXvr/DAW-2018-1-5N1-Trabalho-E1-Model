package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "locatario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Locatario extends Pessoa implements Serializable {

  @Min(value = 0, message = "A renda não pode ser negativa")
  @NotNull(message = "A renda deve ser informada")
  @Column(name = "renda", nullable = false, columnDefinition = "decimal(10,2)")
  private Double renda;
  @NotNull(message = "O local de trabalho não pode ser nulo")
  @NotBlank(message = "O local de trabalho não pode ser em branco")
  @Length(max = 35, message = "O local de trabalho não pode ter mais que {max} caracteres")
  @Column(name = "local_trabalho", length = 35, nullable = false)
  private String localTrabalho;
  @NotNull(message = "O telefone de trabalho não pode ser nulo")
  @NotBlank(message = "O telefone de trabalho não pode ser em branco")
  @Length(max = 15, message = "O telefone de trabalho não pode ter mais que {max} caracteres")
  @Column(name = "telefone_trabalho", length = 15, nullable = false)
  private String telefoneTrabalho;
  

  public Locatario() {
  }

  public Double getRenda() {
    return renda;
  }

  public void setRenda(Double renda) {
    this.renda = renda;
  }

  public String getLocalTrabalho() {
    return localTrabalho;
  }

  public void setLocalTrabalho(String localTrabalho) {
    this.localTrabalho = localTrabalho;
  }

  public String getTelefoneTrabalho() {
    return telefoneTrabalho;
  }

  public void setTelefoneTrabalho(String telefoneTrabalho) {
    this.telefoneTrabalho = telefoneTrabalho;
  }

}
