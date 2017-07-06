public class ASTNot extends SimpleNode 
{
	public ASTNot(int id) 
	{
		super(id);
	}

	public ASTNot(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    try
	    {
	    	ParfANode.stack[ParfANode.p] = new Boolean(!((Boolean) ParfANode.stack[ParfANode.p]).booleanValue());
	    }
	    catch(IllegalStateException e)
	    {
	    	e.printStackTrace();
	    }
	}
}