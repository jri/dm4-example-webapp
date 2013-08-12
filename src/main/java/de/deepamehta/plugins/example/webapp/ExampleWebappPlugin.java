package de.deepamehta.plugins.example.webapp;

import de.deepamehta.plugins.webactivator.WebActivatorPlugin;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/example-webapp")
@Produces("text/html")
public class ExampleWebappPlugin extends WebActivatorPlugin {

    @Override
    public void init() {
        initTemplateEngine();
    }

    @GET
    public Viewable welcome() {
        viewData("engine", "Thymeleaf");
        return view("welcome");
    }
}
