package mm.myiptest;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class IPSaver {
	/*
	 * main method
	 */
	public static void main(String[] args) 
	{
		// my site for retrieving my Global IP
		final String mySite = "http://checkip.amazonaws.com"; 

		// my file deceleration
		//final File myFile = new File("C:\\Users\\משה\\Dropbox\\RaspberryPi_IPAddresses.txt");

		// current time stamp
		final String TIME_STAMP = new SimpleDateFormat("dd:MM:yyyy_HH:ss").format(new Date());

		// Google Spreadsheet Data-logging URL
		String MY_LOOGING_DATA_URL = "https://script.google.com/macros/s/AKfycbwfNWHfoOmR4cDn9QDbK6-vymlw1JbPtrPsUMJ0fkgMmu5-wsI/exec?"; 

		//
		final String DEVICE_NAME = "Raspberry_Pi_-_BabyKeeper";
		// main try clause 
		try 
		{
			System.out.println(getLocalIP());
			System.out.println(getGlobalIP(mySite));
			
			// write them to new file and save file to Dropbox Directory
			//writeToFile(getLocalIP(), getGlobalIP(mySite), myFile,timeStamp);
			//sendToGoogleSpreadsheet(getLocalIP(), getGlobalIP(mySite),MY_LOOGING_DATA_URL,DEVICE_NAME,TIME_STAMP);
		} 

	}

	/*
	private static void sendToGoogleSpreadsheet(String localIP, String globalIP,String url,String deviceName,String time) throws MalformedURLException 
	{
		try{
			String params = "Device_Name="+ URLEncoder.encode(deviceName, "UTF-8")
					+"&Timestamp="+ URLEncoder.encode(time, "UTF-8")
					+"&Raspberry_Pi_IP_Local_Address="+ URLEncoder.encode(localIP, "UTF-8")
					+"&RaspberryPi_IP_Global_Address="+ URLEncoder.encode(globalIP, "UTF-8");

			URL exac = new URL(url+"Device_Name="+ URLEncoder.encode(deviceName, "UTF-8")
					+"&Timestamp="+ URLEncoder.encode(time, "UTF-8")
					+"&Raspberry_Pi_IP_Local_Address="+ URLEncoder.encode(localIP, "UTF-8")
					+"&RaspberryPi_IP_Global_Address="+ URLEncoder.encode(globalIP, "UTF-8"));

			System.out.println(time);
			System.out.println(params);
			System.out.println(url+params);
			
			Desktop.getDesktop().browse(exac.toURI());						

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


*/

	/*
	 * method to write to file.
	 * @param local local IP.
	 * @param global global IP.
	 * @param myfile my file name and full path.
	 */
	/*	public static void writeToFile(String local,String global,File myfile,String timeStamp) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(myfile);
		pw.println("Local IP : "+local);
		pw.println("Global IP : "+global);
		pw.println(timeStamp);
		pw.close();
	}*/

	/*
	 * method to get my local IP address
	 */
	public static String getLocalIP() throws UnknownHostException
	{
		return InetAddress.getLocalHost().toString().replaceAll("[^\\d.]", "");
	}
	/*
	 * method to get my Global IP address\
	 * @param mySite the site to check global IP
	 */
	public static String getGlobalIP(String mySite) throws IOException
	{
		BufferedReader in = null;
		URL whatismyip = null;

		whatismyip = new URL(mySite);
		in = new BufferedReader(new InputStreamReader(
				whatismyip.openStream()));
		String temp = in.readLine();
		return  temp;
	}
}