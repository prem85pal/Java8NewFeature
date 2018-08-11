package java8;


public class SplitFunction {

    public static void main(String args[]) {

        String Str = new String("1-522-521-");


        for (String retval : Str.split("-")) {
            System.out.println(retval);
        }
    }
}


