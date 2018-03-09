package Webservices;

import Model.Product;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by nickw on 7-3-2018.
 */


//TODO Add: getProductenWithDiscount
@Path("/product")
public class ProductResource {


    @GET
    //@RolesAllowed({"user"})
    @PermitAll
    @Produces("application/json")
    public Response getAllProducts() {
        try {

            System.out.println("Getting all products....");

            List<Product> productList = Resource.productController.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(productList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
    @RolesAllowed({"user"})
    @Produces("application/json")
    public Response getAllProductById() {
        try {

            Product product = Resource.productController.findById(1);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(product).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }


}
