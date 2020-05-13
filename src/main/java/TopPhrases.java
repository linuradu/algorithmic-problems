import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 */
public class TopPhrases {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(String... args) {
        /*
        Defined the maximum limit number of top phases
         */
        final int defaultLimit = 100000;

        File file = new File("src/main/resources/phrases.txt");
        System.out.println("Top phrases from the file: " + new TopPhrases().getTopPhrases(file, defaultLimit));

    }

    /**
     * @param file  the given file
     * @param limit the limit of top phrases
     * @return Returns top( based on given limit) found phrases in the given file.
     */
    private Map<String, Integer> getTopPhrases(File file, int limit) {
        //Creating a map, where the key is the phrase, and the value is the number of times this phrase occurred in the file.
        Map<String, Integer> topPhrases = new LinkedHashMap<>();

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;

            //Read every line of the given file.
            while ((line = bufferedReader.readLine()) != null) {

                //Split the line to get all phrases from that line.
                String[] splitLine = line.split("\\|");

                for (String phrase : splitLine) {

                    // remove any leading and trailing whitespace
                    phrase = phrase.trim();

                    // If the phrase is already in the collection increment the value by 1.
                    // Else add the phrase as the new entry to the collection.
                    if (topPhrases.containsKey(phrase)) {
                        topPhrases.put(phrase, topPhrases.get(phrase).intValue() + 1);
                    } else {
                        topPhrases.put(phrase, 1);
                    }
                }
            }

            /**
             * Sort the collection by the value of the map entry.
             * Limit the collection to the given value (currently 100000).
             */
            topPhrases = topPhrases.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File Not found exception!", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO Exception!", e);
        }

        return topPhrases;
    }
}
