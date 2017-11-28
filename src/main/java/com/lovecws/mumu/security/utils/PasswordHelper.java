package com.lovecws.mumu.security.utils;

import com.lovecws.mumu.security.entity.BaseRealm;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


/**
 * @author ganliang
 * @version 2016年8月29日 上午11:18:34
 * @desc 生成密码工具类
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";

    private static String hashIteration = "2";

    private static int hashIterations = Integer.valueOf(hashIteration);

    /**
     * 加密密码
     *
     * @param realm
     */
    public static BaseRealm encryptPassword(BaseRealm realm) {
        realm.setSalt(randomNumberGenerator.nextBytes().toHex());
        String credentialsSalt = realm.getUserName() + realm.getSalt();
        String newPassword = new SimpleHash(algorithmName, realm.getPassword(),
                ByteSource.Util.bytes(credentialsSalt), hashIterations).toHex();

        realm.setPassword(newPassword);
        return realm;
    }

    /**
     * 加密密码
     *
     * @param loginPwd 明文密码
     * @param userName 用户名称
     * @param salt     密文
     * @return
     */
    public static String getPwd(String loginPwd, String userName, String salt) {
        String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(userName + salt), hashIterations)
                .toHex();
        return newPassword;
    }

    public static void main(String[] args) {
        /*BaseRealm realm=new BaseRealm();
        realm.setUserName("admin");
		realm.setPassword("123");
		encryptPassword(realm);*/
        System.out.println(getPwd("123456", "lgan", "7d0f67616088c7d89eab290a712e5ff3"));
    }

}
