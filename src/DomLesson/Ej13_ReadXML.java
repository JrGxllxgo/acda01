package DomLesson;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej13_ReadXML {

	public static void main(String[] args)  throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();
		
		Document miDocumento = miConstructor.parse(new File("D://FileTesting/clientes.XML"));
		
		NodeList listaClien = miDocumento.getElementsByTagName("clien");

		for (int i =  0; i < listaClien.getLength(); i++) {
			Node nodo = listaClien.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				System.out.println("\nNumero "+ e.getNodeName() + ":" + e.getAttribute("numero"));
				NodeList listaHijos = e.getChildNodes();
				
				for (int j = 0; j < listaHijos.getLength(); j++) {
					Node hijo = listaHijos.item(j);
					if (hijo.getNodeType() == Node.ELEMENT_NODE) {
						Element eHijo = (Element) hijo;
						System.out.println(eHijo.getNodeName() + ":" + eHijo.getTextContent());
					}
				}
			}
		}
	}

}
