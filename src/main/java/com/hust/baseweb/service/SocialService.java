package com.hust.baseweb.service;

import com.hust.baseweb.entities.data.User;

public interface SocialService {

    String createAuthorizationURL();

    String createAccessToken(String code) throws Exception;

    User getUser(String token) throws Exception;
}
