/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the number literal.
 * @author Arjun Nair
 */
public class ASTNumberLiteral extends SimpleNode 
{
	Double val;
	
	public ASTNumberLiteral(int id) 
	{
		super(id);
	}

	public ASTNumberLiteral(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new Double(val);
	}
}