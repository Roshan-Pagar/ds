import ReverseModule.ReversePOA;

public class ReverseImpl extends ReversePOA {
    ReverseImpl() {
        super();
        System.out.println("Reverse Object Created");
    }

    public String reverse_string(String name) {
        StringBuilder str = new StringBuilder(name);
        str.reverse();
        return "Server Send " + str.toString();
    }
}
