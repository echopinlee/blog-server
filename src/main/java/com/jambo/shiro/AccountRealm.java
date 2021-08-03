package com.jambo.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.jambo.entity.User;
import com.jambo.service.UserService;
import com.jambo.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;

/**
 * 登錄處理
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  {

        JwtToken jwtToken = (JwtToken) token;

        //getPrincipal返回token信息，可獲取到userId ，爲String類型
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");//
        }

        if (user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定");
        }
        //封裝一個類保證數據的私密性，有些密碼什麼的不需要公開
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        //用戶信息返回給shiro
        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
