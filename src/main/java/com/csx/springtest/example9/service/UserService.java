package com.csx.springtest.example9.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void addCredits(){}
}
