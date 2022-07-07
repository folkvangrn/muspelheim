package pl.restaurant;

import javax.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

import io.swagger.jaxrs.*;
import io.swagger.jaxrs.config.BeanConfig;
import pl.restaurant.rest.ClientREST;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/restaurant")
public class RestaurantApplication extends Application {
}

