package com.stpl.pms.utility;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.digester.Digester;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XmlUtil {
//	private static final Logger log=Logger.getLogger(XmlUtil.class);
	private static String xmlString(Document dom) {
		String xml = null;
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);
			Source source = new DOMSource(dom);
			transformer.transform(source, result);
			writer.close();
			xml = writer.toString();
		} catch (TransformerException ie) {
			ie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xml;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void createXmlNode(Document dom, Object obj,
			Class className, Element headElement, Package beanPackage)
			throws IntrospectionException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		BeanInfo info = Introspector.getBeanInfo(className);
		Element element = null;
		for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
			if (!"class".equals(pd.getName())) {
				if (beanPackage.equals(pd.getPropertyType().getPackage())) {
					Object ob = pd.getReadMethod().invoke(obj, (Object[]) null);
					if (ob != null) {
						element = dom.createElement(pd.getName());
						headElement.appendChild(element);
						createXmlNode(dom, ob, pd.getPropertyType(), element,
								beanPackage);
					}
				} else if (pd.getPropertyType().toString().indexOf(
						"java.util.List") != -1) {
					List<Object> list = (List<Object>) pd.getReadMethod()
							.invoke(obj, (Object[]) null);
					if (list != null) {
						for (Iterator<Object> iterator = list.iterator(); iterator
								.hasNext();) {
							Object object = (Object) iterator.next();
							element = dom.createElement(pd.getName());
							headElement.appendChild(element);
							if (object instanceof String || object instanceof Integer || object instanceof Double ) {
								Text authText = dom.createTextNode(String
										.valueOf(object));
								element.appendChild(authText);
							} else
								createXmlNode(dom, object, object.getClass(),
										element, beanPackage);
						}
					}
				} else {
					if("stackTrace".equals(pd.getName()) || "suppressed".equals(pd.getName()))
						continue;
					
					Object ob = pd.getReadMethod().invoke(obj, (Object[]) null);
					if (ob != null && ob != (Object) 0) {
						Text authText = dom.createTextNode(String.valueOf(ob));
						element = dom.createElement(pd.getName());
						element.appendChild(authText);
						headElement.appendChild(element);
					}
				}

			}
		}
	}

	
	@SuppressWarnings("rawtypes")
	private static void parseXML(Digester digester, String header,
			Class className, Package beanPackage)
			throws IntrospectionException, SecurityException,
			NoSuchFieldException {
		BeanInfo info = Introspector.getBeanInfo(className);
		for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
			if (!"class".equals(pd.getName())) {
				if (beanPackage.equals(pd.getPropertyType().getPackage())) {
					digester.addObjectCreate(header + "/" + pd.getName(), pd.getPropertyType());
					digester.addSetNext(header + "/" + pd.getName(), pd.getWriteMethod().getName());
//					log.info("digester.addObjectCreate(\""+header + "/" + pd.getName()+"\","+pd.getPropertyType()+");");
//					log.info("digester.addSetNext(\""+header + "/" + pd.getName()+"\",\""+pd.getWriteMethod().getName()+"\");");
					parseXML(digester, header + "/" + pd.getName(), pd
							.getPropertyType(), beanPackage);
				} else if (pd.getPropertyType().toString().indexOf(
						"java.util.List") != -1) {
					Field field = className.getDeclaredField(pd.getName());
					ParameterizedType pt = (ParameterizedType) field
							.getGenericType();
					Class clazz = (Class) pt.getActualTypeArguments()[0];
					Class[] clazzArr={clazz};
					if(clazz.toString().contains("java.lang")){
						digester.addCallMethod(header + "/" + pd.getName(), pd.getWriteMethod().getName(), 1,clazzArr);
						digester.addCallParam(header + "/" + pd.getName(), 0);
//						log.info("digester.addCallMethod(\""+header + "/" + pd.getName()+"\",\""+ pd.getWriteMethod().getName()+"\",1,"+clazzArr+");");
//						log.info("digester.addCallParam(\""+header + "/" + pd.getName()+"\", 0);");
					}else{
						digester.addObjectCreate(header + "/" + pd.getName(), clazz);
						digester.addSetNext(header + "/" + pd.getName(), pd.getWriteMethod().getName());
//						log.info("digester.addObjectCreate(\""+header + "/" + pd.getName()+"\","+ clazz+");");
//						log.info("digester.addSetNext(\""+header + "/" + pd.getName()+"\", \""+pd.getWriteMethod().getName()+"\");");
						parseXML(digester, header + "/" + pd.getName(), clazz,beanPackage);
					}
				} else {
					String pattern=header + "/" + pd.getName();
					int length=("/" + pd.getName()).length();
					String sub=header.substring(header.length()-length);
					if(sub.equals("/"+pd.getName())){
						pattern=header;
					}
					digester.addBeanPropertySetter(pattern,pd.getName());
//					log.info("digester.addBeanPropertySetter(\""+pattern + "\",\""+ pd.getName()+"\");");
				}

			}
		}
	}

	@SuppressWarnings({"rawtypes" })
	public static Object reader(String headerNode, Class className,
			String xmlString, Package beanPackage) {
		Object obj = null;
		Digester digester = new Digester();
		digester.addObjectCreate(headerNode, className);
//		log.info("digester.addObjectCreate(\""+headerNode + "\","+ className+");");
		try {
			parseXML(digester, headerNode, className, beanPackage);
			obj = digester
					.parse(new ByteArrayInputStream(xmlString.getBytes()));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("rawtypes")
	public static String writer(String headerNode, Object obj, Class className,
			Package beanPackage) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		String xmlString = null;
		try {
			db = dbf.newDocumentBuilder();
			Document dom = db.newDocument();
			Element element = dom.createElement(headerNode);
			dom.appendChild(element);
			createXmlNode(dom, obj, className, element, beanPackage);
			xmlString = xmlString(dom);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return xmlString;
	}
}
