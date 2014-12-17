import java.io.*;
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
			String selectColumns ="Accounts(Account Owner,Account Name,Account Total Revenue,Has Attachment)";
			String newFormat = "1";
			String searchColumn = "accountname";
			String searchValue = "Test bbb";
			String fromIndex = "1";
			String toIndex = "50";
			
			String targetURL = "https://crm.zoho.com/crm/private/xml/Accounts/getSearchRecordsByPDC"; 
			String paramname = "content";
			PostMethod post = new PostMethod(targetURL);
			post.setParameter("authtoken",authtoken);
			post.setParameter("scope",scope);
			post.setParameter("fromIndex",fromIndex);
			post.setParameter("toIndex",toIndex);
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
				myout = new PrintWriter(new File("response.xml"));
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