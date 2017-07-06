public class ASTAnd extends SimpleNode 
{
	public ASTAnd(int id) 
	{
		super(id);
	}

	public ASTAnd(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
		if (!((Boolean) ParfANode.stack[ParfANode.p]).booleanValue()) 
		{
			ParfANode.stack[ParfANode.p] = new Boolean(false);
			return;
	    }
		jjtGetChild(1).interpret();
		ParfANode.stack[--ParfANode.p] = new Boolean(((Boolean) ParfANode.stack[ParfANode.p]).booleanValue() &&((Boolean) ParfANode.stack[ParfANode.p + 1]).booleanValue());
	}
}