import java.io.*;
import java.text.*;
import java.util.*;


public class StudentList {
	public static void main(String args[]) {

		BufferedReader s=null;
		String students=null;
		String student[]=null;
		
		try{
		s = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.s3))); 
		students = s.readLine();
		student= students.split(", ");
		} catch (Exception e){}
		
		//Check arguments	
		if (args.length == 0) {
			System.out.println(Constants.s4);
		}
			
		else if(args[0].equals("a")) {

			System.out.println(Constants.s1);	
		
			try {
			for(String  studentsName : student) 
				{ System.out.println(studentsName); }
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

			System.out.println(Constants.s2);				
		}
		else {
				System.out.println("Invalid Argument");
		}
	}
}