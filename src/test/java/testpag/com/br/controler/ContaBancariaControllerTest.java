package testpag.com.br.controler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import testpag.com.br.controller.ContaBancariaController;
import testpag.com.br.domain.dto.ContaBancariaDTODefault;
import testpag.com.br.domain.entity.ContaBancariaEntity;
import testpag.com.br.exception.ApplicationException;
import testpag.com.br.service.impl.ContaBancariaService;

@SpringBootTest
public class ContaBancariaControllerTest {

	private ContaBancariaController contaBancariaController;

	@Mock
	private ContaBancariaService contaBancariaService;

	@BeforeEach
	public void before() {
		this.contaBancariaController = new ContaBancariaController(this.contaBancariaService);
	}

	@Test
	public void getAllAccountTest() throws ApplicationException, MethodArgumentNotValidException {
		ResponseEntity response = createAccountRequest(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		ResponseEntity responseEntity = getAllAccountRequest();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	private ResponseEntity createAccountRequest(Long id) throws ApplicationException, MethodArgumentNotValidException {
		ContaBancariaEntity params = new ContaBancariaEntity();
		final AtomicReference<ContaBancariaEntity> atomicAgeParams = new AtomicReference<>();
		Mockito.doAnswer(invocationOnMock -> {
			final ContaBancariaEntity argument = invocationOnMock.getArgument(0);
			atomicAgeParams.set(argument);
			Optional<ContaBancariaDTODefault> result = Optional.of(new ContaBancariaDTODefault());
			result.get().setId(id);
			return result;
		}).when(this.contaBancariaService).createAccount(Mockito.eq(params));

		return this.contaBancariaController.createAccount(params);
	}

	@Test
	private ResponseEntity getAllAccountRequest() throws EntityNotFoundException, ApplicationException {
		Mockito.doAnswer(invocationOnMock -> {
			return new ArrayList<>();
		}).when(this.contaBancariaService).getAllAccount();

		return this.contaBancariaController.getAllAccounts();
	}

}
