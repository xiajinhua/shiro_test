package com.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void test(){

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        Realm realm =new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin","123");
        subject.login(token);


        System.out.println(subject.isAuthenticated());

        boolean hasRole = subject.hasRole("admin");
        System.out.println(hasRole);

        boolean permitted = subject.isPermitted("product:view");
        System.out.println(permitted);
    }
}
