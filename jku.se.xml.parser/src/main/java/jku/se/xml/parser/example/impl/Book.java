package jku.se.xml.parser.example.impl;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/* Define therefore the following class to store the individual entries of the XML file */

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	
	@XmlAttribute
	private String id;
	
	@XmlElement
	private String author;
	
	@XmlAnyElement(TitleHandler.class)
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
