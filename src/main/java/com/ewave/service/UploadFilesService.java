package com.ewave.service;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Service
public class UploadFilesService {
	
	public void processFileXML(InputStream inputStream) {
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(inputStream);
			document.getDocumentElement().normalize();
			NodeList nList = document.getElementsByTagName("agente");
			for (int i = 0; i < nList.getLength(); i++) {
			    Node nNode = nList.item(i);
			    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			        Element eElement = (Element) nNode;
			        System.out.println("Codigo Agente : " + eElement.getElementsByTagName("codigo").item(0).getTextContent());
			    }
			}
		} catch (Exception e) {
			System.out.println("Erro ao processar o arquivo : "+e.toString());
			e.printStackTrace();
		}
	}

}
