package testpag.com.br.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testpag.com.br.domain.entity.ContaBancariaEntity;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaEntity, Long> {

	List<ContaBancariaEntity> findByNomeAndAgenciaAndChequeEspecialLiberado(String nome, String agencia,
			Integer cheque_especial_liberado);
	
	Optional<ContaBancariaEntity> findByNumeroConta(String conta);

}
