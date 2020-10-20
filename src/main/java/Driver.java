/**
 * Read JSON from file using JsonParser
 * @author Rohith Pudari
 *
 */

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;


public class Driver {

    public static void main(String[] args) throws IOException {
        JsonFactory factory = new JsonFactory();

        // Create Reader/InputStream/File
        File file = new File("post.json");

        // Create JsonParser
        JsonParser parser = factory.createParser(file);

        parser.nextToken();
        JsonToken token; // Read first object i.e. {

        // Read JSON object
        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName())) {
            token = parser.nextToken();
            if (token == JsonToken.VALUE_STRING) {
                System.out.println("ID : " + parser.getText());
            }
        }
        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "title".equals(parser.getCurrentName())) {
            token = parser.nextToken();
            if (token == JsonToken.VALUE_STRING) {
                System.out.println("title : " + parser.getText());
            }
        }
        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "description".equals(parser.getCurrentName())) {
            token = parser.nextToken();
            if (token == JsonToken.VALUE_STRING) {
                System.out.println("description : " + parser.getText());
            }
        }

        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "content".equals(parser.getCurrentName())) {
            token = parser.nextToken();
            if (token == JsonToken.VALUE_STRING) {
                System.out.println("content : " + parser.getText());
            }
        }

        // Reading JSON Array
        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "tags".equals(parser.getCurrentName())) {

            System.out.println("Post tags are - ");
            token = parser.nextToken(); // // Read left bracket i.e. [
            // Loop to print array elements until right bracket i.e ]
            while (token != JsonToken.END_ARRAY) {
                token = parser.nextToken();

                if (token == JsonToken.VALUE_STRING) {
                    System.out.println(parser.getText());
                }
            }
            System.out.println();
        }
        parser.close();
        try {
            Jsonobject jsonobject = new Jsonobject();
            jsonobject.geocoding("1600+Amphitheatre+Parkway,\n+Mountain+View");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
