package org.thymeleaf.sample.dialects;

import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.StandardExpressionProcessor;

public class PrintUserAgentProcessor extends AbstractTextChildModifierAttrProcessor {

	public PrintUserAgentProcessor() { 
		super("printua"); 
	} 

	public int getPrecedence() { 
		return 10000; 
	} 
	@Override 
	protected String getText(final Arguments arguments, final Element element,  
			final String attributeName) { 
		String attributeValue = element.getAttributeValue(attributeName);
		Object result = StandardExpressionProcessor.processExpression(arguments, attributeValue);
		HttpServletRequest req = null;
		if (result == null) {
			return null;
		}
		req = (HttpServletRequest)result;
		
		return req.getHeader("user-agent"); 

	} 
}
