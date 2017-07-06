public class ASTMultiply extends SimpleNode 
{
	public ASTMultiply(int id) 
	{
		super(id);
	}

	public ASTMultiply(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).doubleValue() * ((Double) ParfANode.stack[ParfANode.p + 1]).doubleValue());
	    }
	    catch(ClassCastException e)
	    {
	    	throw new IllegalStateException();
	    }
	}
}