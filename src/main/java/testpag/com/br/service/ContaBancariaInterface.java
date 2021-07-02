package testpag.com.br.service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Address;

import testpag.com.br.domain.dto.ContaBancariaDTODefault;
import testpag.com.br.domain.dto.ContaBancariaDTOString;
import testpag.com.br.domain.entity.ContaBancariaEntity;
import testpag.com.br.exception.ApplicationException;

public interface ContaBancariaInterface {

	List<ContaBancariaDTODefault> getAllAccount() throws ApplicationException;

	Optional<ContaBancariaDTODefault> getOneAccount(Long id) throws ApplicationException;
	
	Optional<ContaBancariaDTODefault> createAccount(ContaBancariaEntity cb) throws ApplicationException;

	Optional<ContaBancariaDTODefault> updateAccount(ContaBancariaEntity cb, Long id) throws ApplicationException;

	Optional<ContaBancariaDTODefault> deleteAcount(Long id) throws ApplicationException;
	
	List<ContaBancariaDTODefault> getListAccountFilter(String nome, String agencia, Integer cheque_especial_liberado)
			throws ApplicationException;
	
	Optional<ContaBancariaDTOString> getOneAccountFilter(String numero_conta) throws ApplicationException;

}
