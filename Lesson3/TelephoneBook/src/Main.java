import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        TelephoneBook telephoneBook = new TelephoneBook();

        telephoneBook.add("Smelov", "45-245-67");
        telephoneBook.add("Orekhova", "45-246-83");
        telephoneBook.add("Malyshev", "57-746-97");
        telephoneBook.add("Smelov", "87-245-67");
        telephoneBook.add("Smelov", "90-215-75");

        telephoneBook.get("Smelov");
        telephoneBook.get("Malyshev");

    }
}
