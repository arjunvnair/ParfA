/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the logic literal.
 * @author Arjun Nair
 */
public class ASTLogicLiteral extends SimpleNode 
{
	Boolean val;
	
	public ASTLogicLiteral(int id) 
	{
		super(id);
	}

	public ASTLogicLiteral(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new Boolean(val);
	}
}