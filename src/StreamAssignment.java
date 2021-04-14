
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A class provides stream assignment implementation template
 */
public class  StreamAssignment {


    /**
     * @param file: a file used to create the word stream
     * @return a stream of word strings
     * Implementation Notes:
     * This method reads a file and generates a word stream.
     * In this exercise, a word only contains English letters (i.e. a-z or A-Z), or digits, and
     * consists of at least two characters. For example, “The”, “tHe”, or "1989" is a word,
     * but “89_”, “things,” (containing punctuation) are not.
     */
    public static Stream<String> toWordStream(String file) throws Exception {
        Pattern splitter = Pattern.compile("[^a-zA-Z0-9]+");
        String regex = "[a-zA-Z]+\\d+.*|\\d+[a-zA-Z]+.*";
        return Files.lines(Paths.get(file))
                .parallel()
                .flatMap(splitter::splitAsStream)
                .filter(word -> word.length()>1 && !word.matches(regex) );
    }

    /**
     * @param file: a file used to create a word stream
     * @return the number of words in the file
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) counts the number of words in the file
     * (3) measures the time of creating the stream and counting
     */
    public static long wordCount(String file) throws Exception {
        long starting = System.currentTimeMillis();
        long numOfWords = toWordStream(file)
                .count();
        long ending = System.currentTimeMillis();
        System.out.println("  creating the stream and counting words took " + (ending - starting) / 1e3 + " secs.");
        return numOfWords;
    }

    /**
     * @param file: a file used to create a word stream
     * @return a list of the unique words, sorted in a reverse alphabetical order.
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) generates a list of unique words, sorted in a reverse alphabetical order
     */
    public static List<String> uniqueWordList(String file) throws Exception {
        return toWordStream(file)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * @param file: a file used to create a word stream
     * @return one of the longest digit numbers in the file
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) uses Stream.reduce to find the longest digit number
     */
    public static String longestDigit(String file) throws Exception {
        long starting = System.currentTimeMillis();
        List<String> longestDigits = toWordStream(file)
                .filter(word -> word.matches("\\d+") )
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(null);
        long ending = System.currentTimeMillis();
        System.out.println(" Find the longest digit number took " + (ending - starting) / 1e3 + " secs.");
        assert longestDigits != null;
        System.out.println("Length of longest digits list: " + longestDigits.size());
        return longestDigits.get(0);
    }


    /**
     * @param file: a file used to create a word stream
     * @return the number of words consisting of three letters
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) uses only Stream.reduce (NO other stream operations)
     * to count the number of words containing three letters or digits (case-insensitive).
     * i.e. Your code looks like:
     * return toWordStream(file).reduce(...);
     */
    public static long wordsWithThreeLettersCount(String file) throws Exception {
        return toWordStream(file)
                .parallel()
                .reduce(0,(i,str) -> i + ((str.matches(".{3}")) ? 1 : 0),
                        Integer::sum);
    }

    /**
     * @param file: a file used to create a word stream
     * @return the average length of the words (e.g. the average number of letters in a word)
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) uses only Stream.reduce (NO other stream operations)
     * to calculate the total length and total number of words
     * (3) the average word length can be calculated separately e.g. return total_length/total_number_of_words
     */
    public static double avergeWordlength(String file) throws Exception {
        long[] totals = toWordStream(file)
                .parallel()
                .reduce(new long[]{0, 0},
                        (i, str) -> {i[0] = i[0] + str.length(); i[1]++; return i;},
                        (m,n) -> {long [] cb = new long[] {m[0] + n[0], m[1] + n[1]}; System.out.println("combiner " + m[0] + " " + n[0] + " " + m[1] + " " + n[1]);
                        return cb;} );
        System.out.println(totals[0] + "/" + totals[1]);
        return (double) totals[0] / totals[1];
    }

    /**
     * @param file: a file used to create a word stream
     * @return a map contains key-value pairs of a word (i.e. key) and its occurrences (i.e. value)
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) uses Stream.collect, Collectors.groupingBy, etc., to generate a map
     * containing pairs of word and its occurrences.
     */
    public static Map<String, Integer> toWordCountMap(String file) throws Exception {
        return toWordStream(file).collect(Collectors.groupingBy(Function.identity(),
                Collectors.summingInt(i -> 1)));
    }

