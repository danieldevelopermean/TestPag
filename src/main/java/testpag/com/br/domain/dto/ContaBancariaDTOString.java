package testpag.com.br.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaBancariaDTOString {

	private long id;

	private String nome;

	private String agencia_numero_conta;

	private String saldo;

	private String cheque_especial_liberado;

	private String cheque_especial_dia_seguinte;

}
