package com.csx.springtest.example3.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-02-04
 */
@Controller
public class LogonController {
    @Autowired
    private LogonService logonService;
}
