package uk.co.manifesto.javasessions.dropwizard.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class ManifestoHealthCheck extends HealthCheck {
    private final String template;

    public ManifestoHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String value = String.format(template, "TEST");
        if (!value.contains("TEST")) {
            return Result.unhealthy("value doesn't include a name");
        }
        return Result.healthy();
    }
}
