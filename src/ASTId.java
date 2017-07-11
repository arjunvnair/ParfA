/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the identifier field.
 * @author Arjun Nair
 */
public class ASTId extends SimpleNode 
{
	String name;
	
	public ASTId(int id) 
	{
		super(id);
	}

	public ASTId(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = ParfANode.variables.get(name);
	}
}