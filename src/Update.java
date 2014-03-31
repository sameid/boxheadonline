import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Update {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Copy.copyFile("C:/Users/sameid_usmani/Documents/Dropbox/workspace/Boxhead Online Beta/fat.jar", "C:/Program Files/Java/jdk1.7.0_02/bin/fat.jar");


		System.out.println ("\\");
		
		try 
		{ 
			//C:\Progra~1\Java\jdk1.7.0_02\bin\jarsigner -keystore myKeystore fat.jar Sameid
			//Runtime.getRuntime().exec("C:\\Users\\sameid_usmani\\Downloads\\eclipse-java-galileo-SR2-win32\\eclipse\\eclipse");
			
			String[] commands = new String[]{
				"C:\\Progra~1\\Java\\jdk1.7.0_02\\bin\\jarsigner","-keystore", "myKeystore", "fat.jar", "Sameid"
			};
			
			Process p = Runtime.getRuntime().exec(commands);
		
			
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

           
            String line=null;

            while((line=input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = p.waitFor();
            System.out.println("Exited with error code "+exitVal);
		    
		 
			
		} 
		catch(IOException e1) {} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("Done"); 
	} 

	

}
