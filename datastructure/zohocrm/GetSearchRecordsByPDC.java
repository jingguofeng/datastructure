
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.*;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;

public class GetSearchRecordsByPDC 
{
	public static void main(String a[])
	{	
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		String timeOutput;

		rightNow = new Date();
		currentLocale = new Locale("en");
		
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
		timeOutput = timeFormatter.format(rightNow);
		
		try	
		{
			//----------------------------Fetch Auth Token ----------------------
			String authtoken = "30da54220070bc261e4fbe65c9c88e50";//If you don't have a authtoken please refer this wiki https://zohocrmapi.wiki.zoho.com/using-authtoken.html
			String scope = "crmapi";
			/*
			 * Specify the target result
			 */
			//String selectColumns ="Accounts(Account Owner,Account Name,Account Total Revenue,Has Attachment)";
			String selectColumns ="All";
			String newFormat = "1";
			String searchColumn = "accountid";
			String searchValue = "493609000010890281";  //Account ID

			
			/*
			 * Specify the module and method
			 */
			
			String zohocrm = "https://crm.zoho.com/crm/private/xml";
			String module = "/Accounts";
			String module2 = "/SalesOrders";
			String method = "/getSearchRecordsByPDC";
			
			String targetURL = zohocrm + module2 + method; 
			String paramname = "content";
			PostMethod post = new PostMethod(targetURL);
			post.setParameter("authtoken",authtoken);
			post.setParameter("scope",scope);
			post.setParameter("newFormat",newFormat);
			post.setParameter("selectColumns",selectColumns);
			post.setParameter("searchColumn",searchColumn);
			post.setParameter("searchValue",searchValue);
			HttpClient httpclient = new HttpClient();
			PrintWriter myout = null;

			// Execute http request
			try 
			{
				long t1 = System.currentTimeMillis();
				int result = httpclient.executeMethod(post);
				System.out.println("HTTP Response status code: " + result);
				System.out.println(">> Time taken " + (System.currentTimeMillis() - t1));
				
				// writing the response to a file
				//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy_hh.mm.ss.S_aa");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy__hh.mm.ss__aa");

				String formattedDate = dateFormat.format(new Date()).toString();
				String XMLfile = "response_" + formattedDate +".xml";
				myout = new PrintWriter(new File(XMLfile));
				myout.print(post.getResponseBodyAsString());

				/*-----------------------Get response as a string ----------------*/
				String postResp = post.getResponseBodyAsString();
				System.out.println("postResp=======>"+postResp);
				/* ---------------------Get ----------------------------*/
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			finally 
			{
				myout.close();
				post.releaseConnection();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}