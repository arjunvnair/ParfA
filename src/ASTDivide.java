/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the / operator.
 * @author Arjun Nair
 */
public class ASTDivide extends SimpleNode 
{
	public ASTDivide(int id) 
	{
		super(id);
	}

	public ASTDivide(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).doubleValue() / ((Double) ParfANode.stack[ParfANode.p + 1]).intValue());
	    }
	    catch(ClassCastException e)
	    {
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot divide " + getName(ParfANode.stack[ParfANode.p + 1].getClass()) + " with " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".");
	    	throw new IllegalStateException();
	    }
	}
}