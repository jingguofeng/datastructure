package datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.*;
import org.w3c.dom.*;

import javax.xml.parsers.*;

public class PasrseXML {

	public static void main(String[] args) throws IOException
	{
		Document xmlDoc = getDocument("./response_17-Dec-14__03.10.25__PM.xml");
		BufferedReader br = new BufferedReader(new FileReader(new File("./response.xml")));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line=br.readLine())!= null){
			//System.out.println("added");
		    sb.append(line.trim());
		}
		
		System.out.println(sb);
		
		System.out.println("Root: " +
				xmlDoc.getDocumentElement().getNodeName());
		
		NodeList listOfResult = xmlDoc.getElementsByTagName("Accounts");
		
		System.out.println(listOfResult.item(0).getNodeValue());
		System.out.println("Number of shows: " + 
				listOfResult.getLength());
		
		String attrName = "val";
		String elementName = "FL";
		
		getElementAndAttrib(listOfResult, elementName, attrName);
	}
	
	
	private static void getElementAndAttrib(NodeList listOfItem, String elementName, String attrName){
		
		try{
			for(int i = 0; i < listOfItem.getLength(); i++){
				Node resultNode = listOfItem.item(i);  //Get the node with the TagName in listOfItem
				Element resultElement = (Element) resultNode;
				//Everything inside XML is Node.
				NodeList networkList = resultElement.getElementsByTagName(elementName);
				System.out.println("Number of " + elementName + ": " + 
						networkList.getLength());
				
				for(int j = 0; j < networkList.getLength(); j++)
				{
					Element networkElement = (Element) networkList.item(j);
					
					NodeList elementList = networkElement.getChildNodes();
					System.out.println("<!-- " + elementList.item(0) + " -->");
					
					if(networkElement.hasAttribute(attrName)){
						System.out.println(elementName + ": " +
								( networkElement.getAttribute(attrName) + ": " + ((Node) elementList.item(0)).getNodeValue().trim())+ "\n");
					}else{
						System.out.println(elementName + ": " +
								((Node) elementList.item(0)).getNodeValue().trim());
		
					}
				
				}
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	private static Document getDocument(String docString){
		
		try{
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			return builder.parse(new InputSource(docString));
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return null;
	}
}
