package fourLettersInCommon;



	import java.util.*;
	import java.io.*;

	public class fourLettersInCommon{
	  //Initialise variables and arrays



	  public ArrayList<String> result = new ArrayList<String>();
	  public ArrayList<String> four = new ArrayList<String>();
	  public String fourStr = "";

	  //Creating instance method
	  public fourLettersInCommon(String word, ArrayList<String> dict){
		  
	    splitWord(word);
	    comp(dict);
	    
	    System.out.println(result);
	    System.out.println(result.size());
	  }
	  //method to split word into groups of four
	  public void splitWord(String source){

	    for(int i=0; i< source.length()-3;i++){
	      for(int j=i; j<i+4;j++){
	        fourStr += Character.toString(source.charAt(j));
	        System.out.println(fourStr);
	      }
	      four.add(fourStr);
	      fourStr="";
	    }
	  
	  }
	  

	  public ArrayList<String> comp(ArrayList<String> dictionary){

	    for(String s: four){
	      for(String d: dictionary){
	        if(d.toLowerCase().contains(s.toLowerCase())){
	          result.add(d);
	        }
	      }
	    }
	    Collections.sort(result, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareToIgnoreCase(s2);
	        }
	    });
	  
	    return result;
	  }


	  public static void main(String[] args){

	      Scanner sc = new Scanner(System.in);
	      String word;
	      String fileName;
	      String line = null;
	      ArrayList<String> dict = new ArrayList<String>();

	      System.out.println("Please enter a word: ");
	      word = sc.nextLine();

	      System.out.println("Please enter the path to a dictionary array: ");
	      fileName = sc.nextLine();
	      
	      try{
	    	  
	    	  FileReader fileReader = new FileReader(fileName);
	    	  BufferedReader bufferReader = new BufferedReader(fileReader);
	    	  
	    	  while((line = bufferReader.readLine()) != null){
	    		  
	    		  dict.add(line);
	    	  }
	      }catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file '" + 
	                    fileName + "'");                
	            }
	            catch(IOException ex) {
	                System.out.println(
	                    "Error reading file '" 
	                    + fileName + "'");                  
	               
	            }

	      fourLettersInCommon TheTest = new fourLettersInCommon(word, dict);
	  }
	}



