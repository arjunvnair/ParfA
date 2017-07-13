import consoleio.C;

/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the * operator.
 * @author Arjun Nair
 */
public class ASTMultiply extends SimpleNode 
{
	public ASTMultiply(int id) 
	{
		super(id);
	}

	public ASTMultiply(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).doubleValue() * ((Double) ParfANode.stack[ParfANode.p + 1]).doubleValue());
	    }
	    catch(ClassCastException e)
	    {
	    	C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot multiply " + getName(ParfANode.stack[ParfANode.p + 1].getClass()) + " with " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".");
	    	throw new IllegalStateException();
	    }
	}
}