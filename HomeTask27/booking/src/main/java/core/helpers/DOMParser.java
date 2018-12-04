package core.helpers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.ConnectionParameters;

public class DOMParser {
	public List<ConnectionParameters> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("parameters");
		List<ConnectionParameters> connectionParameters = new ArrayList<ConnectionParameters>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			connectionParameters.add(getConnectionParameters(nodeList.item(i)));
		}
		return connectionParameters;
	}

	private static ConnectionParameters getConnectionParameters(Node node) {
		ConnectionParameters connectionParams = new ConnectionParameters();
		Element element = (Element) node;
		connectionParams.setUrl(getTagValue("url", element));
		connectionParams.setLogin(getTagValue("login", element));
		connectionParams.setPassword(getTagValue("password", element));
		connectionParams.setQuery(getTagValue("query", element));
		return connectionParams;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
