/**
@author Furkan Celen
Math 118 Covid data manipulating HW1
*/

import java.io.*;  
import java.util.*;
import java.util.Scanner;  

public class covidread {
  public static void main(String[] args) {

  //String file = "covidatav3.csv";
  	// reading filename changes from below
  String rfilename = "owid-covid-data.csv",countryname="",stemp="";
  BufferedReader reader = null;
  String line = "",news="";
  int i=0,c=0,countrysize=0,totaldeath=0,totalcase=0,month=0,day=0,minm=12,mind=30,early=0;

  // created 2D arraylist for storing datas
	ArrayList<ArrayList<String>> fcols = new ArrayList<ArrayList<String>>(); 
	ArrayList<String> frows = new ArrayList<String>();
	ArrayList<String> cdeaths = new ArrayList<String>(); 
	ArrayList<String> ccases = new ArrayList<String>();
	ArrayList<String> ctests = new ArrayList<String>();
	
	// vaccines for q14-15-16 and q17
	ArrayList<String> q14 = new ArrayList<String>();
	ArrayList<String> q15 = new ArrayList<String>();
	ArrayList<String> q16 = new ArrayList<String>();
	ArrayList<String> q17 = new ArrayList<String>();
	  try {
	   reader = new BufferedReader(new FileReader(rfilename));

	   // limitlemek için && c<size koy while a
	   while((line = reader.readLine()) != null ) {
	    
	    	String[] row = line.split(",");
	    	frows = new ArrayList<String>(); 

		    for(String index : row) {
		     frows.add(index);//adding datas to frows
		    }

		    countryname=frows.get(2);
	
		    //for new country countering
		    if(!stemp.equals(countryname) && c >0){
		    	
		    		
		    	countrysize++;
		    	stemp=countryname;
		    	
		    	if(frows.size()>3){
		    		
		    		month=Integer.parseInt(frows.get(3).substring(5,7));//for getting month and day
		    		day=Integer.parseInt(frows.get(3).substring(8,10));

		    		if(month<minm && day < mind){
		    			minm=month;
		    			mind=day;
		    			early=c;	
		    		}
		    		
								    		
		    		// adding datas for some questions answers

		    		//preventing errors and blank datas with if statements
		    		if(fcols.get(c-1).size()>3 && !fcols.get(c-1).get(4).equals("")){
		    			ccases.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(4)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>6 && !fcols.get(c-1).get(7).equals("")){
		    			cdeaths.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(7)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>25 && !fcols.get(c-1).get(26).equals("")){
		    			ctests.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(26)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>36 && !fcols.get(c-1).get(37).equals("")){
		    			q14.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(37)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>35 && !fcols.get(c-1).get(36).equals("")){
		    			q15.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(36)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>33 && !fcols.get(c-1).get(34).equals("")){
		    			q16.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(34)+"\n");
		    		}
		    		if(fcols.get(c-1).size()>58 && !fcols.get(c-1).get(45).equals("")){
		    			q17.add(String.format("%-28s",fcols.get(c-1).get(2))
		    				+" :\t"+fcols.get(c-1).get(44)
		    				+" :\t"+fcols.get(c-1).get(46)
		    				+" :\t"+fcols.get(c-1).get(47)
		    				+" :\t"+fcols.get(c-1).get(48)
		    				+" :\t"+fcols.get(c-1).get(49)
		    				+" :\t"+fcols.get(c-1).get(51)
		    				+" :\t"+fcols.get(c-1).get(52)
		    				+" :\t"+fcols.get(c-1).get(53)
		    				+" :\t"+fcols.get(c-1).get(54)
		    				+" :\t"+fcols.get(c-1).get(55)
		    				+" :\t"+fcols.get(c-1).get(56)
		    				+" :\t"+fcols.get(c-1).get(57)
		    				+" :\t"+fcols.get(c-1).get(58)
		    				+"\n");
		    		}

		    	}
		    	
		    }

		    //adding readed rows to general data
		    fcols.add(frows);
		    
	   		c++;
	   }//end of while

	   				// adding datas for some questions answers for last country

		    		//preventing errors and blank datas with if statements
	   				if(fcols.get(c-1).size()>3 && !fcols.get(c-1).get(4).equals("")){
		    			ccases.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(4)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>6 && !fcols.get(c-1).get(7).equals("")){
		    			cdeaths.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(7)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>25 && !fcols.get(c-1).get(26).equals("")){
		    			ctests.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(26)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>36 && !fcols.get(c-1).get(37).equals("")){
		    			q14.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(37)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>35 && !fcols.get(c-1).get(36).equals("")){
		    			q15.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(36)+"\n");
		    		}

