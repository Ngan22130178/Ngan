package Set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Even p= new Even();
		
		List<Integer> list1= new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(4);
		
		
		//MyPredicates.remove(list, p);
		//System.out.println(list);
		//MyPredicates.retain(list, p);
		//System.out.println(list);
		System.out.println(MyPredicates.collect(list, p));
		System.out.println(list);
		System.out.println(MyPredicates.find(list, p));
		System.out.println(MyPredicates.find(list1, p));
		
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("data/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			System.out.println(word);
			
		
		
		}
	}
}