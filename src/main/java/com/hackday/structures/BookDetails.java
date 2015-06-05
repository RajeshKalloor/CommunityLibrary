package com.hackday.structures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by rajesh.kalloor on 06/06/15.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDetails {

    @JsonProperty("book_title")
    private String book_title;

    @JsonProperty("category")
    private String category;

    @JsonProperty("book_id")
    private int book_id;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("status")
    private String status;

    @JsonProperty("current_user")
    private String current_user;

//    enum Category {
//        Romance,
//        Comedy,
//        Fiction,
//        Autobiography,
//        Educational,
//        Other
//    }

}
