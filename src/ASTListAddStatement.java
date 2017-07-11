/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

/**
 * Tree node for the add statement.
 * @author Arjun Nair
 */
public class ASTListAddStatement extends SimpleNode 
{
	public ASTListAddStatement(int id) 
	{
		super(id);
	}

	public ASTListAddStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void interpret()
	{
		String identifier = ((ASTId) jjtGetChild(0)).name;
		try
		{
			ArrayList<Object> list = (ArrayList<Object>) ParfANode.variables.get(identifier);
			for(int i = 1; i < jjtGetNumChildren(); i++)
			{
				jjtGetChild(i).interpret();
				list.add(ParfANode.stack[ParfANode.p--]);
			}
			ParfANode.variables.put(identifier, list);
		}
	    catch(ClassCastException e)
	    {
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " is not a list.");
	    	throw new IllegalStateException();
	    }
	}
}