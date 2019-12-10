package com.stpl.pms.utility;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.stpl.pms.controller.gl.GameLobbyController;

/**
 * Filters Http requests and removes malicious characters/strings
 * (i.e. XSS) from the Query String
 */
public class XSSFilter implements Filter {	
	
	static class XSSRequestWrapper extends HttpServletRequestWrapper {
		static boolean xssFlag=false;
		private Map<String, String[]> sanitizedQueryString;
		
		public XSSRequestWrapper(HttpServletRequest request) {
			super(request);
		}
		
		//QueryString overrides
		
		@Override
		public String getParameter(String name) {
			String parameter = null;
			String[] vals = getParameterMap().get(name); 
			
			if (vals != null && vals.length > 0) {
				parameter = vals[0];
			}
			
			return parameter;
		}

		@Override
		public String[] getParameterValues(String name) {
			return getParameterMap().get(name);
		}
		
		@Override
		public Enumeration<String> getParameterNames() {
			return Collections.enumeration(getParameterMap().keySet());
		}

		@SuppressWarnings("unchecked")
		@Override
		public Map<String,String[]> getParameterMap() {
			if(sanitizedQueryString == null) {
				Map<String, String[]> res = new HashMap<String, String[]>();
				Map<String, String[]> originalQueryString = super.getParameterMap();
				if(originalQueryString!=null) {
					for (String key : (Set<String>) originalQueryString.keySet()) {
						String[] rawVals = originalQueryString.get(key);
						String[] snzVals = new String[rawVals.length];
						for (int i=0; i < rawVals.length; i++) {
							snzVals[i] = stripXSS(rawVals[i]);							
						}
						res.put(stripXSS(key), snzVals);
					}
				}
				sanitizedQueryString = res;
			}
			return sanitizedQueryString;
		}

		//TODO: Implement support for headers and cookies (override getHeaders and getCookies)
		
		/**
		 * Removes all the potentially malicious characters from a string
		 * @param value the raw string
		 * @return the sanitized string
		 */
		private String stripXSS(String value) {
			String cleanValue = null;
			if (value != null) {
				cleanValue = Normalizer.normalize(value, Normalizer.Form.NFD);

				// Avoid null characters
				cleanValue = cleanValue.replaceAll("\0", "");
				
				// Avoid anything between script tags
				Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
		 
				// Avoid anything in a src='...' type of expression
				scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;

				scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
				
				// Remove any lonesome </script> tag
				scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;

				// Remove any lonesome <script ...> tag
				scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;

				// Avoid eval(...) expressions
				scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
				
				// Avoid expression(...) expressions
				scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
				
				// Avoid javascript:... expressions
				scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
				
				// Avoid vbscript:... expressions
				scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
				
				// Avoid onload= expressions
				scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				if(scriptPattern.matcher(cleanValue).find())
					xssFlag=true;
			}
			return cleanValue;
		}
	}

	public void destroy() {
		System.out.println("XSSFilter: destroy()");
	}

         
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {	
	XSSRequestWrapper.xssFlag=false;
	
	XSSRequestWrapper wrapper = new XSSRequestWrapper((HttpServletRequest)request);
	if(!((HttpServletRequest)request).getServletPath().contains("cms"))
		wrapper.getParameterMap();
	
		if(!XSSRequestWrapper.xssFlag)
			chain.doFilter(request, response); 
		else{ 
			 HttpServletResponse httpResponse = (HttpServletResponse) response;
			 httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			 httpResponse.sendError(404);
		}
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("XSSFilter: init()");
		try{
			GameLobbyController gameLobbyController = new GameLobbyController();
			gameLobbyController.changeInProgressStatus();
			
		}catch(Exception e){e.printStackTrace();}
	}
}