package uk.co.manifesto.javasessions.dropwizard.api;

import static org.assertj.core.api.Assertions.assertThat;
import static io.dropwizard.testing.FixtureHelpers.*;

import org.junit.Test;

import io.dropwizard.jackson.Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WineTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Wine wine = new Wine("Marlborough Ridge Sauvignon Blanc 2014", "Giesen");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/wine.json"), Wine.class));

        assertThat(MAPPER.writeValueAsString(wine)).isEqualTo(expected);
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {
        final Wine wine = new Wine("Marlborough Ridge Sauvignon Blanc 2014", "Giesen");
        assertThat(MAPPER.readValue(fixture("fixtures/wine.json"), Wine.class))
                .isEqualTo(wine);
    }
}