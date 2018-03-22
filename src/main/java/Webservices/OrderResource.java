package Webservices;

import Model.*;
import Webservices.Authentication.AuthenticationFilter;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/order")
public class OrderResource {

    @GET
//    @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response getAllOrders() {
        try {

            List<Order> orderList = Resource.ORDER_CONTROLLER.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(orderList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
//     @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response getOrderById(@PathParam("id") int id) {
        try {

            Order order = Resource.ORDER_CONTROLLER.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(order).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @POST
    @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response addOrder(@Context HttpServletRequest req, InputStream is) throws IOException {
        try {

            JsonObject jsonObject = Json.createReader(is).readObject();
            Set<OrderLine> orderLines = new HashSet<>();
            // orderLines: { product_ID, amount }

            Account account = AuthenticationFilter.getAccountFromHttpServletRequest(req);
            if (account == null) {throw new Exception();}


            System.out.println("User: " + account.getEmail());

            JsonArray jsonArray = jsonObject.getJsonArray("orderLines");



            for (int i = 0; i < jsonArray.size(); i++) {

                JsonObject jsonObject1 = jsonArray.getJsonObject(i);
                Product product = Resource.PRODUCT_CONTROLLER.findById(jsonObject1.getInt("product_ID"));

                if (product == null) { continue; }

                OrderLine orderLine = new OrderLine(jsonObject1.getInt("amount"), product);
                orderLines.add(orderLine);

            }

            Order order = new Order(account,orderLines);
            Resource.ORDER_CONTROLLER.insert(order);

            return Response.status(Response.Status.ACCEPTED).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }




    }



}