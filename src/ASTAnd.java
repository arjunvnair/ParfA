/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the && operator.
 * @author Arjun Nair
 */
public class ASTAnd extends SimpleNode 
{
	public ASTAnd(int id) 
	{
		super(id);
	}

	public ASTAnd(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			if (!((Boolean) ParfANode.stack[ParfANode.p]).booleanValue()) 
			{
				ParfANode.stack[ParfANode.p] = new Boolean(false);
				return;
			}
			jjtGetChild(1).interpret();
			ParfANode.stack[--ParfANode.p] = new Boolean(((Boolean) ParfANode.stack[ParfANode.p]).booleanValue() &&((Boolean) ParfANode.stack[ParfANode.p + 1]).booleanValue());
		}
		catch(ClassCastException e)
		{
			System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot use and operator with non-logic values.");
	    	throw new IllegalStateException();
		}
	}
}