package DomLesson;

import java.io.File;
import java.util.Scanner;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ej12_XML {
	public static void main(String[] args)
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance(); //Create DOM Factory
		DocumentBuilder myConstructor = myFactory.newDocumentBuilder(); //Create DOM Constructor
		DOMImplementation implementation = myConstructor.getDOMImplementation(); //DOM Interface
		
		Document myDocument = implementation.createDocument(null, "clientes", null); //Document creation
		myDocument.setXmlVersion("1.0"); //XML Version
		
		//Cliente 1
		Element clientes = myDocument.createElement("clientes");
		Element clien = myDocument.createElement("clien");
		
		clien.setAttribute("numero", introKeybString("Introduzca un numero de cliente"));
		
		Element nombre = myDocument.createElement("nombre");
		Text txtName = myDocument.createTextNode(introKeybString("Introduzca el nombre"));
		nombre.appendChild(txtName);
		clien.appendChild(nombre);
		
		Element poblacion = myDocument.createElement("poblacion");
		Text txtPoblacion = myDocument.createTextNode(introKeybString("Introduzca la poblacion"));
		poblacion.appendChild(txtPoblacion);
		clien.appendChild(poblacion);
		
		Element tlf = myDocument.createElement("tlf");
		Text txtTlf = myDocument.createTextNode(introKeybString("Introduzca el telefono"));
		tlf.appendChild(txtTlf);
		clien.appendChild(tlf);
		
		Element direccion = myDocument.createElement("direccion");
		Text txtDireccion = myDocument.createTextNode(introKeybString("Introduzca la direccion"));
		direccion.appendChild(txtDireccion);
		clien.appendChild(direccion);
		
		clientes.appendChild(clien);
		
		myDocument.getDocumentElement().appendChild(clientes);
		
		Source source = new DOMSource(myDocument);
		Result resultado = new StreamResult(new File("D://FileTesting/clientes.XML"));
		Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
		miTransformer.transform(source, resultado);
	}
	
	public static String introKeybString(String txt) {
		System.out.println(txt);
		Scanner keyb = new Scanner(System.in);
		return keyb.next();
	}
}
