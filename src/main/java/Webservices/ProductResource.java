package Webservices;

import Model.Product;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by nickw on 7-3-2018.
 */


//TODO Add: getProductenWithDiscount
@Path("/product")
public class ProductResource {


    @GET
//     @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response getAllProducts() {
        try {

            List<Product> productList = Resource.PRODUCT_CONTROLLER.findAll();
            JsonArray jsonArray = Resource.objectsToJsonArrayBuilder(productList).build();
            return Response.ok(jsonArray.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @GET
    @Path("{id}")
//     @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response getProductById(@PathParam("id") int id) {
        try {

            Product product = Resource.PRODUCT_CONTROLLER.findById(id);
            JsonObject jsonObject = Resource.objectToJsonObjectBuilder(product).build();
            return Response.ok(jsonObject.toString()).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

    @POST
    // @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response createProduct(
            @QueryParam("name")  String name,
            @QueryParam("price") double price,
            @QueryParam("description") String description)
    {
        try{
            Product product = new Product.ProductBuilder()
                    .name(name)
                    .description(description)
                    .price(price)
                    .build();

            Resource.PRODUCT_CONTROLLER.insert(product);

            return Response.accepted().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    // @RolesAllowed({"customer", "admin"})
    @Produces("application/json")
    public Response createProduct(
            @QueryParam("id")          int id,
            @QueryParam("name")        String name,
            @QueryParam("price")       double price,
            @QueryParam("description") String description)
    {
        try{
            Product product = Resource.PRODUCT_CONTROLLER.findById(id);

            //Update product
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);

            Resource.PRODUCT_CONTROLLER.update(product);

            return Response.accepted().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
