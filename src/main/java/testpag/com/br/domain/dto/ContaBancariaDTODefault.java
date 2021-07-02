package testpag.com.br.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaBancariaDTODefault {

	private Long id;

	private String nome;

	private String numero_conta;

	private String agencia;

	private Integer cheque_especial_liberado;

	private Double saldo;

	private Double cheque_especial;

	private Double taxa;

}
