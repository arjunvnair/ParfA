public class ASTLessThan extends SimpleNode 
{
	public ASTLessThan(int id) 
	{
		super(id);
	}

	public ASTLessThan(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    ParfANode.stack[--ParfANode.p] = new Boolean(((Double) ParfANode.stack[ParfANode.p]).doubleValue() < ((Double) ParfANode.stack[ParfANode.p + 1]).doubleValue());
	}
}