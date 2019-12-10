package com.stpl.pms.struts.common;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.module.sitemesh.Decorator;
import com.opensymphony.module.sitemesh.DecoratorMapper;
import com.opensymphony.module.sitemesh.Page;
import com.opensymphony.module.sitemesh.mapper.AbstractDecoratorMapper;

public class SessionDecoratorMapper extends AbstractDecoratorMapper {

	private String decoratorParameter = null;

	public void init(Config config, Properties properties,
			DecoratorMapper parent) throws InstantiationException {
		super.init(config, properties, parent);
		decoratorParameter = properties.getProperty("decorator.parameter",
				"decorator");
	}

	public Decorator getDecorator(HttpServletRequest request, Page page) {
		Decorator result = null;
		String decorator = (String) request.getSession().getAttribute(
				decoratorParameter);
		request.getSession().removeAttribute(decoratorParameter);
		// get decorator from HttpSession
		if (decorator != null) {
			result = getNamedDecorator(request, decorator);
		}
		return result == null ? super.getDecorator(request, page) : result;
	}

}
