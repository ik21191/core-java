package com.mypack.xml.dom.parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile2 {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("e://ieee.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList webmartList = doc.getElementsByTagName("webmart");

	System.out.println("----------------------------");

	for (int i = 0; i < webmartList.getLength(); i++) {

		Node webmartNode = webmartList.item(i);

		System.out.println("\nCurrent Element :" + webmartNode.getNodeName());

		if (webmartNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) webmartNode;

			if(eElement.getElementsByTagName("webmartCode").item(0) != null) {
				System.out.println("webmartCode : " + eElement.getElementsByTagName("webmartCode").item(0).getTextContent());
			}
			
			
			NodeList nList1 = webmartNode.getChildNodes();
			for(int j=0; j < nList1.getLength(); j++) {
				Node node2 = nList1.item(j);
				System.out.println(node2.getNodeName());
				if(node2.getNodeType() == Node.ELEMENT_NODE) {
					Element element2 = (Element)node2;
					if(element2.getElementsByTagName("webmartCode").item(0) != null) {
						System.out.println("webmartCode : " + element2.getElementsByTagName("webmartCode").item(0).getTextContent());
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