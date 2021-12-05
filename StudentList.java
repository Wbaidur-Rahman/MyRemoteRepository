import java.io.*;
import java.text.*;
import java.util.*;


public class StudentList {
	public static void main(String args[]) {

		//Check arguments

		if (args.length == 0) {
			System.out.println("No Arguments.");
		}

		else if(args[0].equals("a")) {

			System.out.println("Loading data ...");	
		
			try {
			BufferedReader s = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String students = s.readLine();
			String student[] = students.split(", ");			
			for(String  studentsName : student[]) { System.out.println(studentsName); }
			} catch (Exception e){}
 
			System.out.println("Data Loaded.");
		}
                
		else if(args[0].equals("r")) {

			System.out.println("Loading data ...");
			
			try {
			BufferedReader s = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("students.txt"))); 
                        
			String students = s.readLine();
			String student[] = students.split(", ");	
			Random x = new Random();
			int index = x.nextInt(4);
        
			System.out.println(student[index]);
			} catch (Exception e){} 
                        
			System.out.println("Data Loaded.");			
		}
                
		else if(args[0].contains("+")){

			System.out.println("Loading data ...");	
		
			try {
			BufferedWriter bwr = new BufferedWriter(
					new FileWriter("students.txt", true));

			String t = args[0].substring(1);
	        	Date d = new Date();
	        	String df = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd= dateFormat.format(d);
			bwr.write(", "+t+"\nList last updated on "+fd);
			bwr.close();

			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}

		else if(args[0].contains("?")){

			System.out.println("Loading data ...");	
		
			try {
			BufferedReader s = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String students = s.readLine();
			String student[] = students.split(",");	
			boolean done = false;
			String t = args[0].substring(1);

			for(int idx = 0; idx<student.length && !done; idx++) {
				if(student[idx].equals(t)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 

			System.out.println("Data Loaded.");				
		}

		else if(args[0].contains("c")){
			System.out.println("Loading data ...");			
			try {
			BufferedReader s = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String D = s.readLine();
			char a[] = D.toCharArray();			
			boolean in_word = false;
			int count=0;

			for(char c:a) {
				if(c ==' ') {
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + a.length);
			} catch (Exception e){} 

			System.out.println("Data Loaded.");				
		}
		else {
				System.out.println("Invalid Argument");
		}
	}
}