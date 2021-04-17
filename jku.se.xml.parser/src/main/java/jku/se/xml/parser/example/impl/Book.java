package jku.se.xml.parser.example.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/* Define therefore the following class to store the individual entries of the XML file */

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	
	@XmlAttribute
	private String id;
	
	@XmlElement
	private String author;
	
	@XmlElement
	private String title;
	
	public String getId() {
		return id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}

}
