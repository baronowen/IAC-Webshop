package Webservices;

import Persistance.*;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by nickw on 7-3-2018.
 */
public class Resource {

    // Create a set of all Classes from package: "Model"
    private static final Reflections reflections = new Reflections("Model", new SubTypesScanner(false));
    private static final Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);

    public static final AccountController ACCOUNT_CONTROLLER = AccountController.getInstance();
    public static final AddressController ADDRESS_CONTROLLER = AddressController.getInstance();
    public static final CategoryController CATEGORY_CONTROLLER = CategoryController.getInstance();
    public static final CustomerController CUSTOMER_CONTROLLER = CustomerController.getInstance();
    public static final OrderController ORDER_CONTROLLER = OrderController.getInstance();
    public static final OrderLineController ORDER_LINE_CONTROLLER = OrderLineController.getInstance();
    public static final ProductController PRODUCT_CONTROLLER = ProductController.getInstance();
    public static final SaleController SALE_CONTROLLER = SaleController.getInstance();

    // Supports attributes: String, double, int, boolean, Collection, Date
    public static JsonObjectBuilder objectToJsonObjectBuilder(Object o) {

        // Load all fields in the class (private included)
        Field[] attributes =  o.getClass().getDeclaredFields();

        //Create JsonObjectBuilder
        JsonObjectBuilder job = Json.createObjectBuilder();

        for (Field field : attributes) {
            try {

                // Allow to read attribute value
                field.setAccessible(true);

                // if attribute has no value, don't add it
                if (field.get(o) == null) {
                    continue;
                }

                // Check if Object has another Object of the Model package
                if (allClasses.contains(field.getType())) {

                    // Add the Child Object attribute to the Parent Object and all of the Child's attributes
                    job.add(field.getName(), objectToJsonObjectBuilder(field.get(o)));

                } else {

                    //TODO make this more dynamic
                    // Cast attribute to specific type

                    try {

                        if (field.getType().equals(String.class)) {
                            job.add(field.getName(), (String) field.get(o));
                        } else if ((field.getType().equals(Integer.class) || field.getType().equals(int.class))) {
                            job.add(field.getName(), (int) field.get(o));
                        } else if ((field.getType().equals(double.class))) {
                            job.add(field.getName(), (double) field.get(o));
                        } else if ((field.getType().equals(boolean.class))) {
                            job.add(field.getName(), (boolean) field.get(o));
                        } else if ((field.get(o) instanceof Collection)) {
                            job.add(field.getName(), objectsToJsonArrayBuilder( (Collection<?>) field.get(o)));
                        } else if ((field.getType().equals(Date.class))) {
                            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                            job.add(field.getName(), df.format((Date) field.get(o)));
                        }

                        else {
                            System.out.println("ATTRIBUTE TYPE: " + field.getType() + " NOT DEFINED!");
                        }

                    } catch (Exception e) {
                        System.out.println("ATTRIBUTE TYPE: " + field.getType() + " CAUSED AN ERROR!");
                    }

                    //DEBUG
                    //System.out.println("ATTRIBUTE NAME: " + field.getName() + ", ATTRIBUTE VALUE: " + f.get(o) + ", TYPE: " + field.getType());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return job;

    }

    public static JsonArrayBuilder objectsToJsonArrayBuilder(Collection<?> objectList){

        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Object object : objectList) {
            jab.add(objectToJsonObjectBuilder(object));
        }
        return jab;

    }


}
