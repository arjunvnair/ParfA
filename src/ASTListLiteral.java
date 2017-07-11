/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.util.ArrayList;

/**
 * Tree node for the list literal.
 * @author Arjun Nair
 */
public class ASTListLiteral extends SimpleNode 
{
	public ASTListLiteral(int id) 
	{
		super(id);
	}

	public ASTListLiteral(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i = 0; i < jjtGetNumChildren(); i++)
		{
			jjtGetChild(i).interpret();
			list.add(ParfANode.stack[ParfANode.p]);
			ParfANode.stack[ParfANode.p] = list;
		}
	}
}