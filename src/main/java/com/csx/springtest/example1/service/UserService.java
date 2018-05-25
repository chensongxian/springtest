package com.csx.springtest.example1.service;

import com.csx.springtest.example1.dao.LoginLogDao;
import com.csx.springtest.example1.dao.UserDao;
import com.csx.springtest.example1.dbrouter.DBContextHolder;
import com.csx.springtest.example1.domain.LoginLog;
import com.csx.springtest.example1.domain.User;
import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
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
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;




    public boolean hasMatchUser(String userName, String password) {
        int matchCount =userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        DBContextHolder.setCustomerID(1000L);
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

    public  void testDbRouter(){
        userDao.findUserByUserName("xxxxx");
    }

}
