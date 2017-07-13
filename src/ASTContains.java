/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

import consoleio.C;

/**
 * Tree node for the contains operator.
 * @author Arjun Nair
 */
public class ASTContains extends SimpleNode 
{
	public ASTContains(int id) 
	{
		super(id);
	}

	public ASTContains(ParfA p, int id) 
	{
		super(p, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			ArrayList<Object> list = (ArrayList<Object>) ParfANode.stack[ParfANode.p];
			jjtGetChild(1).interpret();
			ParfANode.stack[--ParfANode.p] = new Boolean(list.contains(ParfANode.stack[ParfANode.p + 1]));		
		}
		catch(ClassCastException e)
		{
	    	C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot call contains on a " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".") ;
	    	throw new IllegalStateException();
	    }
	}
}