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

public class Ej14_XML {
	public static void main(String[] args)
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance(); //Create DOM Factory
		DocumentBuilder myConstructor = myFactory.newDocumentBuilder(); //Create DOM Constructor
		DOMImplementation implementation = myConstructor.getDOMImplementation(); //DOM Interface
		
		Document myDocument = implementation.createDocument(null, "universidad", null); //Document creation
		myDocument.setXmlVersion("1.0"); //XML Version
		
		//Departamento 1
		Element uinversidad = myDocument.createElement("universidad");
		Element departamento = myDocument.createElement("departamento");
		
		departamento.setAttribute("telefono", introKeybString("Introduzca un telefono"));
		departamento.setAttribute("tipo", introKeybString("Introduzca un tipo"));
		
		Element codigo = myDocument.createElement("codigo");
		Text txtCodigo = myDocument.createTextNode(introKeybString("Introduzca el codigo"));
		codigo.appendChild(txtCodigo);
		departamento.appendChild(codigo);
		
		Element nombre = myDocument.createElement("nombre");
		Text txtName = myDocument.createTextNode(introKeybString("Introduzca el nombre"));
		nombre.appendChild(txtName);
		departamento.appendChild(nombre);
		
		Element empleado = myDocument.createElement("empleado");
		empleado.setAttribute("salario", introKeybString("Introduzca el salario"));
		departamento.appendChild(empleado);
		
		Element puestoEmpleado = myDocument.createElement("puesto");
		Text txtPuestoEmpleado = myDocument.createTextNode(introKeybString("Introduzca el puesto del empleado"));
		puestoEmpleado.appendChild(txtPuestoEmpleado);
		empleado.appendChild(puestoEmpleado);
		
		Element nombreEmpleado = myDocument.createElement("nombre");
		Text txtNameEmpleado = myDocument.createTextNode(introKeybString("Introduzca el nombre del empleado"));
		nombreEmpleado.appendChild(txtNameEmpleado);
		empleado.appendChild(nombreEmpleado);
		
		Element empleado2 = myDocument.createElement("empleado");
		empleado2.setAttribute("salario", introKeybString("Introduzca el salario"));
		departamento.appendChild(empleado2);
		
		Element puestoEmpleado2 = myDocument.createElement("puesto");
		Text txtPuestoEmpleado2 = myDocument.createTextNode(introKeybString("Introduzca el puesto del empleado"));
		puestoEmpleado2.appendChild(txtPuestoEmpleado2);
		empleado2.appendChild(puestoEmpleado2);
		
		Element nombreEmpleado2 = myDocument.createElement("nombre");
		Text txtNameEmpleado2 = myDocument.createTextNode(introKeybString("Introduzca el nombre del empleado"));
		nombreEmpleado2.appendChild(txtNameEmpleado2);
		empleado2.appendChild(nombreEmpleado2);
		
		uinversidad.appendChild(departamento);
		
		myDocument.getDocumentElement().appendChild(uinversidad);
		
		Source source = new DOMSource(myDocument);
		Result resultado = new StreamResult(new File("D://FileTesting/uni.XML"));
		Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
		miTransformer.transform(source, resultado);
	}
	
	public static String introKeybString(String txt) {
		System.out.println(txt);
		Scanner keyb = new Scanner(System.in);
		return keyb.next();
	}
}
