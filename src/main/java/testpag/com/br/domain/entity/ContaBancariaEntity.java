package testpag.com.br.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ContaBancaria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaBancariaEntity {

	private static final long serialVersionUID = 3001782215680858821L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	@NotBlank(message = "Mandatory nome")
	private String nome;

	@Column(name = "numeroConta")
	@NotBlank(message = "Mandatory numeroConta")
	private String numeroConta;

	@Column(name = "agencia")
	@NotBlank(message = "Mandatory agencia")
	private String agencia;

	@Column(name = "chequeEspecialLiberado")
	@NotNull
	private Integer chequeEspecialLiberado;

	@Column(name = "saldo")
	@NotNull
	private Double saldo;

	@Column(name = "cheque_especial")
	@NotNull
	private Double cheque_especial;

	@Column(name = "taxa")
	@NotNull
	private Double taxa;

}
