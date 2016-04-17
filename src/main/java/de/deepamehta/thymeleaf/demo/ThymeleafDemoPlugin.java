package de.deepamehta.thymeleaf.demo;

import de.deepamehta.thymeleaf.ThymeleafPlugin;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/thymeleaf-demo")
@Produces("text/html")
public class ThymeleafDemoPlugin extends ThymeleafPlugin {

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
