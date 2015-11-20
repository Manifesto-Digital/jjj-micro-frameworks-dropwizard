package uk.co.manifesto.javasessions.dropwizard.config;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ManifestoConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultManifestoValue = "Satisfy the customer";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultManifestoValue() {
        return defaultManifestoValue;
    }

    @JsonProperty
    public void setDefaultManifestoValue(String name) {
        this.defaultManifestoValue = name;
    }
}
