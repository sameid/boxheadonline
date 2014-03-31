import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class Copy {
	public static void copyFile(String intialDirectory, String finalDirectory){
        try{
                //Make copy files objects
                File inputFile = new File(intialDirectory);
                File outputFile = new File(finalDirectory);

                //Create and open streams to both file to those specific directories
                InputStream in = new FileInputStream(inputFile);
                OutputStream out = new FileOutputStream(outputFile);
                
                //Basically copying byte to byte from the intial stream to the final stream
                byte[] buf = new byte[1024];//1mb transfer rate
                int len;
                
                //Now continously copy untill the space that the file takes up is 0
            while ((len = in.read(buf)) > 0){
                out.write(buf, 0, len);//Rewrite file from the intial to final 
                System.out.println ("Copying...");
            }
                in.close();
                out.close();
                System.out.println ("File copied");
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
	}
}
