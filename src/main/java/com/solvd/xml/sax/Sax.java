package com.solvd.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Sax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                String id = attributes.getValue("id");
                if (id != null && !id.isEmpty()) {
                    System.out.println(id);
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String str = "";
                for (int i = 0; i < length; i++) {
                    str += ch[start + i];
                }
                System.out.println(str);
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("src/main/resources/validation/sample.xml"), handler);
    }
}
