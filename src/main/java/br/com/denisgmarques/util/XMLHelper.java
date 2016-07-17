package br.com.denisgmarques.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.denisgmarques.model.Category;
import lombok.extern.java.Log;

@Log
public class XMLHelper {
	private final static String XMLFILE = "bckident.xml";

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(XMLFILE);

        XPath xpath = XPathFactory.newInstance().newXPath();

        // XPath Query for showing all nodes value
        XPathExpression expr = xpath.compile("//table[@name=\"categories\"]/row/*/text()");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        Map<String, String> attributes= new HashMap<String, String>();
        
        for (int i = 0; i < nodes.getLength(); i++) {
        	NamedNodeMap node_attr = nodes.item(i).getParentNode().getAttributes();
        	
        	//System.out.println(node_attr.item(0).getNodeValue());
            //System.out.println(nodes.item(i).getNodeValue());
            
            if (node_attr.item(0).getNodeValue().equals("id")) {
            	if (attributes.size() > 1) {
                	Category category = new Category();
                    category.setId(Integer.valueOf(attributes.get("id")));
                    category.setName(attributes.get("name"));
                    category.setIcon(attributes.get("icon"));
                    category.setType(Integer.valueOf(attributes.get("type")));
                    category.setGroupId(Integer.valueOf(attributes.get("group_id")));
                    category.setUserId(Integer.valueOf(attributes.get("user_id")));
                    System.out.println(category);
            	}
            	attributes = new HashMap<String, String>();
            }
            
            attributes.put(node_attr.item(0).getNodeValue(), nodes.item(i).getNodeValue());
            
        }
    }
    
    public static Map<String, Object> getDataFromXml(String rowType) {
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = null;
		try {
			builder = domFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		
        Document doc = null;
		try {
			doc = builder.parse(XMLFILE);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(doc.getXmlVersion());

        XPath xpath = XPathFactory.newInstance().newXPath();

        // XPath Query for showing all nodes value
        StringBuilder stb = new StringBuilder();
        stb.append("//table[@name=\"");
        stb.append(rowType);
        stb.append("\"]/row/*/text()");
        
        XPathExpression expr = null;
		try {
			expr = xpath.compile(stb.toString());
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Object result = null;
		try {
			result = expr.evaluate(doc, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
        	NamedNodeMap node_attr = nodes.item(i).getParentNode().getAttributes();
        	System.out.println(node_attr.item(0).getNodeValue());
            System.out.println(nodes.item(i).getNodeValue());
        }
    	
    	return dataMap;
    }
}
