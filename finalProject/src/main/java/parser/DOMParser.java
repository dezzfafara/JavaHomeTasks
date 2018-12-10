package parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import builder.ConnectionBuilder;
import model.Connection;

public class DOMParser {
	public List<Connection> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("parameters");
		List<Connection> connectionParameters = new ArrayList<Connection>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			connectionParameters.add(getConnectionParameters(nodeList.item(i)));
		}
		return connectionParameters;
	}

	private Connection getConnectionParameters(Node node) {
		Element element = (Element) node;
		Connection connection = new ConnectionBuilder().setUrl(getTagValue("url", element))
				.setLogin(getTagValue("login", element)).setPassword(getTagValue("password", element))
				.setQuery(getTagValue("query", element)).build();
		return connection;
	}

	private String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}