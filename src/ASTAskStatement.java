/**
 * Copyright (c) 2017 Arjun Nair
 */

import consoleio.C;

/**
 * Tree node for the ask statement.
 * @author Arjun Nair
 */
public class ASTAskStatement extends SimpleNode 
{
	String name;
	String val;
	
	public ASTAskStatement(int id) 
	{
		super(id);
	}

	public ASTAskStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    C.io.print(ParfANode.stack[ParfANode.p].toString() + " ");
	    ParfANode.variables.put("answer", (C.io.nextLine()).trim());
	}
}