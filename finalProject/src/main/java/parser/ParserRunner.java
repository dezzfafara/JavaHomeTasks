package parser;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import model.Connection;

public class ParserRunner {

	private static final String CONNECTION_XML = "src/main/resources/connection.xml";
	private List<Connection> connectionParameters;

	public Connection initDOMParser()
			throws XMLStreamException, SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(CONNECTION_XML);
		connectionParameters = new DOMParser().parse(document);
		return connectionParameters.get(0);
	}
}
