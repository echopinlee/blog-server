package com.jambo.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * jwtFilter需要獲取Token,需要生成token,登錄完成之後，
 * token是放在handler中的，用戶訪問接口時需要去hanlder中取
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
