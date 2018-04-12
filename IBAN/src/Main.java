import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
public class Main {


	
	public static void failoTikrinimas(String filePath) 
	 throws IOException{
	FileReader fr = new FileReader(filePath);	
	BufferedReader br = new BufferedReader(fr)	;	
	String writeLoc	= (filePath.substring(0, filePath.length()-3)+"out");
	BufferedWriter writer = new BufferedWriter(new FileWriter(writeLoc));
String s;
	
	while ((s=br.readLine()) != null) {
	System.out.println(s);
	if(Tikrinti(s)) {
	 writer.write(s+";true");
	 writer.newLine();
	}else {writer.write(s+";false");
	writer.newLine();}
	}
	fr.close();
    writer.close();
	}
	
	
	public static boolean Tikrinti(String IBAN){
		if(verifyCountry(IBAN)) {
			String newIBAN = IBAN.substring(4)	+ IBAN.substring(0, 4) ;
			 
	        StringBuilder numericNumber = new StringBuilder();
	        for (int i = 0;i < IBAN.length();i++) {
	            numericNumber.append(Character.getNumericValue(newIBAN.charAt(i)));
	         
	}
	     
	    String number = numericNumber.toString();
	      int N = Integer.parseInt(number.substring(0,9)) % 97;
	      number = number.substring(9);
	      while (number.length()>=7) {
	    	N = Integer.parseInt(N + number.substring(0,7)) % 97;  
	    	number = number.substring(7);  
	      }
	      N = Integer.parseInt(N + number) % 97;	
			if(N==1) {return true;}
		}
		return false;
		}
	
	public static boolean verifyCountry(String IBAN){
		
		String country = IBAN.substring(0,2);
		 switch (IBAN.length()) {
		 case 15 : List<String> list15 = Stream.of("NO").collect(Collectors.toList());
		 if (list15.contains(country)) {return true;};
		 break;
		 case 16 : List<String> list16 = Stream.of("BE").collect(Collectors.toList());
		 if (list16.contains(country)) {return true;};
		 break;
		 case 18 : List<String> list18 = Stream.of("DK", "FO", "FI", "GL", "NL").collect(Collectors.toList());
		 if (list18.contains(country)) {return true;};
		 break;
		 case 19 : List<String> list19 = Stream.of("MK", "SI").collect(Collectors.toList());
		 if (list19.contains(country)) {return true;};
		 break;
		 case 20 : List<String> list20 = Stream.of("LT", "AT", "BA", "EE", "KZ", "XK", "LU").collect(Collectors.toList());
		 if (list20.contains(country)) {return true;};
		 break;
		 case 21 : List<String> list21 = Stream.of("HR", "LV", "LI", "CH").collect(Collectors.toList());
		 if (list21.contains(country)) {return true;};
		 break;
		 case 22 : List<String> list22 = Stream.of("BH", "BG", "CR", "GE", "DE", "IE", "ME", "RS", "GB").collect(Collectors.toList());
		 if (list22.contains(country)) {return true;};
		 break;
		 case 23 : List<String> list23 = Stream.of("TL", "GI", "IL", "AE").collect(Collectors.toList());
		 if (list23.contains(country)) {return true;};
		 break;
		 case 24 : List<String> list24 = Stream.of("AD", "MD", "PK", "RO", "SA", "SK", "ES", "SE", "TN", "VG").collect(Collectors.toList());
		 if (list24.contains(country)) {return true;};
		 break;
		 case 25 : List<String> list25 = Stream.of("PT").collect(Collectors.toList());
		 if (list25.contains(country)) {return true;};
		 break;
		 case 26 : List<String> list26 = Stream.of("IS", "TR").collect(Collectors.toList());
		 if (list26.contains(country)) {return true;};
		 break;
		 case 27 : List<String> list27 = Stream.of("FR", "GR", "IT", "MR", "MC", "SM").collect(Collectors.toList());
		 if (list27.contains(country)) {return true;};
		 break;
		 case 28 : List<String> list28 = Stream.of("AL", "AZ", "BY", "CY", "DO", "GT", "HU", "LB", "PL").collect(Collectors.toList());
		 if (list28.contains(country)) {return true;};
		 break;
		 case 29 : List<String> list29 = Stream.of("BR", "PS", "QA").collect(Collectors.toList());
		 if (list29.contains(country)) {return true;};
		 break;
		 case 30 : List<String> list30 = Stream.of("JO", "KW", "MU").collect(Collectors.toList());
		 if (list30.contains(country)) {return true;};
		 break;
		 case 31 : List<String> list31 = Stream.of("MA").collect(Collectors.toList());	
		 if (list31.contains(country)) {return true;};
		 break;

	}
		return false;
	 
	 
	 }
	
	
	
	
	}

