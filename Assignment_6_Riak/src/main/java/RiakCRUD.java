import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;

import javax.lang.model.util.SimpleTypeVisitor14;
import javax.swing.text.StyledEditorKit;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

public class RiakCRUD {

    static class Person {
        public String Name;
        public String Country;
        public int Age;
        public Boolean isStudent;


    }



    public static void main( String[] args ) {

        try{

           Person person = new Person();

           person.Age=18;
           person.Country="Turkey";
           person.isStudent=Boolean.TRUE;
           person.Name="nalan";

           String key="1";
           String bucket="s22548";
           String response="";


           /// Riak client
            RiakClient client = RiakClient.newClient(8087, "127.0.0.1");

            ///a document to the database
            response=CreateData(person, key, bucket, client);

            System.out.println(response);

            // retrieve data

            response="";

            response= RetrieveData(key, bucket, client);

            ///print retrieved data
            System.out.println(response);

            /// modify data

            person.Country="Poland";

            response=CreateData(person, key, bucket, client);

            System.out.println(response);

            /// retrieve it

            response="";

            response= RetrieveData(key, bucket, client);

            ///print retrieved data
            System.out.println(response);

            /// delete data
            deleteData(key, bucket, client);

            /// try retrieve the deleted data
            response= RetrieveData(key, bucket, client);
            System.out.println(response);

            client.shutdown();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static void deleteData(String key, String bucket, RiakClient client) throws ExecutionException, InterruptedException {
        Location location = new Location(new Namespace(bucket), key);
        DeleteValue deleteOp = new DeleteValue.Builder(location)
                .build();
        client.execute(deleteOp);

        System.out.println(location.toString()+" deleted");

    }

    private static String CreateData(Person person, String key, String bucket, RiakClient client) throws ExecutionException, InterruptedException {
        Location location = new Location(new Namespace(bucket), key);
        ///RaikStoreValue create
        StoreValue sv = new StoreValue.Builder(person).withLocation(location).build();
        /// execution
        StoreValue.Response svResponse = client.execute(sv);
        /// print response

        return svResponse.toString();
    }

    private static String RetrieveData(String key, String bucket, RiakClient client) throws ExecutionException, InterruptedException {
        /// location is the same as above bucket and key
        Location locationR = new Location(new Namespace(bucket), key);

        FetchValue fv = new FetchValue.Builder(locationR).build();

        FetchValue.Response response = client.execute(fv);
        // Fetch object as String
        return response.getValue(String.class);

    }


}
