package Webservices;

/**
 * Created by nickw on 9-3-2018.
 */
import Model.Address;

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


@Path("/address")
public class AddressResource {


    @GET
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getAllAddresses() {
        try {

            List<Address> addressList = Resource.ADDRESS_DAO.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(addressList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getAccountById(@PathParam("id") int id) {
        try {

            Address address = Resource.ADDRESS_DAO.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(address).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }


}
