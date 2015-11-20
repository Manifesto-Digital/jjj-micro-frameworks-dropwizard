package uk.co.manifesto.javasessions.dropwizard;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;

import org.junit.Before;
import org.junit.Test;

import com.codahale.metrics.health.HealthCheckRegistry;

import uk.co.manifesto.javasessions.dropwizard.config.ManifestoConfiguration;
import uk.co.manifesto.javasessions.dropwizard.resource.WineResource;

public class ManifestoApplicationTest {
    private final Environment environment = mock(Environment.class);
    private final JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private final HealthCheckRegistry healthChecks = mock(HealthCheckRegistry.class);
    private final ManifestoApplication application = new ManifestoApplication();
    private final ManifestoConfiguration config = new ManifestoConfiguration();

    @Before
    public void setup() throws Exception {
        config.setTemplate("template %s");;
        when(environment.jersey()).thenReturn(jersey);
        when(environment.healthChecks()).thenReturn(healthChecks);
    }

    @Test
    public void buildsAWineResource() throws Exception {
        application.run(config, environment);
        verify(jersey).register(isA(WineResource.class));
    }
}
