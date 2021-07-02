package testpag.com.br.converter;

import testpag.com.br.domain.dto.ContaBancariaDTODefault;
import testpag.com.br.domain.dto.ContaBancariaDTOString;
import testpag.com.br.domain.entity.ContaBancariaEntity;
import testpag.com.br.util.CalculoUtil;
import testpag.com.br.util.ConverterToString;

public class ConverterHelper {

	public static ContaBancariaDTOString converterAccountDTOString(ContaBancariaEntity entity) {

		ContaBancariaDTOString bancariaDTO = new ContaBancariaDTOString();

		bancariaDTO.setId(entity.getId());
		bancariaDTO.setNome(entity.getNome());
		bancariaDTO.setAgencia_numero_conta(entity.getAgencia() + " / " + entity.getNumeroConta());
		bancariaDTO.setSaldo("R$ " + ConverterToString.converterDoubleString(entity.getSaldo()));
		bancariaDTO.setCheque_especial_liberado(
				ConverterToString.chequeEspecialLiberado(entity.getChequeEspecialLiberado()));
		bancariaDTO.setCheque_especial_dia_seguinte(
				"R$ " + CalculoUtil.calcularPorcentagem(entity.getCheque_especial(), entity.getTaxa()));

		return bancariaDTO;
	}

	public static ContaBancariaDTODefault converterAccountDTODefault(ContaBancariaEntity entity) {

		ContaBancariaDTODefault bancariaDTO = new ContaBancariaDTODefault();

		bancariaDTO.setId(entity.getId());
		bancariaDTO.setNome(entity.getNome());
		bancariaDTO.setNumero_conta(entity.getNumeroConta());
		bancariaDTO.setAgencia(entity.getAgencia());
		bancariaDTO.setCheque_especial_liberado(entity.getChequeEspecialLiberado());
		bancariaDTO.setSaldo(entity.getSaldo());
		bancariaDTO.setCheque_especial(entity.getCheque_especial());
		bancariaDTO.setTaxa(entity.getTaxa());

		return bancariaDTO;
	}

}
