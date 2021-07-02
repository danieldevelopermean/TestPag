package testpag.com.br.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testpag.com.br.domain.dto.ContaBancariaDTODefault;
import testpag.com.br.domain.dto.ContaBancariaDTOString;
import testpag.com.br.domain.entity.ContaBancariaEntity;
import testpag.com.br.exception.ApplicationException;
import testpag.com.br.response.Response;
import testpag.com.br.service.impl.ContaBancariaService;

@RestController
@RequestMapping("/api")
public class ContaBancariaController {

	private ContaBancariaService bancariaService;

	private static final Logger log = LoggerFactory.getLogger(ContaBancariaController.class);

	@Autowired
	public ContaBancariaController(ContaBancariaService bancariaService) {
		this.bancariaService = bancariaService;
	}

	@GetMapping(value = "/account")
	public ResponseEntity<Response<List<ContaBancariaDTODefault>>> getAllAccounts() throws ApplicationException {
		log.info("Find all Account");
		Response<List<ContaBancariaDTODefault>> response = new Response<List<ContaBancariaDTODefault>>();
		try {
			List<ContaBancariaDTODefault> accountList = this.bancariaService.getAllAccount();
			if (accountList != null) {
				response.setData(accountList);
				return ResponseEntity.ok(response);
			} else {
				log.info("Account not found");
				response.getErrors().add("Account not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping(value = "/account/{id}")
	public ResponseEntity<Response<ContaBancariaDTODefault>> getOneAccount(@PathVariable("id") Long id)
			throws ApplicationException {
		log.info("Find one Account: {}", id);
		Response<ContaBancariaDTODefault> response = new Response<ContaBancariaDTODefault>();
		try {
			Optional<ContaBancariaDTODefault> account = this.bancariaService.getOneAccount(id);
			if (account.isPresent()) {
				response.setData(account.get());
				return ResponseEntity.ok(response);
			} else {
				log.info("Account not found");
				response.getErrors().add("Account not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping(value = "/account")
	public ResponseEntity<Response<ContaBancariaDTODefault>> createAccount(
			@Valid @RequestBody ContaBancariaEntity contaBancariaEntity)
			throws ApplicationException, MethodArgumentNotValidException {
		log.info("Create new Account: {}", contaBancariaEntity.toString());
		Response<ContaBancariaDTODefault> response = new Response<ContaBancariaDTODefault>();
		try {
			Optional<ContaBancariaDTODefault> accountDTO = this.bancariaService.createAccount(contaBancariaEntity);
			if (accountDTO.isPresent()) {
				response.setData(accountDTO.get());
				return ResponseEntity.ok(response);
			} else {
				log.info("Error in create Account");
				response.getErrors().add("Error in create Account");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping(value = "/account/{id}")
	public ResponseEntity<Response<ContaBancariaDTODefault>> updateAccount(
			@Valid @RequestBody ContaBancariaEntity contaBancariaEntity, @PathVariable("id") Long id)
			throws ApplicationException {
		log.info("Update Account: {}", id);
		Response<ContaBancariaDTODefault> response = new Response<ContaBancariaDTODefault>();
		try {
			Optional<ContaBancariaDTODefault> accountDTO = this.bancariaService.updateAccount(contaBancariaEntity, id);
			if (accountDTO.isPresent()) {
				response.setData(accountDTO.get());
				return ResponseEntity.ok(response);
			} else {
				log.info("Error in update Account");
				response.getErrors().add("Error in update Account");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping(value = "/account/{id}")
	public ResponseEntity<Response<ContaBancariaDTODefault>> deleteAccount(@PathVariable("id") Long id)
			throws ApplicationException {
		log.info("Delete Account: {}", id);
		Response<ContaBancariaDTODefault> response = new Response<ContaBancariaDTODefault>();
		try {
			Optional<ContaBancariaDTODefault> account = this.bancariaService.deleteAcount(id);
			if (account.isPresent()) {
				response.setData(account.get());
				return ResponseEntity.ok(response);
			} else {
				log.info("Error in delete Account");
				response.getErrors().add("Error in delete Account");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping(value = "/account/{name}/{agency}/{released_overdraft}")
	public ResponseEntity<Response<List<ContaBancariaDTODefault>>> getAllAccountsWithFilter(
			@PathVariable("name") String name, @PathVariable("agency") String agency,
			@PathVariable("released_overdraft") Integer released_overdraft) throws ApplicationException {
		log.info("Find all Account with Filter");
		Response<List<ContaBancariaDTODefault>> response = new Response<List<ContaBancariaDTODefault>>();
		try {
			List<ContaBancariaDTODefault> accountList = this.bancariaService.getListAccountFilter(name, agency,
					released_overdraft);
			if (accountList != null) {
				response.setData(accountList);
				return ResponseEntity.ok(response);
			} else {
				log.info("Account not found");
				response.getErrors().add("Account not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping(value = "/account/one/{account}")
	public ResponseEntity<Response<ContaBancariaDTOString>> getOneAccountFilter(@PathVariable("account") String account)
			throws ApplicationException {
		log.info("Find one Account: {}", account);
		Response<ContaBancariaDTOString> response = new Response<ContaBancariaDTOString>();
		try {
			Optional<ContaBancariaDTOString> accountOp = this.bancariaService.getOneAccountFilter(account);
			if (accountOp.isPresent()) {
				response.setData(accountOp.get());
				return ResponseEntity.ok(response);
			} else {
				log.info("Account not found");
				response.getErrors().add("Account not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		} catch (ApplicationException ex) {
			log.debug("Error: " + ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}


}
