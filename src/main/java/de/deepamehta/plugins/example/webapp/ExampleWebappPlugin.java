package de.deepamehta.plugins.example.webapp;

import de.deepamehta.plugins.thymeleaf.service.ThymeleafService;
import de.deepamehta.core.osgi.PluginActivator;
import de.deepamehta.core.service.PluginService;
import de.deepamehta.core.service.event.PluginServiceArrivedListener;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.logging.Logger;



@Path("/example-webapp")
@Produces("text/html")
public class ExampleWebappPlugin extends PluginActivator implements PluginServiceArrivedListener {

    // ---------------------------------------------------------------------------------------------- Instance Variables

    private TemplateEngine templateEngine;
    private Context context = new Context();

    private Logger logger = Logger.getLogger(getClass().getName());

    // -------------------------------------------------------------------------------------------------- Public Methods

    @GET
    public String welcome() {
        context.setVariable("name", "Thymeleaf");
        return templateEngine.process("welcome", context);
    }



    // ********************************
    // *** Listener Implementations ***
    // ********************************



    @Override
    public void pluginServiceArrived(PluginService service) {
        logger.info("########## Service arrived: " + service);
        if (service instanceof ThymeleafService) {
            templateEngine = ((ThymeleafService) service).createTemplateEngine(bundle);
        }
    }
}
