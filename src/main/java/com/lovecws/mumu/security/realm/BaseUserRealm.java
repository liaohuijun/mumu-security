package com.lovecws.mumu.security.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 2017/11/28/028.
 */
public class BaseUserRealm extends UserRealm {
    @Override
    public AuthorizationInfo authorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    public AuthenticationInfo authenticationInfo(AuthenticationToken token) {
        return null;
    }
}
