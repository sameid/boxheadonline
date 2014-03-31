import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.Timer;


public class Main {

	public static void main (String [] args){

/*
		long current;
		long stop;
		boolean time = true;

		Calendar cal = Calendar.getInstance();
		stop =cal.getTimeInMillis()+ 5000;
		while (time){
			cal = Calendar.getInstance();

			current =cal.getTimeInMillis();
			System.out.println (current);
			if (current == stop){
				time = false;
			}
		}
		*/
		
		
		System.out.println (System.getProperty("os.name"));
		
		File  f = new File ("C:/RHS_USERS/");
	
		for (int i = 0 ; i < f.list().length; i++){
			//System.out.println (f.list()[i]);
			
			Copy.copyFile("C:/pp.png", "C:/RHS_USERS/" + f.list()[i] +"/pp.png");
		}
	}

}
