package com.stpl.pms.utility;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

public class DigesterUtils {
	protected static Log log = LogFactory.getLog(DigesterUtils.class);
	/**				
	 * Turns an XML with repeatable sections into a list of Mapped objects				
	 * @param xml Working on				
	 * @param itemsOfInterest XPath based elements (response/header/name or response/header/name@type)				
	 * @param repeatElement The pattern for the element that signals a repeat - e.g. /record				
	 * @return A list of map where the map is keyed on the pattern in the elementsOfInterest and the value is the value				
	 * If not found then the key will be missing from the map				
	 * @throws IOException				
	 * @throws SAXException				
	 */				
	public static List<Map<String, String>> xmlToMap(InputStream xml,				
			Collection<String> itemsOfInterest, String repeatElement, boolean namespaceAware)		
			throws IOException, SAXException {		
		log.info("Digesting with " + itemsOfInterest.size() + " items from xml repeating in [" + repeatElement + "]");			
					
					
		List<Map<String, String>> records = new LinkedList<Map<String, String>>();			
		Digester digester = new Digester();			
		digester.setNamespaceAware(namespaceAware);			
		digester.push(records);			
					
		// create the object			
		digester.addObjectCreate(repeatElement, HashMap.class);			
					
		for (String item : itemsOfInterest) {			
			// depending on whether it has an attribute or not		
			if (item.contains("@")) {		
				String[] parts = item.split("@");	
				addParam(digester, parts[0], parts[1]);	
			} else {		
				addParam(digester, item);	
			}		
		}			
		digester.addSetNext(repeatElement, "add");			
					
		digester.parse(xml);			
		return records;			
	}				
					
	/**				
	 * Turns an XML with repeatable elements into a List<String>				
	 * @param xml Working on				
	 * @param itemsOfInterest XPath based elements (/response/records/item)				
	 * @return A list of String 				
	 * @throws IOException				
	 * @throws SAXException				
	 */				
	public static List<String> xmlToList(InputStream xml,				
			String itemsOfInterest, boolean namespaceAware)		
			throws IOException, SAXException {		
		log.info("Digesting [" + itemsOfInterest + "] from xml");			
					
		List<String> records = new LinkedList<String>();			
		Digester digester = new Digester();			
		digester.setNamespaceAware(namespaceAware);			
		digester.push(records);			
		digester.addCallMethod(itemsOfInterest, "add", 1);			
		digester.addCallParam(itemsOfInterest, 0);			
		digester.parse(xml);			
		return records;			
	}				
					
	/**				
	 * Defaults to namespace aware				
	 * @see DigesterUtils.xmlToMap(InputStream, List, String)				
	 */				
	public static List<Map<String, String>> xmlToMap(InputStream xml,				
			Collection<String> itemsOfInterest, String repeatElement)		
			throws IOException, SAXException {		
		return xmlToMap(xml,itemsOfInterest, repeatElement, true);			
	}				
					
	/**				
	 * Defaults to namespace aware				
	 * @see DigesterUtils.xmlToMap(InputStream, List, String)				
	 */				
	public static List<String> xmlToList(String xml,				
			String itemsOfInterest)		
			throws IOException, SAXException {
		InputStream is=new ByteArrayInputStream(xml.getBytes());
		return xmlToList(is,itemsOfInterest, true);			
	}				
					
	/**				
	 * @see DigesterUtils.xmlToMap(InputStream, List, String)				
	 */				
	public static List<Map<String, String>> xmlToMap(String xml, List<String> itemsOfInterest, String repeatElement, boolean namespaceAware) throws IOException, SAXException {				
		return xmlToMap(new ByteArrayInputStream(xml.getBytes("UTF-8")), itemsOfInterest, repeatElement, namespaceAware);			
	}				
					
	/**				
	 * Defaults to namespace aware				
	 * @see DigesterUtils.xmlToMap(InputStream, List, String)				
	 */				
	public static List<Map<String, String>> xmlToMap(String xml, List<String> itemsOfInterest, String repeatElement) throws IOException, SAXException {				
		return xmlToMap(new ByteArrayInputStream(xml.getBytes("UTF-8")), itemsOfInterest, repeatElement, true);			
	}				
					
	/**				
	 * @param digester 				
	 * @param pattern That is the key for the map, and the element for the map value				
	 */				
	protected static void addParam(Digester digester, String pattern) {				
		digester.addCallMethod(pattern, "put", 2);			
		digester.addObjectParam(pattern, 0, pattern);			
		digester.addCallParam(pattern, 1);			
	}				
					
