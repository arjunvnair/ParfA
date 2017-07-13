/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

import consoleio.C;

/**
 * Tree node for the variable assign statement.
 * @author Arjun Nair
 */
public class ASTVariableAssignStatement extends SimpleNode 
{
	public ASTVariableAssignStatement(int id) 
    {
		super(id);
    }

    public ASTVariableAssignStatement(ParfA p, int id)
    {
    	super(p, id);
    }

    @Override
    public void interpret()
    {
    	jjtGetChild(1).interpret();
		Object val = ParfANode.stack[ParfANode.p--];
		String identifier = ((ASTId) jjtGetChild(0)).name;
		Class<?> c;
		try
		{
			c = ParfANode.variables.get(identifier).getClass();
		}
		catch(NullPointerException e)
		{
			C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " was never declared.");
			throw new IllegalStateException();
		}
		if(c.equals(Double.class))
			if(val.getClass().equals(String.class))
				try
				{
					val = Double.parseDouble((String) val);
				}
				catch(NumberFormatException e)
				{
					val = new Double(0.0);
				}
			else if(!val.getClass().equals(Double.class))
			{
				C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " is a " + getName(c) + " and cannot store a " + getName(val.getClass()) + ".");
				throw new IllegalStateException();
			}
		else if(c.equals(String.class))
			val = val.toString();
		else if(c.equals(Boolean.class) | c.equals(ArrayList.class))
			if(!c.equals(val.getClass()))
			{
				C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " is a " + getName(c) + " and cannot store a " + getName(val.getClass()) + ".");
				throw new IllegalStateException();
			}
		else
		{
			C.io.println("A fatal exception occurred when processing line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", try running the program again.");
			throw new IllegalStateException();
		}
    	ParfANode.variables.put(identifier, val);
    }
}