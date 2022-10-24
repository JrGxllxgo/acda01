package peval1acda2223;

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

/**
 * 
 * @author José Ramón Gallego Vélez
 * @date 05/10/2022
 * @version 1.0
 * 
 * @info This class is used to read de XML file
 */
public class ReadXML {

	GeneralMethods m = new GeneralMethods();

	public ReadXML() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder myConstructor = myFactory.newDocumentBuilder();

		Document myDocument = myConstructor.parse(new File("./companies.XML"));

		NodeList investorList = myDocument.getElementsByTagName("investor");

		for (int i = 0; i < investorList.getLength(); i++) {
			Node nodo = investorList.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				System.out.println("\nType " + e.getNodeName() + ":" + e.getAttribute("type"));
				NodeList listaHijos = e.getChildNodes();

				for (int j = 0; j < listaHijos.getLength(); j++) {
					Node hijo = listaHijos.item(j);
					if (hijo.getNodeType() == Node.ELEMENT_NODE) {
						Element eHijo = (Element) hijo;
						NodeList listaNietos = eHijo.getChildNodes();

						for (int k = 0; k < listaNietos.getLength(); k++) {
							Node nieto = listaNietos.item(k);
							if (nieto.getNodeType() == Node.ELEMENT_NODE) {
								Element eNieto = (Element) nieto;
								m.print(eNieto.getNodeName() + ":" + eNieto.getTextContent());
							}
						}
					}
				}
			}
		}
	}
}
