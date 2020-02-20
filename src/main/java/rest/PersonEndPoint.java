package rest;

import domain.Person;
import repository.PersonRepository;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/persons")
public class PersonEndPoint {

    @Inject
    private PersonRepository personRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person, @Context UriInfo uriInfo) {
        return Response.ok(personRepository.create(person)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {

        List<Person> persons = personRepository.findAll();
        if (persons.size() == 0)
            return Response.noContent().build();
        return Response.ok(persons).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id} : \\d+")
    public Response getPerson(Long id) {
        Person person = personRepository.find(id);

        if (person == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(person).build();
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deletePerson(@PathParam("id") @Min(1) Long id) {
        personRepository.delete(id);
        return Response.noContent().build();
    }
}
