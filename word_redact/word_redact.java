import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*  @author Anonymous (do not change)
        *
        *  Question 6:
        *
        *  Implement in Java a similar algorithm to that in Q5, i.e. given a
        *  block of text your algorithm should be able to redact words from
        *  a given set and outputs the result to a file called â€œresult.txtâ€�.
        *  However, in this implementation of the algorithm all
        *  redactable words will be proper nouns (i.e. a name used for an
        *  individual person, place, or organisation, spelled with an initial
        *  capital letter) and your algorithm should take into account that
        *  the list of redactable words might not be complete. For example,
        *  given the block of text:
        *      It was in July, 1805, and the speaker was the well-known Anna
        *      Pavlovna Scherer, maid of honor and favorite of the Empress
        *      Marya Fedorovna. With these words she greeted Prince Vasili
        *      Kuragin, a man of high rank and importance, who was the first
        *      to arrive at her reception. Anna Pavlovna had had a cough for
        *      some days. She was, as she said, suffering from la grippe;
        *      grippe being then a new word in St. Petersburg, used only by
        *      the elite.
        *
        *  and the redactable set of words
        *      Anna Pavlovna Scherer, St. Petersburg, Marya Fedorovna
        *
        *  the output text should be
        *      It was in ****, 1805, and the speaker was the well-known ****
        *      ******** *******, maid of honor and favorite of the *******
        *      ***** *********. With these words she greeted ****** ******
        *      *******, a man of high rank and importance, who was the first
        *      to arrive at her reception. **** ******** had had a cough for
        *      some days. She was, as she said, suffering from la grippe;
        *      grippe being then a new word in *** **********, used only by
        *      the elite.
        *
        *  You should test your program using the example files provided.
        */

public class CWK2Q6 {

	public static void redactWords(String textFilename, String redactWordsFilename) throws IOException {

	
		BufferedReader text = new BufferedReader(new FileReader(textFilename));
		BufferedReader redact = new BufferedReader(new FileReader(redactWordsFilename));
		String line;

		// read the redact words file and add them to an array
		ArrayList<String> redactWords = new ArrayList<>();
		while ((line = redact.readLine()) != null) {
			redactWords.add(line);
		}

		// create strings from the files using string builder
		StringBuilder sb = new StringBuilder();
		String lineText = text.readLine();

		while (lineText != null) {
			sb.append(lineText);
			sb.append(System.lineSeparator());
			lineText = text.readLine();
		}
		String everything = sb.toString();

		// cycle through each word to redact
		for (String wordToRedact : redactWords) {
			// matches the phrase and returns match will tell me the start index and end index of the desired phrase to redact
			Pattern word = Pattern.compile(wordToRedact);
			Matcher match = word.matcher(everything);
			while (match.find()) {
				for (int i = match.start(); i < match.end(); i++) {
					// place stars at the designated boundary in the buffer but leave gaps between mulit phrase lines
					if (!(Character.isWhitespace(sb.charAt(i)))) {
						sb.setCharAt(i, '*');
					}
				}
			}
		}

		// regex to locate words that begin with capital letters , dubbed as nouns
		String regEx = "\\b[A-Z].*?\\b";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(sb.toString());
		while (matcher.find()) {
			if (matcher.start() - 1 >= 0) {
				// if their is a space before the capital letter, the program assumes its a Noun and therfore sets that out with a star.
				if ( Character.isWhitespace(sb.charAt(matcher.start() - 1)) && (int) sb.charAt(matcher.start() -2) != 46 && !Character.isWhitespace(sb.charAt(matcher.start() - 2))) {
					for (int i = matcher.start(); i < matcher.end(); i++) {
						if (!(Character.isWhitespace(sb.charAt(i)))) {
							sb.setCharAt(i, '*');
						}
					}
				}
			}
		}
		System.out.println(System.getProperty("file.encoding"));
		System.setProperty("file.encoding", "UTF-8");
		FileWriter resultFile = new FileWriter("result.txt");
		resultFile.write(sb.toString());
		resultFile.close();
		text.close();
	}

	public static void main(String[] args) throws IOException {
		String inputFile = "./warandpeace.txt";
		String redactFile = "./redact.txt";
		redactWords(inputFile, redactFile);
	}

}
