package com.lovecws.mumu.security.credentials;

public interface LoginCredentialsHandler {

    /**
     * 登陆之前的业务逻辑处理
     */
    public void before();

    /**
     * 登陆之后的业务逻辑处理
     */
    public void after();
}
