package core.helpers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.ConnectionParameters;

public class CustomSAXParser extends DefaultHandler {
	private List<ConnectionParameters> connectionParameters;
	private ConnectionParameters connectionParams;
	private boolean bUrl = false;
	private boolean bLogin = false;
	private boolean bPassword = false;
	private boolean bQuery = false;

	public List<ConnectionParameters> getConnectionParameters() {
		return connectionParameters;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {
		case "parameters":
			connectionParams = new ConnectionParameters();
			if (connectionParameters == null) {
				connectionParameters = new ArrayList<ConnectionParameters>();
			}
			break;
		case "url":
			bUrl = true;
			break;
		case "login":
			bLogin = true;
			break;
		case "password":
			bPassword = true;
			break;
		case "query":
			bQuery = true;
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("parameters")) {
			connectionParameters.add(connectionParams);
		}
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		System.out.println("ignorableWhitespace = \"" + new String(ch, start, length) + "\"");
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bUrl) {
			connectionParams.setUrl(new String(ch, start, length));
			bUrl = false;
		} else if (bLogin) {
			connectionParams.setLogin(new String(ch, start, length));
			bLogin = false;
		} else if (bPassword) {
			connectionParams.setPassword(new String(ch, start, length));
			bPassword = false;
		} else if (bQuery) {
			connectionParams.setQuery(new String(ch, start, length));
			bQuery = false;
		}
	}
}