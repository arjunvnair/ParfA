import consoleio.C;

/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the answer field.
 * @author Arjun Nair
 */
public class ASTAnswer extends SimpleNode 
{
	public ASTAnswer(int id) 
	{
		super(id);
	}

	public ASTAnswer(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		if(ParfANode.variables.get("answer") != null)
			ParfANode.stack[++ParfANode.p] = ParfANode.variables.get("answer");
		else
		{
	    	C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", ask the user for input before trying to retrieve an answer.");
	    	throw new IllegalStateException();
	    }
	}
}