import consoleio.C;

/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the or operator.
 * @author Arjun Nair
 */
public class ASTOr extends SimpleNode 
{
	public ASTOr(int id) 
	{
		super(id);
	}
	
	public ASTOr(ParfA p, int id)
	{
		super(p, id);
	}

	@Override
	public void interpret() 
	{
		try
		{
			jjtGetChild(0).interpret();
			if (((Boolean) ParfANode.stack[ParfANode.p]).booleanValue()) 
			{
				ParfANode.stack[ParfANode.p] = new Boolean(true);
				return;
			}
			jjtGetChild(1).interpret();
			ParfANode.stack[--ParfANode.p] = new Boolean(((Boolean) ParfANode.stack[ParfANode.p]).booleanValue() || ((Boolean) ParfANode.stack[ParfANode.p + 1]).booleanValue());
		}
		catch(ClassCastException e)
		{
			C.io.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot use or operator with non-logic values.");
	    	throw new IllegalStateException();
		}
  }
}