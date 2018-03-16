package Webservices;

import Model.Sale;

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


@Path("/sale")
public class SaleResource {


    @GET
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getAllSales() {
        try {

            List<Sale> saleList = Resource.SALE_CONTROLLER.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(saleList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getSaleById(@PathParam("id") int id) {
        try {

            Sale sale = Resource.SALE_CONTROLLER.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(sale).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    //TODO test when data is in databases
    @GET
    @Path("/week")
    //    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getSaleByWeek() {

        try {

            List<Sale> saleList = Resource.SALE_CONTROLLER.findByThisWeek();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(saleList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }




}