package com.example.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bank.dto.AccountDto;
@Service
public interface AccountService {
	 AccountDto createAccount(AccountDto accountDto);
	 AccountDto getAccountById(int id);
	 AccountDto deposit(int id,double balance);
	 AccountDto withdraw(int id,double balance);
	 List<AccountDto> getAll();
	 void deleteAccount(int id);
	 
}
