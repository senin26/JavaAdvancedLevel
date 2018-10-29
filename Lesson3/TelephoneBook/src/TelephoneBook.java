import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelephoneBook{

    private String surname;
    private ArrayList<String> number;
    private HashMap<String,ArrayList<String>> book;

    public TelephoneBook() {
        this.book = new HashMap<String,ArrayList<String>>();
    }

    public void add(String surname, String number){

        if (this.book.containsKey(surname)) {
            ArrayList<String> arrayListNumber = this.book.get(surname);
            arrayListNumber.add(number);
            this.book.put(surname,arrayListNumber);
        }

        else {
            ArrayList<String> arrayListNumber = new ArrayList<>();
            arrayListNumber.add(number);
            this.book.put(surname, arrayListNumber);
        }
    }

    public void get(String surname){
        System.out.println("Numbers found for " + surname + ": " + this.book.get(surname));
    }
}
