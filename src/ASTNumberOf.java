/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

import consoleio.C;

/**
 * Tree node for the numberof operator.
 * @author Arjun Nair
 */
public class ASTNumberOf extends SimpleNode 
{
	public ASTNumberOf(int id) 
	{
		super(id);
	}

	public ASTNumberOf(ParfA p, int id) 
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
			int num = 0;
			for(Object o : list)
				if(o.equals(ParfANode.stack[p]))
					num++;
			ParfANode.stack[--ParfANode.p] = new Double(num);
		}
		catch(ClassCastException e)
		{
	    	C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot call numberof on a " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".") ;
	    	throw new IllegalStateException();
	    }
	}
}