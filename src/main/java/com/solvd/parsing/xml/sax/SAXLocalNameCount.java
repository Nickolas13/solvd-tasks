package com.solvd.parsing.xml.sax;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

public class SAXLocalNameCount extends DefaultHandler {
    static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";
    static final String JAXP_SCHEMA_SOURCE =
            "http://java.sun.com/xml/jaxp/properties/schemaSource";
    private Hashtable tags;

    private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file: " + path;

    }

    private static void usage() {
        System.err.println("Usage: SAXLocalNameCount <file.xml>");
        System.err.println("       -usage or -help = this message");
        System.exit(1);
    }

    public static void main(String[] args) throws Exception {
        String filename = null;
        boolean dtdValidate = false;
        boolean xsdValidate = false;
        String schemaSource = "src/main/resources/validation/sample.xsd";
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-dtd")) {
                dtdValidate = true;
            } else if (args[i].equals("-xsd")) {
                xsdValidate = true;
            } else if (args[i].equals("-xsdss")) {
                if (i == args.length - 1) {
                    usage();
                }
                xsdValidate = true;
                schemaSource = args[++i];
            } else if (args[i].equals("-usage")) {
                usage();
            } else if (args[i].equals("-help")) {
                usage();
            } else {
                filename = args[i];
                if (i != args.length - 1) {
                    usage();
                }
            }
        }

        if (filename == null) {
            usage();
        }

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(dtdValidate || xsdValidate);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setErrorHandler(new SaxErrorHandler(System.err));
        xmlReader.setContentHandler(new SAXLocalNameCount());
        xmlReader.parse(filename);

        if (xsdValidate) {
            try {
                saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            } catch (SAXNotRecognizedException x) {
                System.err.println("Error: JAXP SAXParser property not recognized: "
                        + JAXP_SCHEMA_LANGUAGE);

                System.err.println("Check to see if parser conforms to the JAXP spec.");
                System.exit(1);
            }
        }
        if (schemaSource != null) {
            saxParser.setProperty(JAXP_SCHEMA_SOURCE, new File(schemaSource));
        }

    }

    public void startDocument() throws SAXException {
        tags = new Hashtable();
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        String key = localName;
        Object value = tags.get(key);
        if (value == null) {
            tags.put(key, 1);
        } else {
            int count = ((Integer) value).intValue();
            count++;
            tags.put(key, count);
        }
    }

    public void endDocument() throws SAXException {
        Enumeration e = tags.keys();
        while (e.hasMoreElements()) {
            String tag = (String) e.nextElement();
            int count = ((Integer) tags.get(tag)).intValue();
            System.out.println("Local Name \"" + tag + "\" occurs " + count + " times");
        }
    }

}
