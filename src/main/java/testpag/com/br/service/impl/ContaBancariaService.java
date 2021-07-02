package testpag.com.br.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testpag.com.br.converter.ConverterHelper;
import testpag.com.br.domain.dto.ContaBancariaDTODefault;
import testpag.com.br.domain.dto.ContaBancariaDTOString;
import testpag.com.br.domain.entity.ContaBancariaEntity;
import testpag.com.br.exception.ApplicationException;
import testpag.com.br.repository.ContaBancariaRepository;
import testpag.com.br.service.ContaBancariaInterface;

@Service
public class ContaBancariaService implements ContaBancariaInterface {

	@Autowired
	private ContaBancariaRepository accountRepository;

	@Override
	public List<ContaBancariaDTODefault> getAllAccount() throws ApplicationException {
		return accountRepository.findAll().stream().map(ConverterHelper::converterAccountDTODefault)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ContaBancariaDTODefault> getOneAccount(Long id) throws ApplicationException {
		return accountRepository.findById(id).map(ConverterHelper::converterAccountDTODefault);
	}

	@Override
	public Optional<ContaBancariaDTODefault> createAccount(ContaBancariaEntity cb) throws ApplicationException {
		ContaBancariaEntity bancariaEntity = accountRepository.save(cb);
		return Optional.ofNullable(ConverterHelper.converterAccountDTODefault(bancariaEntity));
	}

	@Override
	public Optional<ContaBancariaDTODefault> updateAccount(ContaBancariaEntity cb, Long id)
			throws ApplicationException {
		Optional<ContaBancariaEntity> contOptional = accountRepository.findById(id);
		if (contOptional.isPresent()) {
			cb = accountRepository.save(cb);
			return Optional.ofNullable(ConverterHelper.converterAccountDTODefault(cb));
		} else {
			return Optional.empty();
		}

	}

	@Override
	public Optional<ContaBancariaDTODefault> deleteAcount(Long id) throws ApplicationException {
		Optional<ContaBancariaEntity> contOptional = accountRepository.findById(id);
		if (contOptional.isPresent()) {
			accountRepository.deleteById(id);
			return Optional.ofNullable(ConverterHelper.converterAccountDTODefault(contOptional.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public List<ContaBancariaDTODefault> getListAccountFilter(String nome, String agencia,
			Integer cheque_especial_liberado) throws ApplicationException {
		return accountRepository.findByNomeAndAgenciaAndChequeEspecialLiberado(nome, agencia, cheque_especial_liberado)
				.stream().map(ConverterHelper::converterAccountDTODefault).collect(Collectors.toList());
	}

	@Override
	public Optional<ContaBancariaDTOString> getOneAccountFilter(String numero_conta) throws ApplicationException {
		return accountRepository.findByNumeroConta(numero_conta).map(ConverterHelper::converterAccountDTOString);
	}

}
