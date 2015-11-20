package uk.co.manifesto.javasessions.dropwizard.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import uk.co.manifesto.javasessions.dropwizard.api.Value;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/manifesto")
@Produces(MediaType.APPLICATION_JSON)
public class ManifestoResource {
    private final String template;
    private final String defaultManifestoValue;
    private final AtomicLong counter;

    public ManifestoResource(String template, String defaultName) {
        this.template = template;
        this.defaultManifestoValue = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Value getValue(@QueryParam("value") Optional<String> value) {
        final String valueToRender = String.format(template, value.or(defaultManifestoValue));
        return new Value(counter.incrementAndGet(), valueToRender);
    }
}