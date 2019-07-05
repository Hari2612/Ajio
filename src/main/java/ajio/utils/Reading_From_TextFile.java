package ajio.utils;

import java.io.BufferedReader;

public class Reading_From_TextFile {
	
	
	 public String[] read(BufferedReader br) throws Exception {
			String ans = "";
			int i;
			
			while(( i = br.read()) != -1 ){
				if((char)i != '#') {
					while((char)br.read() != '=');
					
					ans = ans + br.readLine();
					ans = ans +",";
				}
				else {
					br.readLine();
				}
					
				
			}
			
			
			return ans.split(",");
			
		}

	
	

}
