/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for the if statement.
 * @author Arjun Nair
 */
public class ASTIfStatement extends SimpleNode 
{
	int elseIfCount;
	
	public ASTIfStatement(int id) 
	{
		super(id);
	}

	public ASTIfStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			if (((Boolean) ParfANode.stack[ParfANode.p--]).booleanValue())
				jjtGetChild(1).interpret();
			else
			{
				for(int i = 1; i <= elseIfCount + 1; i++)
				{
					if(i <= elseIfCount)
					{
						jjtGetChild(i * 2).interpret();
						if (((Boolean) ParfANode.stack[ParfANode.p--]).booleanValue())
						{
							jjtGetChild(i * 2 + 1).interpret();
							break;
						}
					}
					else if(jjtGetNumChildren() == i * 2 + 1)
						jjtGetChild(i * 2).interpret();
				}
			}
		}
	    catch(ClassCastException e)
	    {
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", if conditions must be logic expressions.");
	    	throw new IllegalStateException();
	    }
	}
}