	/**				
	 * @param digester				
	 * @param pattern That is the key for the map, and the element to get the attribute from 				
	 * @param attribute The attribute goes into the map value				
	 */				
	protected static void addParam(Digester digester, String pattern,				
			String attribute) {		
		digester.addCallMethod(pattern, "put", 2);			
		digester.addObjectParam(pattern, 0, pattern + "@" + attribute);			
		digester.addCallParam(pattern, 1, attribute);			
	}				
					
	/**				
	 * Iterates over the input Map, and parses the xml using the Map's values which must				
	 * represent "XPaths" (commons digester style). 				
	 * 				
	 * A new Map is returned, populated with map entries that correspond to the input Map				
	 * in the sense that they contain the same key, and the value parsed for the given "XPath"				
	 * in place of the path itself.				
	 * 				
	 * Where no value results following parsing for some "XPath", no map entry is written in the 				
	 * new Map.				
	 * 				
	 * @param xml working on				
	 * @param map containing name/"XPath" entries				
	 * @return map containing name/value entries				
	 * @throws IOException				
	 * @throws SAXException				
	 */				
	public static Map<String, String> parseElementsOfInterest(InputStream xml, Map<String, String> map)				
	throws IOException, SAXException {				
					
		Map<String, String> records = new HashMap<String, String>();			
		Digester digester = new Digester();			
		digester.setNamespaceAware(true);			
		digester.push(records);			
					
		for (Map.Entry<String, String> entry: map.entrySet())	{		
			String key= entry.getKey();		
			String item= entry.getValue();		
					
			// depending on whether it has an attribute or not		
			if (item.contains("@")) {		
				String[] parts = item.split("@");	
				digester.addCallMethod(parts[0], "put", 2);	
				digester.addObjectParam(parts[0], 0, key);	
				digester.addCallParam(parts[0], 1, parts[1]);	
			} else {		
				digester.addCallMethod(item, "put", 2);	
				digester.addObjectParam(item, 0, key);	
				digester.addCallParam(item, 1);	
			}		
		}			
					
		digester.parse(xml);			
					
		return records;			
	}				
					
	/**				
	 * 				
	 * Parses the XML for the itemOfInterest (element's XPath), adding a new Map entry for				
	 * each element: key = attribute value, value = element value				
	 * 				
	 * Used where there are several elements sharing the same element name and attribute name.				
	 * 				
	 * Example: 				
	 * 				
	 * <diagnostic code="STATUS_INTERVAL" severity="info">3600</diagnostic>				
	 * <diagnostic code="STATUS_DATA" severity="info">7</diagnostic>				
	 * 				
	 * In this case, the attribute is "code" and the itemOfInterest is "/diagnostic"				
	 * and the result is 2 Map.Entry: <"STATUS_INTERVAL", 3600> and <"STATUS_DATA", "7">				
	 * 				
	 * @param xml				
	 * @param itemOfInterest XPath based elements (/response/records/item)				
	 * @param attribute name				
	 * @return Map with attribute value, element value pairs				
	 * @throws IOException				
	 * @throws SAXException				
	 */				
	public static Map<String, String> xmlToMapForSingleElement(InputStream xml,				
			String itemOfInterest, String attribute) throws IOException,		
			SAXException {		
					
		Map<String, String> records = new HashMap<String, String>();			
		Digester digester = new Digester();			
		digester.setNamespaceAware(true);			
		digester.push(records);			
					
		digester.addCallMethod(itemOfInterest, "put", 2);			
		digester.addCallParam(itemOfInterest, 1);			
		digester.addCallParam(itemOfInterest, 0, attribute);			
					
		digester.parse(xml);			
					
		return records;			
	}				
					
	/**				
	 * Parses the XML for the itemOfInterest (element's XPath), adding a new String 				
	 * to a set for its attribute's value.				
	 * 				
	 * Used where there are several elements with the same elemnt name and attribute name.				
	 * @param xml				
	 * @param itemOfInterest				
	 * @param attribute name				
	 * @return set of attribute values				
	 * @throws IOException				
	 * @throws SAXException				
	 */				
	public static Set<String> xmlToListOfAttributeValuesForSingleElement(InputStream xml, String itemOfInterest, String attribute)				
	throws IOException, SAXException {				
					
		Map<String, String> records = new HashMap<String, String>();			
		Digester digester = new Digester();			
		digester.setNamespaceAware(true);			
		digester.push(records);			
					
		digester.addCallMethod(itemOfInterest, "put", 2);			
		digester.addCallParam(itemOfInterest, 1);			
		digester.addCallParam(itemOfInterest, 0, attribute);			
		digester.parse(xml);			
					
		return records.keySet();			
	}				
}
