package Webservices;

import Model.Order;

import javax.annotation.security.RolesAllowed;
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


@Path("/order")
public class OrderResource {


    @GET
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getAllOrders() {
        try {

            List<Order> orderList = Resource.orderController.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(orderList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
//    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getOrderById(@PathParam("id") int id) {
        try {

            Order order = Resource.orderController.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(order).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }


}