package com.example.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.dto.AccountDto;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.AccountService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/axisbank")
public class AccountController {
	@Autowired
private	AccountRepository repo;
	
	@Autowired
	 AccountService accountService;
	
	//ResponceEntity is used to  return the responce
	@PostMapping("/save")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		
		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto>getAccountById(@PathVariable int id){
		AccountDto accountDto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto>deposit(@PathVariable int id,@RequestBody Map<String,Double>request){
		Double amount=request.get("amount");
		AccountDto accountDto=accountService.deposit(id,request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}
	
	

	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable int id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.withdraw(id, amount);

		return (ResponseEntity<AccountDto>) ResponseEntity.ok(accountDto);

	}
	
	
	
	@GetMapping
	public ResponseEntity<List<AccountDto>>getAll(){
		List<AccountDto> accounts=accountService.getAll();
		return ResponseEntity.ok(accounts);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("account deleted");
		
	}
			

}
