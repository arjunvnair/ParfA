public class ASTModulus extends SimpleNode 
{
	public ASTModulus(int id) 
	{
		super(id);
	}

	public ASTModulus(ParfA p, int id) 
	{
		super(p, id);
	}
	
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).doubleValue() % ((Double) ParfANode.stack[ParfANode.p + 1]).doubleValue());
	    }
	    catch(ClassCastException e)
	    {
	    	throw new IllegalStateException();
	    }
	}
}