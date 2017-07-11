/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the - operator.
 * @author Arjun Nair
 */
public class ASTSubtract extends SimpleNode 
{
	public ASTSubtract(int id) 
	{
		super(id);
	}

	public ASTSubtract(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	if(ParfANode.stack[ParfANode.p] instanceof String)
	    		try
	    		{
	    			ParfANode.stack[ParfANode.p] = Double.parseDouble((String) ParfANode.stack[ParfANode.p]);
	    		}
	    		catch(NumberFormatException e)
	    		{
	    			ParfANode.stack[ParfANode.p] = 0;
	    		}
	    	ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).doubleValue() - ((Double) ParfANode.stack[ParfANode.p + 1]).doubleValue());
	    }
	    catch(ClassCastException e)
	    {
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot subtract " + getName(ParfANode.stack[ParfANode.p + 1].getClass()) + " from " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".");
	    	throw new IllegalStateException();
	    }
	}
}