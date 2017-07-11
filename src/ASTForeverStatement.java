/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the forever statement.
 * @author Arjun Nair
 */
public class ASTForeverStatement extends SimpleNode 
{
	public ASTForeverStatement(int id) 
	{
		super(id);
	}

	public ASTForeverStatement(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		while(true)
			jjtGetChild(0).interpret();
	}
}