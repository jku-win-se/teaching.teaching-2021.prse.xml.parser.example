package jku.se.xml.parser.example.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ReadBooks {
		
	public static String BOOKS_XML = "xml/books.xml";
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException, XMLStreamException, IOException, URISyntaxException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		 
        // unmarshall: String "source" to Java object
        Unmarshaller um = jaxbContext.createUnmarshaller();
        
 
        XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlFactory.createXMLStreamReader(new FileReader("xml/books.xml"));
 
        // interested in "book" elements only. Skip up to first "book"
        while (reader.hasNext() && (!reader.isStartElement() || !reader.getLocalName().equals("book"))) {
        	reader.next();
        }
 
        // read a book at a time
        while (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {   
        	JAXBElement<Book> boolElement = um.unmarshal(reader, Book.class);
            Book book = boolElement.getValue();
            if (book.getAuthor() != null) {  //skip footer tag
                System.out.println("Id " + book.getId() + " "
                		+ book.getAuthor() + " wrote " 
                		+ book.getTitle()
                		+ " and made this note: " + book.getNote()
                	);
            }
 
            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                reader.next();
            }
        } 
        
        
        
        
        reader.close();
	}

}
