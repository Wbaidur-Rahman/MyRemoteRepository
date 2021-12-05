import java.io.*;
import java.text.*;
import java.util.*;


public class StudentList {
	public static void main(String args[]) {

		//Check arguments
		BufferedReader s=null;
		
		try{
			s = new BufferedReader(
						new InputStreamReader(
							new FileInputStream(Constants.s3))); 
		        
		} catch (Exception e){}	
		String students=null;
		String student[]=null;
		
		try{
		students = s.readLine();
		student= students.split(", ");
		} catch (Exception e){}
			
		if (args.length == 0) {
			System.out.println(Constants.s4);
		}
			
		else if(args[0].equals("a")) {

			System.out.println(Constants.s1);	
		
			try {
			for(String  studentsName : student) { System.out.println(studentsName); }
			} catch (Exception e){}
 
			System.out.println(Constants.s2);
		}
                
		else if(args[0].equals("r")) {

			System.out.println(Constants.s1);
			
			try {
			Random x = new Random();
			int index = x.nextInt(4);
        
			System.out.println(student[index]);
			} catch (Exception e){} 
                        
			System.out.println(Constants.s2);			
		}
                
		else if(args[0].contains("+")){

			System.out.println(Constants.s1);	
		
			try {
			BufferedWriter bwr = new BufferedWriter(
					new FileWriter("students.txt", true));

			String t = args[0].substring(1);
	        	Date d = new Date();
	        	String df = Constants.s5;
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd= dateFormat.format(d);
			bwr.write(", "+t+"\nList last updated on "+fd);
			bwr.close();

			} catch (Exception e){}
							
			System.out.println(Constants.s2);	
		}

		else if(args[0].contains("?")){

			System.out.println(Constants.s1);	
		
			try {
			String t = args[0].substring(1);

			for(int idx = 0; idx<student.length; idx++) {
				if(student[idx].equals(t)) {
					System.out.println("We found it!");
					break;
				}
			}
			} catch (Exception e){} 

			System.out.println(Constants.s2);				
		}

		else if(args[0].contains("c")){
			System.out.println(Constants.s1);
			
			try{
				char a[] = students.toCharArray();
				int count=student.length;
				System.out.println( count+" word(s) found " + a.length);
			} catch (Exception e){} 
		
			/*try {
			String D = s.readLine();
			char a[] = D.toCharArray();			
			boolean in_word = false;
			int count=0;

			for(char c:a) {
				if(c ==' ') {
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}
					count++;			
				}
			}
			System.out.println(count +" word(s) found " + a.length);
			} catch (Exception e){} */

			System.out.println(Constants.s2);				
		}
		else {
				System.out.println("Invalid Argument");
		}
	}
}