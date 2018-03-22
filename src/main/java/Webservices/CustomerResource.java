package Webservices;

import Model.Customer;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by nickw on 7-3-2018.
 */


@Path("/customer")
public class CustomerResource {


    @GET
//    @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response getAllCustomers() {
        try {

            List<Customer> customerList = Resource.CUSTOMER_CONTROLLER.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(customerList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
//    @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response getCustomerById(@PathParam("id") int id) {
        try {

            Customer customer = Resource.CUSTOMER_CONTROLLER.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(customer).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }


}