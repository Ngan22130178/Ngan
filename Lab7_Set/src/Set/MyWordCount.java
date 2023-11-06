package Set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> re= new ArrayList<>();
		for (String w : words) {
			WordCount wc= new WordCount(w, count(w) );
			if (re.contains(wc)) {
				re.add(wc);
			}
		}
		return re;
	}

	int count(String w) {
		int count=0;
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i)== ' ') {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> re= new HashSet<>();
		List<WordCount> list= getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount()==1) {
				re.add(wc.getWord());
			}
		}
		return re;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		return new HashSet<>(words);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> re= new HashSet<>();
		
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> re= new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount w1, WordCount w2) {
				//return w1.getWord().compareTo(w2.getWord());
				return -(w1.getCount())- w2.getCount();
			}
		});
		re.addAll(getWordCounts());
		return re;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> re= new HashSet<>();
		for (String w : words) {
			if (!w.startsWith(pattern)) {
				re.add(w);
			}
		}
		return re;
	}
}
