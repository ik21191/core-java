package com.mypack.xml.dom.parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.mypack.xml.dom.beans.Client;
import com.mypack.xml.dom.beans.Fields;
import com.mypack.xml.dom.beans.FileToProcess;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//Placed example file in static folder
public class ReadXMLFile {

	public List<Client> createObjectFromXML(String fileName) {

		List<Client> clientList = new ArrayList<Client>();
		try {

			File fXmlFile = new File(fileName);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList webmartList = doc.getElementsByTagName("webmart");

			for (int i = 0; i < webmartList.getLength(); i++) {
				Client client = new Client();
				Node webmartNode = webmartList.item(i);
				if (webmartNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) webmartNode;
					if (element.getElementsByTagName("webmartCode").item(0) != null) {
						client.setWebmartCode(element.getElementsByTagName("webmartCode").item(0).getTextContent());
					}
					List<FileToProcess> listFileToProcess = getListOfFileToProcess(element.getChildNodes());
					if (listFileToProcess.size() > 0) {
						client.setListFileToProcess(listFileToProcess);
					}
				}
				clientList.add(client);
			}
			print(clientList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientList;
	}

	private List<FileToProcess> getListOfFileToProcess(NodeList chiledNodesForFiles) {
		List<FileToProcess> listFileToProcess = new ArrayList<FileToProcess>();
		for (int j = 0; j < chiledNodesForFiles.getLength(); j++) {
			FileToProcess fileToProcess = null;
			Node fileNode = chiledNodesForFiles.item(j);
			if (fileNode.getNodeType() == Node.ELEMENT_NODE && fileNode.getNodeName().equals("file")) {
					fileToProcess = new FileToProcess();
					Element fileElement = (Element) fileNode;
					if (fileElement.getElementsByTagName("fileName").item(0) != null) {
						fileToProcess.setFileName(fileElement.getElementsByTagName("fileName").item(0).getTextContent());
					}
					fileToProcess.setFieldList(getListOfFields(fileElement.getChildNodes()));
			}
			if(fileToProcess != null) {
				listFileToProcess.add(fileToProcess);
			}
		}
		return listFileToProcess;
	}

	protected List<Fields> getListOfFields(NodeList chiledNodesForFields) {
		List<Fields> fields = new ArrayList<Fields>();
		Fields field = null;
		Element fieldElement = null;
		for (int k = 0; k < chiledNodesForFields.getLength(); k++) {
			Node fieldNode = chiledNodesForFields.item(k);
			if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
				if (fieldNode.getNodeName().equalsIgnoreCase("field")) {
					fieldElement = (Element) fieldNode;
					field = getInitializedField(fieldElement);
					if (field.getSequence() != null) {
						fields.add(field);
					}
				} else if (fieldNode.getNodeName().equalsIgnoreCase("splitFields")) {
					NodeList splitFieldNodes = fieldNode.getChildNodes();
					for (int l = 0; l < splitFieldNodes.getLength(); l++) {
						Node splitFieldNode = splitFieldNodes.item(l);
						if (splitFieldNode.getNodeType() == Node.ELEMENT_NODE && splitFieldNode.getNodeName().equalsIgnoreCase("field")) {
							fieldElement = (Element) splitFieldNode;
							field = getInitializedField(fieldElement);
							if (field.getSequence() != null) {
								fields.add(field);
							}
						}
					}
				}
			}
		}
		return fields;
	}

	private List<String> getSpecialProcessingFields(NodeList specialProcessingList) {
		List<String> listTargetSuccessField =  new ArrayList<String>();
		for(int m = 0; m < specialProcessingList.getLength(); m++) {
			Node specialProcessingNode = specialProcessingList.item(m);
			if(specialProcessingNode.getNodeType() == Node.ELEMENT_NODE && specialProcessingNode.getNodeName().equalsIgnoreCase("specialProcessing")) {
				Element specialProcessingNodeElement = (Element) specialProcessingNode;
				for(int i = 0; i < specialProcessingNodeElement.getElementsByTagName("targetSuccessField").getLength(); i++) {
					listTargetSuccessField.add(specialProcessingNodeElement.getElementsByTagName("targetSuccessField").item(i).getTextContent());
				}
			}
		}
		return listTargetSuccessField;
	}

	private Fields getInitializedField(Element fieldelement) {
		Fields field = new Fields();
		if (fieldelement.getElementsByTagName("sequence").item(0) != null) {
			field.setSequence(fieldelement.getElementsByTagName("sequence").item(0).getTextContent());
		}

		if (fieldelement.getElementsByTagName("fieldPattern").item(0) != null) {
			field.setPattern(fieldelement.getElementsByTagName("fieldPattern").item(0).getTextContent());
		}

		if (fieldelement.getElementsByTagName("name").item(0) != null) {
			field.setName(fieldelement.getElementsByTagName("name").item(0).getTextContent());
		}

		if (fieldelement.getElementsByTagName("description").item(0) != null) {
			field.setDescription(fieldelement.getElementsByTagName("description").item(0).getTextContent());
		}

		if (fieldelement.getElementsByTagName("targetField").item(0) != null) {
			field.setTargetField(fieldelement.getElementsByTagName("targetField").item(0).getTextContent());
		}
		
		List<String> listTargetSuccessField = getSpecialProcessingFields(fieldelement.getChildNodes());
		if (listTargetSuccessField.size() > 0) {
			field.setListTargetSuccessField(listTargetSuccessField);
		}
		return field;
	}
  
// This is an extra method to print clientList
	public void print(List<Client> clientList) {
		try {
		PrintWriter out = new PrintWriter(new FileWriter(new File("e://out.txt")));
		for(Client client : clientList) {
			out.println(client.getWebmartCode());
			for(FileToProcess fileToProcess : client.getListFileToProcess()) {
				out.println(fileToProcess.getFileName());
				for(Fields field : fileToProcess.getFieldList()) {
					out.println(field.getSequence() + "  " + field.getPattern() + "  " + field.getName() + "  " +field.getListTargetSuccessField());
				}
			}
		}
		out.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
}