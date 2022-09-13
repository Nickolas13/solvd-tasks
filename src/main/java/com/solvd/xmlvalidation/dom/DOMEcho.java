package com.solvd.xmlvalidation.dom;

//exceptions while parsing

//read xml file and manage output

//w3 definitions for dom


import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class DOMEcho {

    static final String outputEncoding = "UTF-8";
    static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

    static final String JAXP_SCHEMA_SOURCE =
            "http://java.sun.com/xml/jaxp/properties/schemaSource";
    static final String W3C_XML_SCHEMA =
            "http://www.w3.org/2001/XMLSchema";

    private static void usage() {

    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String filename = "src/main/resources/validation/sample.xml";
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
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(dtdValidate || xsdValidate);
        if (xsdValidate) {
            try {
                dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            } catch (IllegalArgumentException x) {
                System.err.println("Error: JAXP DocumanBuilderFactory Attribute Not Recognized: " + JAXP_SCHEMA_LANGUAGE);
                System.out.println("Check to See If Parser Conforms to JAXP specification");
                System.exit(1);
            }
        }
        if (schemaSource != null) {
            dbf.setAttribute(JAXP_SCHEMA_SOURCE, new File(schemaSource));
        }

        DocumentBuilder db = dbf.newDocumentBuilder();
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, outputEncoding);
        db.setErrorHandler(new MyErrorHandler(new PrintWriter(errorWriter, true)));
        Document doc = db.parse(new File(filename));
    }
}
