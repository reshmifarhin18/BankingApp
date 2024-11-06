package com.example.bank.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bank.dto.AccountDto;
import com.example.bank.entity.Account;
import com.example.bank.mapper.AccountMapper;
import com.example.bank.repository.AccountRepository;

@Component
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountDto)
	{
		//convert to AccountDto to Account type
		Account account= AccountMapper.maptoaccount(accountDto);
		Account save=accountRepository.save(account);
		
		return AccountMapper.maptoAccountDto(save);
		
	}
	@Override
	public AccountDto getAccountById(int id) {
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("id not find"));
		return AccountMapper.maptoAccountDto(account);
		
	}
	@Override
	public AccountDto deposit(int id,double balance) {
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("id not exist"));
		double bal=account.getBalance();
		bal=bal+balance;
		account.setBalance(balance);
		Account saveaccount=accountRepository.save(account);
		return AccountMapper.maptoAccountDto(saveaccount);
		
		
	}
	@Override
	 public AccountDto withdraw(int id,double balance) {
		 Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("id not exist"));
		 if(account.getBalance()<balance) {
			 throw new RuntimeException();
		 }
		 double total=account.getBalance()-balance;
		 account.setBalance(total);
		 Account saveaccount=accountRepository.save(account);
		 return AccountMapper.maptoAccountDto(saveaccount);
		 
	 }
	 @Override
	 public List<AccountDto> getAll(){
		List< Account> accounts=accountRepository.findAll();
		 return (List<AccountDto>)accounts.stream().map((account)->AccountMapper.maptoAccountDto(account))
				 .collect(Collectors.toList());
		 
		 
	 }
	 
	 @Override
	 public void deleteAccount(int id) {
		 Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("id not exist"));
		 accountRepository.deleteById(id);
	 }
}
