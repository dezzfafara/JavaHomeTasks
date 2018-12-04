package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Country;

public class CountryHandler extends DefaultHandler {
	private List<Country> countries;
	private Country country;
	private boolean bCode = false;
	private boolean bName = false;
	private boolean bDescription = false;

	public List<Country> getCountries() {
		return countries;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {
		case "country":
			country = new Country();
			country.setId(Integer.parseInt(attributes.getValue("id")));
			if (countries == null) {
				countries = new ArrayList<Country>();
			}
			break;
		case "code":
			bCode = true;
			break;
		case "name":
			bName = true;
			break;
		case "description":
			bDescription = true;
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("country")) {
			countries.add(country);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bCode) {
			country.setCode(new String(ch, start, length));
			bCode = false;
		} else if (bName) {
			country.setName(new String(ch, start, length));
			bName = false;
		} else if (bDescription) {
			country.setDescription(new String(ch, start, length));
			bDescription = false;
		}
	}
}
