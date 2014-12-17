import java.io.*;
import java.text.DateFormat;
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

public class insertRecords 
{
	public static void main(String a[])
	{	

		try	
		{
			//----------------------------Fetch Auth Token ----------------------
			String authtoken = "d96f7bcb055baee514dee5fa7db8057b";//If you don't have a authtoken please refer this wiki https://zohocrmapi.wiki.zoho.com/using-authtoken.html
			String scope = "crmapi";
			//String selectColumns ="Accounts(Account Owner,Account Name,Account Total Revenue,Has Attachment)";
			String newFormat = "1";
			
			BufferedReader br = new BufferedReader(new FileReader(new File("./newRecord.xml")));
			String line;
			StringBuilder sb = new StringBuilder();

			while((line=br.readLine())!= null){
				//System.out.println("added");
			    sb.append(line.trim());
			}
			
			System.out.println(sb);
			String xmlData = sb.toString();
			
			String zohocrm = "https://crm.zoho.com/crm/private/xml";
			String module = "/SalesOrders";
			String method = "/insertRecords";
			
			String targetURL = zohocrm + module + method; 
			String paramname = "content";
			PostMethod post = new PostMethod(targetURL);
			post.setParameter("authtoken",authtoken);
			post.setParameter("scope",scope);
			post.setParameter("newFormat",newFormat);
			post.setParameter("xmlData",xmlData);

			

			// Execute http request
			try 
			{
		        HttpClient httpclient = new HttpClient();
		        httpclient.executeMethod(post);
		        String postResp = post.getResponseBodyAsString();
		        System.out.println("The Response from the server : "+postResp);
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			finally 
			{
				post.releaseConnection();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}