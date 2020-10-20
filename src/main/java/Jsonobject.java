import org.json.JSONObject;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Jsonobject {

    public static void geocoding(String username) throws Exception {
        String s = "https://api.github.com/users/";

        s += URLEncoder.encode(username, "UTF-8");
        URL url = new URL(s);


        // read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        // build a JSON object
        JSONObject obj = new JSONObject(str);

        // get the result
        System.out.println("JSONObject:");
        System.out.println("Name: "+obj.getString("name"));
        System.out.println("followers:"+obj.getInt("followers"));
        System.out.println("public_repos:"+obj.getInt("public_repos"));
    }
}