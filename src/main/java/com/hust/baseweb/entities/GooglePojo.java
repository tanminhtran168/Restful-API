package com.hust.baseweb.entities;

import lombok.Data;

@Data
public class GooglePojo {

    private String id;
    private String email;
    private String verifiedEmail;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;
    private String locale;
}
