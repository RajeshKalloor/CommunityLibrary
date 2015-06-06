package com.hackday.structures;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by siba.sethy on 6/6/15.
 */
@Data
public class LoginInDetail {
    @JsonProperty("user_id")
    private String user_id;
    @JsonProperty("password")
    private String password;

}
