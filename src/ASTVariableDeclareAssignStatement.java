/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

/**
 * Tree node for the variable declare and assign statement.
 * @author Arjun Nair
 */
public class ASTVariableDeclareAssignStatement extends SimpleNode 
{
	int type;
	String name;
	
	public ASTVariableDeclareAssignStatement(int id) 
	{
		super(id);
	}

	public ASTVariableDeclareAssignStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
		Object val = ParfANode.stack[ParfANode.p--];
		Class<?> c;
		if(type == ParfAConstants.NUMBER)
		{
			c = Double.class;
			if(val.getClass().equals(String.class))
				try
				{
					val = Double.parseDouble((String) val);
				}
				catch(NumberFormatException e)
				{
					val = new Double(0.0);
				}
		}
		else if(type == ParfAConstants.LOGIC)
			c = Boolean.class;
		else if(type == ParfAConstants.TEXT)
		{
			c = String.class;
			val = val.toString();
		}
		else if(type == ParfAConstants.LIST)
			c = ArrayList.class;
		else
		{
			System.err.println("A fatal exception occurred when processing line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", try running the program again.");
			throw new IllegalStateException();
		}
		if(!(val.getClass().equals(c)))
		{
			System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + name + " is a " + getName(c) + " and cannot store a " + getName(val.getClass()) + ".");
			throw new IllegalStateException();
		}
    	ParfANode.variables.put(name, val);
	}
}