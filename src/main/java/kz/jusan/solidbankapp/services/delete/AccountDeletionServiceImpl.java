package kz.jusan.solidbankapp.services.delete;

import kz.jusan.solidbankapp.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountDeletionServiceImpl implements AccountDeletionService {
    AccountDAO accountDAO;

    @Autowired
    public AccountDeletionServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public String deleteAccount(int accountID) {
        if (accountDAO.findAccountById(accountID) != null) {
            accountDAO.deleteById(accountID);
            return "Account was deleted";
        }
        return "Account was not found";
    }
}