package Model;
import Control.*;
import View.*;

public class Main {
    public static void main(String[] args)  throws Exception { 

        Control.bdd_to_hashmap();

        new Login();

    }
}