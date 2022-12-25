import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class mainapp{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //System.out.println("do you want to make another conversion");
        //System.out.println("press 1 for Yes.");
        //System.out.println("press 0 for No");
        String a="no";
        //var;
        //url="https://api.apilayer.com/exchangerates_data/convert?to=USD&from=INR&amount=140000";
       
        String exit="yes";
        while(true){

            if(exit.equalsIgnoreCase(a))
            break;
        APi_call();
        System.out.println("do you want to make another conversion");
        exit=sc.nextLine();
       

        }
    }

    public static void APi_call() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("what do you want to convert to?");

        String ConTo = input.nextLine();
        System.out.println("what do you want to convert from?");
        String ConFrom = input.nextLine();
        System.out.println("enter the amount");
      
        int amount =  input.nextInt();
        var url = "https://api.apilayer.com/exchangerates_data/convert?to=" + ConTo + "&from=" + ConFrom + "&amount="
                + amount;
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url))
                .header("apikey", "EHMuqKYmp2QGX4JB5Fn72TmiHP1Pw4p0").build();

        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo= (JSONObject)obj;
          double result= (double) jo.get("result");
        System.out.println(result+" "+ConTo);
    }
}
