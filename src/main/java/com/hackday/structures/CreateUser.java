package com.hackday.structures;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by siba.sethy on 6/6/15.
 */
public class CreateUser {
    @JsonProperty("user_id")
    private String user_id;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pincode")
    private int pincode;
    @JsonProperty("location")
    private String location;
    @JsonProperty ("address")
    private  String address;
    @JsonProperty  ("mobile_no")
    private int mobile_no;
}
