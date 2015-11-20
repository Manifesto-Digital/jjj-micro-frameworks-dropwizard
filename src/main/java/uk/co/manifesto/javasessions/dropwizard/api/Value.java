package uk.co.manifesto.javasessions.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Value {
    private long id;

    @Length(max = 20)
    private String content;

    public Value() {
        // Jackson deserialization
    }

    public Value(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
