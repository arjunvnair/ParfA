/**
 * Copyright (c) 2017 Arjun Nair
 */

import consoleio.C;

/**
 * Tree node for the announce statement.
 * @author Arjun Nair
 */
public class ASTAnnounceStatement extends SimpleNode 
{
	public ASTAnnounceStatement(int id) 	
	{
		super(id);
	}

	public ASTAnnounceStatement(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			C.io.print(ParfANode.stack[ParfANode.p--].toString() + "\n");
		}
		catch(NullPointerException e)
		{
			C.io.println("A fatal exception occurred when processing line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", try running the program again.");
			throw new IllegalStateException();
		}
	}
}