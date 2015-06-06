package com.hackday.structures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by rajesh.kalloor on 06/06/15.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {

    @JsonProperty("count")
    private int count;

    @JsonProperty("books")
    private List<BookDetails> books;
}
