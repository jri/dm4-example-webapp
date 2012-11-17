package de.deepamehta.plugins.example.webapp;

import de.deepamehta.plugins.webactivator.WebActivatorPlugin;
import de.deepamehta.core.service.event.InitializePluginListener;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/example-webapp")
@Produces("text/html")
public class ExampleWebappPlugin extends WebActivatorPlugin implements InitializePluginListener {

    @GET
    public Viewable welcome() {
        context.setVariable("name", "Thymeleaf");
        return view("welcome");
    }

    // ---

    @Override
    public void initializePlugin() {
        setupRenderContext();
    }
}
