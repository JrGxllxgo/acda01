package peval1acda2223;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 * 
 * @author José Ramón Gallego Vélez
 * @date 05/10/2022
 * @version 1.0
 * 
 * @info We use this class to create a XML file with an object as a base
 */
public class CreateXML {

	GeneralMethods m = new GeneralMethods();

	public CreateXML() throws ParserConfigurationException, IOException, TransformerFactoryConfigurationError,
			TransformerException, ClassNotFoundException {

		m.print("Creando archivo XML...");
		DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder myConstructor = myFactory.newDocumentBuilder();
		DOMImplementation implementation = myConstructor.getDOMImplementation();

		File myObject = new File("./investor.obj");

		FileInputStream fisObjct = new FileInputStream(myObject);
		ObjectInputStream oisObjct = new ObjectInputStream(fisObjct);

		Document myDocument = implementation.createDocument(null, "companies", null);
		myDocument.setXmlVersion("1.0");

		Element investors = myDocument.createElement("investors");

		try {
			while (true) {

				Element investor = myDocument.createElement("investor");

				Investor invObj = (Investor) oisObjct.readObject();

				investor.setAttribute("type", invObj.getSort());

				Element company = myDocument.createElement("company");
				Text txtCompany = myDocument.createTextNode(String.valueOf(invObj.getCompany()));
				company.appendChild(txtCompany);
				investor.appendChild(company);

				Element personaldata = myDocument.createElement("personaldata");
				investor.appendChild(personaldata);

				Element nombre = myDocument.createElement("nombre");
				Text txtNombre = myDocument.createTextNode(invObj.getName());
				nombre.appendChild(txtNombre);
				personaldata.appendChild(nombre);

				Element apellido = myDocument.createElement("apellido");
				Text txtApellido = myDocument.createTextNode(invObj.getSurname());
				apellido.appendChild(txtApellido);
				personaldata.appendChild(apellido);

				investors.appendChild(investor);
				myDocument.getDocumentElement().appendChild(investors);

				Source source = new DOMSource(myDocument);
				Result resultado = new StreamResult(new File("./companies.XML"));
				Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
				miTransformer.transform(source, resultado);

			}
		} catch (EOFException e) {
			m.print("Archivo XML Creado con EXITO!!!");
		}

	}
}
