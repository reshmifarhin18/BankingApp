package com.example.bank.mapper;

import com.example.bank.dto.AccountDto;
import com.example.bank.entity.Account;

public class AccountMapper {
	public static Account maptoaccount(AccountDto accountdto) {
		Account account=new Account(accountdto.getId(),accountdto.getAccHolderName(),accountdto.getAge(),accountdto.getBalance()) ;
		return account;
	}
	public static AccountDto maptoAccountDto(Account account) {
		AccountDto accountDto=new AccountDto(account.getId(),account.getAccHolderName(),account.getAge(),account.getBalance());
		return accountDto;
	}

}
