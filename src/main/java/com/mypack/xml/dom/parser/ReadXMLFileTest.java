package com.mypack.xml.dom.parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFileTest {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("e://employees2.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("Employee");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			//System.out.println("Staff id : " + eElement.getAttribute("id"));
			if(eElement.getElementsByTagName("age").item(0) != null) {
				System.out.println("Age : " + eElement.getElementsByTagName("age").item(0).getTextContent());
			}
			
			if(eElement.getElementsByTagName("name").item(0) != null) {
				System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
			}
			
			if(eElement.getElementsByTagName("gender").item(0) != null) {
				System.out.println("Gender : " + eElement.getElementsByTagName("gender").item(0).getTextContent());
			}
			
			if(eElement.getElementsByTagName("role").item(0) != null) {
				System.out.println("Role : " + eElement.getElementsByTagName("role").item(0).getTextContent());
			}
			
			NodeList nList1 = nNode.getChildNodes();
			for(int i=0; i < nList1.getLength(); i++) {
				Node node2 = nList1.item(i);
				if(node2.getNodeType() == Node.ELEMENT_NODE) {
					Element element2 = (Element)node2;
					if(element2.getElementsByTagName("city").item(0) != null) {
						System.out.println("City : " + element2.getElementsByTagName("city").item(0).getTextContent());
					}
					if(element2.getElementsByTagName("country").item(0) != null) {
						System.out.println("Country : " + element2.getElementsByTagName("country").item(0).getTextContent());
					}
				}
			}

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}