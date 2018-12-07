package core.helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import model.ConnectionParameters;

public class CustomStaxParser {
	private static final String URL = "url";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String QUERY = "query";
	private static final String PARAMETERS = "parameters";

	private ConnectionParameters connectionParams;
	List<ConnectionParameters> connectionParameters = new ArrayList<ConnectionParameters>();

	public List<ConnectionParameters> parse(XMLEventReader xmlEventReader)
			throws FileNotFoundException, XMLStreamException {
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			proceedStartElement(xmlEvent, xmlEventReader);
			proceedEndElement(xmlEvent);
		}
		return connectionParameters;
	}

	private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
		if (xmlEvent.isStartElement()) {
			StartElement startElement = xmlEvent.asStartElement();
			if (isTagNameEqual(startElement, PARAMETERS)) {
				connectionParams = new ConnectionParameters();
			} else if (isTagNameEqual(startElement, URL)) {
				connectionParams.setUrl(xmlEventReader.nextEvent().asCharacters().getData());
			} else if (isTagNameEqual(startElement, LOGIN)) {
				connectionParams.setLogin(xmlEventReader.nextEvent().asCharacters().getData());
			} else if (isTagNameEqual(startElement, PASSWORD)) {
				connectionParams.setPassword(xmlEventReader.nextEvent().asCharacters().getData());
			} else if (isTagNameEqual(startElement, QUERY)) {
				connectionParams.setQuery(xmlEventReader.nextEvent().asCharacters().getData());
			}
		}
	}

	private void proceedEndElement(XMLEvent xmlEvent) {
		if (xmlEvent.isEndElement()) {
			EndElement endElement = xmlEvent.asEndElement();
			if (endElement.getName().getLocalPart().equals(PARAMETERS)) {
				connectionParameters.add(connectionParams);
			}
		}
	}

	private boolean isTagNameEqual(StartElement startElement, String tagName) {
		return startElement.getName().getLocalPart().equals(tagName);
	}
}
