package com.hust.baseweb.service;

import java.util.List;

public interface SendMailService {
    boolean sendMail(List<String> userMail, String header, String content);
    boolean sendHtmlMail(String userMail, String header, String content);
}
