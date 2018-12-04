package core.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import model.ConnectionParameters;

public class ParsersRunner {

	private static final String CONNECTION_XML = "src/main/data/connection.xml";
	private List<ConnectionParameters> connectionParameters;

	public List<ConnectionParameters> initDOMParser()
			throws XMLStreamException, SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(CONNECTION_XML);
		connectionParameters = new DOMParser().parse(document);
		return connectionParameters;
	}

	public List<ConnectionParameters> initSAXParser() throws SAXException, IOException, ParserConfigurationException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		CustomSAXParser customSAXParser = new CustomSAXParser();
		saxParser.parse(new File(CONNECTION_XML), customSAXParser);
		connectionParameters = customSAXParser.getConnectionParameters();
		return connectionParameters;
	}

	public List<ConnectionParameters> initStaxParser() throws FileNotFoundException, XMLStreamException {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(CONNECTION_XML));
		connectionParameters = new CustomStaxParser().parse(xmlEventReader);
		return connectionParameters;
	}

}
