package jku.se.xml.parser.example.impl;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TitleHandler implements DomHandler<String, StreamResult> {
	
	private static final String TITLE_START_TAG = "<title>";
    private static final String TITLE_END_TAG = "</title>";
	
    private StringWriter xmlWriter = new StringWriter();
    
	@Override
	public StreamResult createUnmarshaller(ValidationEventHandler errorHandler) {
		return new StreamResult(xmlWriter);
	}

	@Override
	public String getElement(StreamResult rt) {
		String xml = rt.getWriter().toString();
        int beginIndex = xml.indexOf(TITLE_START_TAG) + TITLE_START_TAG.length();
        int endIndex = xml.indexOf(TITLE_END_TAG);
        return xml.substring(beginIndex, endIndex);
	}

	@Override
	public Source marshal(String n, ValidationEventHandler errorHandler) {
		try {
            String xml = TITLE_START_TAG + n.trim() + TITLE_END_TAG;
            StringReader xmlReader = new StringReader(xml);
            return new StreamSource(xmlReader);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
	}

}
