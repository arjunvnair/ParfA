public class ASTDivide extends SimpleNode 
{
	public ASTDivide(int id) 
	{
		super(id);
	}

	public ASTDivide(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).intValue() / ((Double) ParfANode.stack[ParfANode.p + 1]).intValue());
	    }
	    catch(ClassCastException e)
	    {
	    	throw new IllegalStateException();
	    }
	}
}