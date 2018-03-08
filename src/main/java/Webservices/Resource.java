package Webservices;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * Created by nickw on 7-3-2018.
 */
public class Resource {

    // Create a set of all Classes from package: "Model"
    private static final Reflections reflections = new Reflections("Model", new SubTypesScanner(false));
    private static final Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);

    // Supports attributes: String, double, int, boolean, List
    public static JsonObjectBuilder objectToJsonObjectBuilder(Object o) {

        //Convert the Object to a Class object
        Class<?> c = o.getClass();

        // Load all fields in the class (private included)
        Field[] attributes =  o.getClass().getDeclaredFields();
        Field f;

        //Create JsonObjectBuilder
        JsonObjectBuilder job = Json.createObjectBuilder();

        for (Field field : attributes) {
            try {
                // Dynamically read Attribute Name
                f = c.getDeclaredField(field.getName());

                // Allow to read attribute value
                f.setAccessible(true);

                // if attribute has no value, don't add it
                if (f.get(o) == null) {
                    continue;
                }

                // Check if Object has another Object of the Model package
                if (allClasses.contains(field.getType())) {

                    // if true add the Object attribute to the Object
                    job.add(field.getName(), objectToJsonObjectBuilder(f.get(o)));

                } else {

                    //TODO make this more dynamic
                    // Cast attribute to specific type

                    try {

                        if (field.getType().equals(String.class)) {
                            job.add(field.getName(), (String) f.get(o));
                        } else if ((field.getType().equals(Integer.class) || field.getType().equals(int.class))) {
                            job.add(field.getName(), (int) f.get(o));
                        } else if ((field.getType().equals(double.class))) {
                            job.add(field.getName(), (double) f.get(o));
                        } else if ((field.getType().equals(boolean.class))) {
                            job.add(field.getName(), (boolean) f.get(o));
                        } else if ((field.getType().equals(List.class))) {
                            job.add(field.getName(), objectsToJsonArrayBuilder( (List<?>) f.get(o)));
                        } else {
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

    public static JsonArrayBuilder objectsToJsonArrayBuilder(List<?> objectList){

        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Object object : objectList) {
            jab.add(objectToJsonObjectBuilder(object));
        }
        return jab;

    }


}
