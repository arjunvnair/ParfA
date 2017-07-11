/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the block structure.
 * @author Arjun Nair
 */
public class ASTBlock extends SimpleNode 
{
	public ASTBlock(int id) 
	{
		super(id);
	}

	public ASTBlock(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		for (int i = 0; i < jjtGetNumChildren(); i++)
			jjtGetChild(i).interpret();
	}
}