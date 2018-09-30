package form16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestProg {

	public static void main(String[] args) {
	      
		String line="This website is aw3som31.";
		int vowel=0,cons=0, digit=0, space=0;
		 line=line.toLowerCase();
		for(int j=0;j<line.length();j++){
			
			char ch=line.charAt(j);
			
			if( ch=='a'|| ch=='e' || ch=='i' || ch=='o'|| ch=='u'){
					
				vowel++;
			}
			else if( ch>='a'&& ch<='z'){
				
				cons++;
			
			}
			else if(ch==' ' || ch=='.'){
				
				space++;
				
			}
			
			else if(ch>='0'&& ch<='9'){
				
				digit++;
				
			}
				
		}
		
		
		System.out.println("Vowels: " + vowel);
        System.out.println("Consonants: " + cons);
        System.out.println("Digits: " + digit);
        System.out.println("White spaces: " + space);
       
     
	}

}
