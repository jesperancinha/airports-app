package com.jesperancinha.service.containers;

import com.jesperancinha.service.pojos.Runway;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 08-08-16.
 */
public class RunwayContainerTest {
    @Test
    public void getRunways() throws Exception {
        final RunwayContainer runwayContainer = new RunwayContainer();

        List<Runway> runways = runwayContainer.getRunways();
        Runway runway = runways.get(0);

        assertThat(runways, hasSize(39537));
        assertThat(runway.getId(), notNullValue());
    }
}