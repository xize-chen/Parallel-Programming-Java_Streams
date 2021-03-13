# Assignment Four Java Streams (5%)

## Due date Friday 1st May at 11:30 pm


# Instructions

*  Fork the project by clicking the "Fork" button on the top-right corner.
*  **Make sure that the visibility of your new repository (the one you just forked) is set to private.**
*  You can obtain the URL of your forked project by clicking the "Clone" button (beside "Fork") and then the “copy to clipboard icon" at the right of the dropdown.
*  Clone the new repository to your computer and import the project into Eclipse. These can be done through the Git command line interface or using the Git plugin installed in Eclipse.
*  Using the Git command line interface: You will need to install a Git client yourself if you are not using the lab machines. In a termial on your computer, clone the assignment one repository to your computer using the command “git clone ”.
   Import the java_streams project into your Eclipse workspace. (File / Import / General / Existing Projects into Workspace / Select root directory / Finish).
*  Using Git inside Eclipse: there are many tutorials on the Web. Here is one https://eclipsesource.com/blogs/tutorials/egit-tutorial

Commit your changes regularly, providing an informative commit message. You are expected to make at least 20 commits with messages to explain what have changed. 10 out of 60 marks are allocated for this.

## Your tasks
The goal of this assignment is to learn how to write Java lambda expressions and use Stream operations. You will implement eight empty methods provided in StreamAssignment.java and answer 10 questions. Please read the implementation specifications at the beginning of each method carefully and try to use lambda expressions (or method references), and stream operations wherever possible and appropriate.
Marks are given based on the correctness of answers, and proper use of lambda expressions (or method references) and stream operations.

The wikipedia file used is on the Moodle or at 
```
/home/compx553/stream/wiki.xml
```
and can be accessed on any Linux machines in R-block

In this assignment, we define a word that only contains English letters (i.e. a-z or A-Z), or digits, and consists of at least two characters. For example, "The, "tHe", or "1989" is a word, and "89_", and "things," (containing punctuation) are not.

```
>#1 and #2 Implement toWordStream and wordCount method. (Hint: use BufferedReader.lines to read lines from a file)
>Q1. How many words are in wiki.xml?
>write your answer here 
>Q2. How much speed up do you get by running the word stream parallel (e.g. 1.5X, 2X, 3X, etc.)?
>write your answer here 
```
```
>#3 Implement uniqueWordList method.
>Q3. How many unique words are in wiki.xml?
>write your answer here
```
```
>#4 Implement longestDigit method. 
>Q4. What is the longest digit number in wiki.xml?
>write your answer here
```

```
>#5 Implement wordsWithThreeLettersCount method. 
>Q5. How many three-letter words (case-insensitive) (e.g. "has", "How", "wHy", "THE", "123", etc.) are in wiki.xml?
>write your answer here
```
```
>#6 Implement avergeWordlength method.
>Q6. What is the average word length in wiki.xml?
>write your answer here
```
```
>#7 Implement toWordCountMap method.
>Q7. How many times does the word "the" (case-sensitive) occour in wiki.xml?
>write your answer here
```

```
>#8 Implement groupWordByLength method.
>Q8. How many unique words with the length of four characters are in wiki.xml?
>write your answer here
```

```
>#9 Implement printLinesFound method and a BiFunction to test printLinesFound method.
>Q9. What is the first index number when searching for the word "science" (case-sensitive) in wiki.xml?
>write your answer here
```

```
>Q10. Does printLinesFound method run faster (at least 1.5X speedup) by paralleling the line stream, why or why not (Hint: you could test it using a larger file by making multiple copies of wiki_1.xml and concatenating them together)? Do the sorted results differ after using parallel stream, why? What stream operation can be added (showing it in the code) to achieve the same sorted results while still using parallel line stream?
>write your answer here
```

## Submission Checklist
* Make sure you have pushed all changes to the repository. Ensure that you can see your changes on GitLab before submission.
* Make sure you have answered ten questions above in this page.

## Grading (60 marks) 

|Marks|Allocated to|
|-----|-------|
|10|At least twenty informative Commit comments |
|10| Ten questions (1 mark each) |
|32 |#1 to #8 implementation (4 marks each). Marks are given based on the proper use of lambda expressions (or method references) and stream operations. |
|8 |#9 implementation. Marks are given based on the proper use of lambda expressions (or method references) and stream operations|

