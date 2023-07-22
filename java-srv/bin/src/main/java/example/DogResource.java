package example;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Path("dogs")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class DogResource {

    private static final Logger LOGGER = Logger.getLogger(DogResource.class.getName());

    @Inject
    EntityManager entityManager;

    @GET
    public List<Dog> get() {
        return entityManager.createNamedQuery("Dog.findAll", Dog.class)
                .getResultList();
    }
}