/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

/**
 * Tree node for the lengthof operator.
 * @author Arjun Nair
 */
public class ASTLength extends SimpleNode 
{
	public ASTLength(int id) 
	{
		super(id);
	}

	public ASTLength(ParfA p, int id) 
	{
		super(p, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
		if(ParfANode.stack[ParfANode.p] instanceof ArrayList<?>)
		{
			ArrayList<Object> list = (ArrayList<Object>) ParfANode.stack[ParfANode.p];
			ParfANode.stack[ParfANode.p] = list.size();
		}
		else if(ParfANode.stack[ParfANode.p] instanceof String)
		{
			String string = (String) ParfANode.stack[ParfANode.p];
			ParfANode.stack[ParfANode.p] = string.length();
		}
		else
		{
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot call length on a " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".") ;
	    	throw new IllegalStateException();
	    }
	}
}