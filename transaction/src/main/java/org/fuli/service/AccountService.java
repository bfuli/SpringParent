package org.fuli.service;


public interface AccountService {
    void transferMoney(String outAccount, String inAccount, double value);
}
