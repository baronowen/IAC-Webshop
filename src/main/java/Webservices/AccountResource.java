package Webservices;

import Model.Account;

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


@Path("/account")
public class AccountResource {


    @GET
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getAllAccounts() {
        try {

            List<Account> accountList = Resource.ACCOUNT_DAO.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(accountList).build();
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

            Account account = Resource.ACCOUNT_DAO.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(account).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }


}