    /**
     * @param file: a file used to create a word stream
     * @return a map contains key-value pairs of a number (the length of a word) as key and a set of words with that length as value.
     * Implementation Notes:
     * This method
     * (1) uses the toWordStream method to create a word stream from the given file
     * (2) uses Stream.collect, Collectors.groupingBy, etc., to generate a map containing pairs of a number (the length of a word)
     * and a set of words with that length
     */
    public static Map<Integer, Set<String>> groupWordByLength(String file) throws Exception {
        return toWordStream(file)
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.toSet())
                );
    }


    /**
     * @param pf:           BiFunction that takes two parameters (String s1 and String s2) and
     *                      returns the index of the first occurrence of s2 in s1, or -1 if s2 is not a substring of s1
     * @param targetFile:   a file used to create a line stream
     * @param targetString: the string to be searched in the file
     *                      Implementation Notes:
     *                      This method
     *                      (1) uses BufferReader.lines to read in lines of the target file
     *                      (2) uses Stream operation(s) and BiFuction to
     *                      produce a new Stream that contains a stream of Object[]s with two elements;
     *                      Element 0: the index of the first occurrence of the target string in the line
     *                      Element 1: the text of the line containing the target string
     *                      (3) uses Stream operation(s) to sort the stream of Object[]s in a descending order of the index
     *                      (4) uses Stream operation(s) to print out the first 20 indexes and lines in the following format
     *                      567:<the line text>
     *                      345:<the line text>
     *                      234:<the line text>
     *                      ...
     */
    public static void printLinesFound(BiFunction<String, String, Integer> pf, String targetFile, String targetString) {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(targetFile))) {
             reader.lines()
                    .map(t -> new Object[] {pf.apply(t, targetString), t})
                    .sorted((a,b) -> Integer.compare((Integer) b[0],(Integer)a[0]))
                    .limit(20)
                    .forEach(a -> System.out.println(a[0] + ":<" + a[1] + ">"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {
        // test your methods here;
        if (args.length != 1) {
            System.out.println("Please input file path, e.g. /home/compx553/stream/wiki.xml");
            return;
        }
        String file = args[0];
        try {
            // Your code goes here and include the method calls for all 10 questions.
            //System.out.println("Number of Processors: " + Runtime.getRuntime().availableProcessors());
            //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "16");

            // Q1 and Q2
            System.out.println("Q1. How many words are in wiki.xml?");
			//System.out.printf("%,d%n", wordCount(file));
            // Q3
            System.out.println("Q3. How many unique words are in wiki.xml?" );
			//System.out.printf("%,d%n", uniqueWordList(file) != null? uniqueWordList(file).size(): 0);
            // Q4
			System.out.println("Q4. What is the longest digit number in wiki.xml?");
			//System.out.printf("%s%n", longestDigit(file));
            // Q5
			System.out.println("Q5. How many three-letter words (case-insensitive) (e.g. \"has\", \"How\", \"wHy\", \"THE\", \"123\", etc.) are in wiki.xml?");
			//System.out.printf("%,d%n", wordsWithThreeLettersCount(file));
			// Q6
			System.out.println("Q6. What is the average word length in wiki.xml?");
			System.out.printf("%.2f%n", avergeWordlength(file));
            // Q7
			System.out.println("Q7. How many times does the word \"the\" (case-sensitive) occur in wiki.xml?");
			//System.out.printf("%,d%n", toWordCountMap(file) != null? toWordCountMap(file).get("the"): 0);
			// Q8
			System.out.println("Q8. How many unique words with the length of four characters are in wiki.xml?");
			//System.out.printf("%,d%n", groupWordByLength(file) != null? groupWordByLength(file).get(4).size(): 0);

			// Q9
			System.out.println("Q9. What is the first index number when searching for the word \"science\" (case-sensitive) in wiki.xml?");
			// A Bifunction tests 'printLinesFound' method
            BiFunction<String, String, Integer> indexFunction = String::indexOf;
			// printLinesFound(indexFunction, file, "science");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


}
