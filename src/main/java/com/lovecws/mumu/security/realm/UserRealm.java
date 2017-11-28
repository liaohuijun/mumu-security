package com.lovecws.mumu.security.realm;

import com.lovecws.mumu.core.utils.StringUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author ganliang
 * @version 2016年8月29日 上午11:11:00
 * @desc 自定义realm
 */
public abstract class UserRealm extends AuthorizingRealm {

    public UserRealm() {
        super();
    }

    public UserRealm(CacheManager cacheManager) {
        super(cacheManager);
    }

    /**
     * 获取当前用户的角色集合,权限集合
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return authorizationInfo(principals);
    }

    public abstract AuthorizationInfo authorizationInfo(PrincipalCollection principals);

    public abstract AuthenticationInfo authenticationInfo(AuthenticationToken token);

    /**
     * 校验登录用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName = (String) token.getPrincipal();
        if (StringUtil.isEmpty(loginName)) {
            throw new UnknownAccountException();// 没找到帐号
        }
        //从数据库获取用户信息
        return authenticationInfo(token);
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }
}
