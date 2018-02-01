package com.csx.springtest.example1.service;

import com.csx.springtest.example1.dao.LoginLogDao;
import com.csx.springtest.example1.dao.UserDao;
import com.csx.springtest.example1.domain.LoginLog;
import com.csx.springtest.example1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/31
 */
@Service
public class UserService {
    private DataSourceTransactionManager transactionManager;
    private UserDao userDao;
    private LoginLogDao loginLogDao;




    public boolean hasMatchUser(String userName, String password) {
        int matchCount =userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {
        DefaultTransactionDefinition transactionDefinition=new DefaultTransactionDefinition();
        transactionDefinition.setName("loginTx");
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

        try {
            user.setCredits( 5 + user.getCredits());
            LoginLog loginLog = new LoginLog();
            loginLog.setUserId(user.getUserId());
            loginLog.setIp(user.getLastIp());
            loginLog.setLoginDate(user.getLastVisit());
            userDao.updateLoginInfo(user);
            loginLogDao.insertLoginLog(loginLog);
        }catch (Exception e){
            transactionManager.rollback(status);
            throw e;
        }
    }

    @Autowired
    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }


}
