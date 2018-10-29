import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] strArray = {"java", "jdbc", "sql", "hibernate", "spring", "orm", "html", "postreSQL",
        "intelliJ", "OOP", "github", "advanced", "level", "of", "sql",  "of", "english", "spring", "html", "javascript", "sql"};

        List<String> wordsList = Arrays.asList(strArray);

        ArrayList<String> wordsLinkedList = new ArrayList<>();

        for (String str: wordsList) {
            wordsLinkedList.add(str);
        }

        System.out.println("Initial list of words is " + wordsLinkedList);

        // List that will be never changed for removing repeating instances from the target list
        ArrayList<String> wordsLinkedListInit = new ArrayList<>();
        for (String str: wordsList) {
            wordsLinkedListInit.add(str);
        }

        // HashMap for writing repeating words
        HashMap<String, Integer> repeatingWordsMap = new HashMap<>();

        for (int i = 0; i < wordsLinkedListInit.size(); i++) {
            String tempWord = wordsLinkedListInit.get(i);
            Iterator <String> iteratorInner = wordsLinkedList.iterator();
            int count = 0;
            while(iteratorInner.hasNext()){
                if (iteratorInner.next().equals(tempWord)) {
                    count++;
                    if (count >= 2) {
                        iteratorInner.remove();
                        repeatingWordsMap.put(tempWord,count);
                    }
                }
            }
        }

        System.out.println("New list of words without repetitions is" + wordsLinkedList);
        System.out.println("Repetitions statistics is " + repeatingWordsMap.toString());
    }
}
