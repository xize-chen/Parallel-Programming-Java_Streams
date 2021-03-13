import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Stream;


/**
 * A class provides stream assignment implementation template
 */
public class StreamAssignment {

	
	/**
	 * @param file: a file used to create the word stream
	 * @return a stream of word strings
	 * Implementation Notes:
	 * This method reads a file and generates a word stream. 
	 * In this exercise, a word only contains English letters (i.e. a-z or A-Z), or digits, and
	 * consists of at least two characters. For example, “The”, “tHe”, or "1989" is a word, 
	 * but “89_”, “things,” (containing punctuation) are not. 
	 */ 	
	public static Stream<String> toWordStream(String file){
		return null;
	}
	
	/**
	 * @param file: a file used to create a word stream
	 * @return the number of words in the file
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) counts the number of words in the file
	 *   (3) measures the time of creating the stream and counting  
	 * 
	 */
	public static long wordCount(String file){
		return 0;
	}
	
	/**
	 * @param file: a file used to create a word stream
	 * @return a list of the unique words, sorted in a reverse alphabetical order.
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) generates a list of unique words, sorted in a reverse alphabetical order
	 * 
	 */
	public static List<String> uniqueWordList(String file){
		return null;
	}
	
	/**
	 * @param file: a file used to create a word stream
	 * @return one of the longest digit numbers in the file
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) uses Stream.reduce to find the longest digit number 
	 * 
	 */
	public static String longestDigit(String file){
		return null;
	}
	

	/**
	 * @param file: a file used to create a word stream
	 * @return the number of words consisting of three letters
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) uses only Stream.reduce (NO other stream operations) 
	 *       to count the number of words containing three letters or digits (case-insensitive).
	 *       i.e. Your code looks like: 
     *       return toWordStream(file).reduce(...); 
     *       
	 */
	public static long wordsWithThreeLettersCount(String file){
		return 0;
	}
	
	/**
	 * @param file: a file used to create a word stream
	 * @return the average length of the words (e.g. the average number of letters in a word)
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) uses only Stream.reduce (NO other stream operations) 
	 *       to calculate the total length and total number of words  
     *   (3) the average word length can be calculated separately e.g. return total_length/total_number_of_words 
	 */
	public static double avergeWordlength(String file){
	    return 0.0;
	}
	
	/**
	 * @param file: a file used to create a word stream 
	 * @return a map contains key-value pairs of a word (i.e. key) and its occurrences (i.e. value)
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) uses Stream.collect, Collectors.groupingBy, etc., to generate a map 
	 *        containing pairs of word and its occurrences.
	 */
	public static Map<String,Integer> toWordCountMap(String file){
      	return null;
	}
	
	/**
	 * @param file: a file used to create a word stream 
	 * @return a map contains key-value pairs of a number (the length of a word) as key and a set of words with that length as value. 
	 * Implementation Notes:
	 * This method 
	 *   (1) uses the toWordStream method to create a word stream from the given file
	 *   (2) uses Stream.collect, Collectors.groupingBy, etc., to generate a map containing pairs of a number (the length of a word)
	 *    and a set of words with that length
	 * 
	 */
	public static Map<Integer,Set<String>> groupWordByLength(String file){
		return null;
	}
	
	
	/**
	 * @param BiFunction that takes two parameters (String s1 and String s2) and 
	 *        returns the index of the first occurrence of s2 in s1, or -1 if s2 is not a substring of s1
	 * @param targetFile: a file used to create a line stream
	 * @param targetString:  the string to be searched in the file
	 *  Implementation Notes:
	 *  This method
	 *   (1) uses BufferReader.lines to read in lines of the target file
	 *   (2) uses Stream operation(s) and BiFuction to 
	 *       produce a new Stream that contains a stream of Object[]s with two elements;
	 *       Element 0: the index of the first occurrence of the target string in the line
	 *       Element 1: the text of the line containing the target string
	 *   (3) uses Stream operation(s) to sort the stream of Object[]s in a descending order of the index
	 *   (4) uses Stream operation(s) to print out the first 20 indexes and lines in the following format
	 *           567:<the line text>
	 *           345:<the line text>
	 *           234:<the line text>
	 *           ...  
	 */
	public static void  printLinesFound(BiFunction<String, String, Integer> pf, String targetFile, String targetString){
			
	}
	
	
	
	 public static void main(String[] args){
		  //test your methods here;
	 }

		
	
	
	
	
	
}
