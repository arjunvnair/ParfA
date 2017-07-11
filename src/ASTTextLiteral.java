/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the text literal.
 * @author Arjun Nair
 */
public class ASTTextLiteral extends SimpleNode 
{
	String val;
	
	public ASTTextLiteral(int id) 
	{
		super(id);
	}

	public ASTTextLiteral(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new String(val);
	}
}