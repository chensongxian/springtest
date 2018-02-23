package com.csx.springtest.example13.web;

import com.csx.springtest.example13.domain.User;
import com.csx.springtest.example13.domain.UserEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;


public class MyBindingInitializer implements WebBindingInitializer{
  public void initBinder(WebDataBinder binder, WebRequest request) {
	  binder.registerCustomEditor(User.class, new UserEditor());
   }
}
