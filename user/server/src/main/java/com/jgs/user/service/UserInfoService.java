package com.imooc.user.service;

import com.imooc.user.dataobject.UserInfo;

public interface UserInfoService {
    UserInfo findByOpenid(String openid);
}
