package org.fuli.service;

import org.fuli.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void transferMoney(String outAccount, String inAccount, double value) {
        accountMapper.decreMoney(outAccount, value);
        int i = 1/0;
        accountMapper.increMoney(inAccount, value);
    }
}
