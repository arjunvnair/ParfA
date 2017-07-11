/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the != operator.
 * @author Arjun Nair
 */
public class ASTNotEquals extends SimpleNode 
{
	public ASTNotEquals(int id) 
	{
		super(id);
	}

	public ASTNotEquals(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    String val = ParfANode.stack[ParfANode.p - 1].toString();
	    String val1 = ParfANode.stack[ParfANode.p].toString();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = Boolean.valueOf(Double.parseDouble(val) != Double.parseDouble(val1));
	    }
	    catch(NumberFormatException e)
	    {
	    	
	    	ParfANode.stack[ParfANode.p] = Boolean.valueOf(!ParfANode.stack[ParfANode.p].toString().equals(ParfANode.stack[ParfANode.p + 1].toString())); 
	    }
	}
}