		    		if(fcols.get(c-1).size()>33 && !fcols.get(c-1).get(34).equals("")){
		    			q16.add(String.format("%-28s",fcols.get(c-1).get(2))+" :\t"+fcols.get(c-1).get(34)+"\n");
		    		}
		    		if(fcols.get(c-1).size()>58 && !fcols.get(c-1).get(45).equals("")){
		    			q17.add(String.format("%-28s",fcols.get(c-1).get(2))
		    				+" :\t"+fcols.get(c-1).get(44)
		    				+" :\t"+fcols.get(c-1).get(46)
		    				+" :\t"+fcols.get(c-1).get(47)
		    				+" :\t"+fcols.get(c-1).get(48)
		    				+" :\t"+fcols.get(c-1).get(49)
		    				+" :\t"+fcols.get(c-1).get(51)
		    				+" :\t"+fcols.get(c-1).get(52)
		    				+" :\t"+fcols.get(c-1).get(53)
		    				+" :\t"+fcols.get(c-1).get(54)
		    				+" :\t"+fcols.get(c-1).get(55)
		    				+" :\t"+fcols.get(c-1).get(56)
		    				+" :\t"+fcols.get(c-1).get(57)
		    				+" :\t"+fcols.get(c-1).get(58)
		    				+"\n");
		    			
		    		}
	   
	  }
	  catch(Exception e) {
	   e.printStackTrace();
	  }
	  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
	  }

	  ArrayList<ArrayList<String>> q5to13 =new ArrayList<ArrayList<String>>();

	  //q5 index 16 ,
		  q5to13.add(calculate(fcols,16,1));//reproduction

		  q5to13.add(calculate(fcols,17,1));//icu patients
		  
		  q5to13.add(calculate(fcols,19,1));//hosp patients
		  
		  q5to13.add(calculate(fcols,21,1));//weekly icu
		  
		  q5to13.add(calculate(fcols,23,1));//weekly hospital admissions
		  
		  q5to13.add(calculate(fcols,25,1));//new tests per day
		  
		  //did above part q11 with index of 26 to ctests arraylist
		  //q5to13.add(calculate(fcols,26,2));//tests are conducted

		  q5to13.add(calculate(fcols,31,1));//  positive rates of the tests

		  q5to13.add(calculate(fcols,32,1));//tests per case




	  //Results part
	  //*** for question 18 adding all datas to the list of q18
		String q18= "\nQ18:\n"+ "\nQ#1:"+countrysize
	   					+"\nQ#3:Total cases \n"+ccases
	   					+ "\nQ#4:Total deaths of \n"+cdeaths
	   					+"\nQ#5:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(0)
	   					+"\nQ#6:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(1)
	   					+"\nQ#7:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(2)
	   					+"\nQ#8:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(3)
	   					+"\nQ#9:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(4)
	   					+"\nQ#10:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(5)
	   					+"\nQ#11:Total tests conducted \n"+  ctests
	   					+"\nQ#12:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation\n" + q5to13.get(6)
	   					+"\nQ#13:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation\n" + q5to13.get(7)
	   					+"\nQ#14: Total vaccined people at least one: \n" + q14
	   					+"\nQ#15: Total vaccined full people: \n" + q15
	   					+"\nQ#16: Total vaccined administered so far: \n" + q16 +q15
	   					+"\nQ#17:\n"+q17; 

	   String results= "Q1:"+ countrysize
	   					+ "\nQ2:"+"Earliest countryname= "+fcols.get(early).get(2)+" with "+fcols.get(early).get(3)
	   					+"\nQ3:Total cases \n"+ccases
	   					+ "\nQ4:Total deaths of \n"+cdeaths
	   					+"\nQ5:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(0)
	   					+"\nQ6:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(1)
	   					+"\nQ7:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(2)
	   					+"\nQ8:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(3)
	   					+"\nQ9:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(4)
	   					+"\nQ10:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation \n" + q5to13.get(5)
	   					+"\nQ11:Total tests conducted \n"+  ctests
	   					+"\nQ12:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation\n" + q5to13.get(6)
	   					+"\nQ13:\n "+String.format("%-28s","Country")+"\t\t     min\t\t     max\t\t     average \t\t      variation\n" + q5to13.get(7)
	   					+"\nQ14: Total vaccined people at least one: \n" + q14
	   					+"\nQ15: Total vaccined full people: \n" + q15
	   					+"\nQ16: Total vaccined administered so far: \n" + q16 +q15
	   					+"\nQ17:\nCountry\t population\t median age\t # of people aged 65 older\t # of people aged 70 older"
								+"economic performance\t death rates due to heart disease\t diabetes prevalence\t # of female smokers\t "
								+"#of male smokers\t handwashing facilities\t hospital beds per thousand people\t life expectancy and human development index \n"+ q17
						+q18;		
	   
		//for outputting results to the terminal				
	   //System.out.printf("***Results:\n%s\n",results);
	   

	   try {
	      String outfilename="output.csv";
	      File myObj = new File(outfilename);
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      FileWriter fwrite = new FileWriter(outfilename);
	      fwrite.write(results);
	      fwrite.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("Error:");
	      e.printStackTrace();
	    }
	   

 }//end of the main


