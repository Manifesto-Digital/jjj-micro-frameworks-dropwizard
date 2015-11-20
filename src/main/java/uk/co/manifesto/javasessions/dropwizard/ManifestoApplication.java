package uk.co.manifesto.javasessions.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.co.manifesto.javasessions.dropwizard.config.ManifestoConfiguration;
import uk.co.manifesto.javasessions.dropwizard.healthcheck.ManifestoHealthCheck;
import uk.co.manifesto.javasessions.dropwizard.resource.ManifestoResource;
import uk.co.manifesto.javasessions.dropwizard.resource.WineResource;

public class ManifestoApplication extends Application<ManifestoConfiguration> {
    public static void main(String[] args) throws Exception {
        new ManifestoApplication().run(args);
    }

    @Override
    public String getName() {
        return "manifesto";
    }

    @Override
    public void initialize(Bootstrap<ManifestoConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(ManifestoConfiguration configuration, Environment environment) {
        final ManifestoResource resource = new ManifestoResource(
                configuration.getTemplate(),
                configuration.getDefaultManifestoValue()
            );
  
        final WineResource wineResource = new WineResource();
        
        final ManifestoHealthCheck healthCheck = new ManifestoHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(wineResource);
    }

}