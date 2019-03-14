package upgrad.assgn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentSort {
	public static void main(String[] args) {
		System.out.println("Input file name: " + args[0]);
		File infile = new File(args[0]);
		Scanner s = null;
		int count = 0, i = 0;
		String input;
		try {
			s = new Scanner(infile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (s.hasNextLine())
			count = Integer.parseInt(s.next());
		// System.out.println("The no. of events in File are " + count);
		if (count > 0) {
			Student stu = null;
			List<Student> myList = new ArrayList<Student>();
			for (i = 0; i <= count; i++) {
				if (s.hasNext()) {
					input = s.nextLine();
					String[] in_array = input.split("\n");
					String newLine = in_array[0];
					// System.out.println("Line is " + newLine);
					String[] data = newLine.split(" ");
					String event = data[0];
					if (event.equals("ENTER")) {
						// System.out.println("Creating Student object");
						String name = data[1];
						String cgpa = data[2];
						String token = data[3];
						stu = new Student(name, Float.parseFloat(cgpa), Integer.parseInt(token));
						myList.add(stu);
					}
					if (event.equals("SERVED")) {
						Collections.sort(myList);
						// System.out.println(myList.toString());
						if (myList.size() <= 0)
							System.out.println("ERROR! List is already empty. No students to serve!");
						else {
							myList.remove(myList.size() - 1);
							// Student removedStudent = myList.remove(myList.size() - 1);
							// System.out.println("Student removed from Queue: " +
							// removedStudent.toString());
						}
					}
				}

			}

			if (myList.isEmpty())
				System.out.println("EMPTY");
			else {
				Collections.sort(myList);
				int numStudentsLeft = myList.size();
				for (int j = 0; j < numStudentsLeft; j++)
					System.out.println(myList.get(numStudentsLeft - j - 1).getName());
			}
		}
	}

}