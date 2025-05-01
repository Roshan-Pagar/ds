import ReverseModule.Reverse;
import ReverseModule.ReverseHelper;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.io.*;

public class ReverseClient {
    public static void main(String args[]) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get the naming service reference
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the object reference
            String name = "Reverse";
            Reverse reverseObj = ReverseHelper.narrow(ncRef.resolve_str(name));

            // Take input from user
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter String: ");
            String str = br.readLine();

            // Call remote method
            String result = reverseObj.reverse_string(str);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