/**
@param fcols  our readed datas from file
@param index is column no that we want to make calculate on it
@param calctype is for q uestions (5 to 13) type 1 and (14 to 16) type 2 not used at last

*/
  public static ArrayList<String> calculate(ArrayList<ArrayList<String>> fcols,int index,int calctype){
 	//System.out.println("\n\ncalcda icte giris index:"+index+"\n\n");
 	double max=0,min=100,average=0,sum=0,variation=0,totalsum=0,now=0,c=0;

 	int lastindexcount=0,j=0;
 	ArrayList<String> values=new ArrayList<String>();
 	ArrayList<Double> currvalues=new ArrayList<Double>();
 	String stemp="",cname="",result="";
		
 		stemp=fcols.get(1).get(2);
 		//sum += max;

 		for (int i=1;i<fcols.size();i++ ) {
 			
 			if(fcols.get(i).size()>index && !fcols.get(i).get(index).equals("")&& !fcols.get(i).get(2).equals("location")){ 	
	 			
	 			double curr= Double.parseDouble(fcols.get(i).get(index));

	 			cname=fcols.get(i).get(2);

	 			if(stemp.equals(cname)){
	 				sum+=curr;
	 				currvalues.add(curr);


	 				if( Double.compare(curr,min) < 0 )
		 				min=curr;

	 				else if(Double.compare(curr,max) > 0)
	 					max=curr;

	 				lastindexcount=i;
	 				
	 				c++; //for calculating average

	 			}


	 			else{
	 				j++;
	 				
	 				if(calctype==1){		

		 				average= sum / c;
		 				
		 				// variation calculating
		 				for(double num: currvalues) {
	           				double sub=num - average;
	           				
	           				 variation += Math.pow( sub, 2);
	           				}

	        			//System.out.println("variation sqrt oncesi "+variation +" average= "+average);	
	           			variation= Math.sqrt(variation/c);	
	           			
		 				result=String.format("%-28s",fcols.get(lastindexcount).get(2))+"\t\t|"+min+"\t\t|" +max+"\t\t|"+String.format("%.4f",average) +"\t\t|"+ String.format("%.4f",variation)+" |\n";
		 				//+" "+fcols.get(lastindexcount).get(2) for with country name add it above
		 				values.add(result);
		 				max=Double.parseDouble(fcols.get(i).get(index));
		 				min=Double.parseDouble(fcols.get(i).get(index));
		 				sum=max;
		 			}
		 			
		 			else if(calctype==2 && lastindexcount!=0){
		 				
		 				now=Double.parseDouble(fcols.get(lastindexcount).get(index));
		 				totalsum+= now; 


		 			}

	 				c=0;	
	 				variation=0;sum=0;
	 				stemp=fcols.get(i).get(2);
	 			}
 		
 			}	
 		
 		}//end of the for loop

 				//for the last one we added outside
 				
 			if(calctype==1){
 				j++;
 				average= sum / fcols.size();
	 				
	 				result=fcols.get(lastindexcount).get(2)+"\t\t|"+min+"\t\t|" +max+"\t\t|"+String.format("%.4f",average) +"\t\t|"+ String.format("%.4f",variation)+" |\n";
	 				values.add(result);

	 		}
	 		
	 		else if(calctype==2){
	 			now=Double.parseDouble(fcols.get(lastindexcount).get(index));
		 			totalsum+=now;
		 				result= "Result: "+String.format("%.2f",totalsum); 
		 				values.add(result);

	 		}

 		return values;

	}//end of calculate 5-13 questions

 
}//end of the covid class


