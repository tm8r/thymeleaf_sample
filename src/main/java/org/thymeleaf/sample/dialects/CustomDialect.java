package org.thymeleaf.sample.dialects;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class CustomDialect extends AbstractDialect {

	public String getPrefix() { 
		return "custom"; 
	} 

	public boolean isLenient() { 
		return false; 
	} 

	@Override 
	public Set<IProcessor> getProcessors() { 
		final Set<IProcessor> processors = new HashSet<IProcessor>(); 
		processors.add(new PrintUserAgentProcessor()); 
		return processors; 
	} 
}
