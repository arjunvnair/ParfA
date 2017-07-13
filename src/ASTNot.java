import consoleio.C;

/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the not operator.
 * @author Arjun Nair
 */
public class ASTNot extends SimpleNode 
{
	public ASTNot(int id) 
	{
		super(id);
	}

	public ASTNot(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    try
	    {
	    	ParfANode.stack[ParfANode.p] = !((Boolean) ParfANode.stack[ParfANode.p]);
	    }
	    catch(ClassCastException e)
	    {
	    	C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", can only use the not operator on a logic expression.");
	    	throw new IllegalStateException();
	    }
	}
}