/**
 * Copyright (c) 2017 Arjun Nair
 */

/**
 * Tree node for wait statement.
 * @author Arjun Nair
 */
public class ASTWaitStatement extends SimpleNode 
{
	public ASTWaitStatement(int id) 
	{
		super(id);
	}

	public ASTWaitStatement(ParfA p, int id) 
	{
		super(p, id);
	}	

	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			Thread.sleep(1000 * (int) ((Double) ParfANode.stack[ParfANode.p--]).doubleValue());
		}
    	catch(ClassCastException e)
    	{
    		System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", wait time must be a numeric expression.");
    		throw new IllegalStateException();
    	}
		catch(InterruptedException e)
		{
			System.err.println("A fatal exception occurred when processing line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", try running the program again.");
    		throw new IllegalStateException();
		}
	}
}