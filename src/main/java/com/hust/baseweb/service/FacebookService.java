package com.hust.baseweb.service;

import com.hust.baseweb.entities.data.User;
import com.hust.baseweb.repo.UserRepository;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class FacebookService implements SocialService{

    @Autowired
    private UserRepository userRepository;

    @Value("${facebook.appId}")
    private String appId;
    @Value("${facebook.appSecret}")
    private String appSecret;
    @Value("${facebook.redirect}")
    private String redirect;
    @Value("${facebook.scope}")
    private String scope;

    @Override
    public String createAuthorizationURL() {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(appId, appSecret);
        OAuth2Operations oAuth2Operations = connectionFactory.getOAuthOperations();
        OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
        oAuth2Parameters.setRedirectUri(redirect);
        oAuth2Parameters.setScope(scope);
        return oAuth2Operations.buildAuthorizeUrl(oAuth2Parameters);
    }

    @Override
    public String createAccessToken(String code) throws Exception {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(appId, appSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, redirect, null);
        return accessGrant.getAccessToken();
    }

    @Override
    public User getUser(String token) throws Exception {
        FacebookClient client = new DefaultFacebookClient(Version.VERSION_3_0).createClientWithAccessToken(token);
        JsonObject json = client.fetchObject("me", JsonObject.class, Parameter.with("fields", "id, email, first_name, last_name"));
        String userId = json.getString("id", "");
        User user = userRepository.findByUsernameAndDeletedFalse(userId);
        if (user != null) return user;
        User newUser = User.builder()
                .username(convertUTF8(json.getString("first_name", "") + ".183802"))
                .name(convertUTF8(json.getString("first_name", "")))
                .deleted(false)
                .build();
        return userRepository.save(newUser);
    }

    private String convertUTF8(String src) {
        return new String(src.getBytes(), StandardCharsets.UTF_8);
    }
}
