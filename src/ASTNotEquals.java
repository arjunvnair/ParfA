public class ASTNotEquals extends SimpleNode 
{
	public ASTNotEquals(int id) 
	{
		super(id);
	}

	public ASTNotEquals(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    if (ParfANode.stack[ParfANode.p] instanceof Double) 
	    {
	    	ParfANode.stack[--ParfANode.p] = !(new Boolean(((Double) ParfANode.stack[ParfANode.p]).equals((Double) ParfANode.stack[ParfANode.p])));
	    }
	    else if (ParfANode.stack[ParfANode.p] instanceof Boolean) 
	    {
	    	ParfANode.stack[--ParfANode.p] = !(new Boolean(((Boolean) ParfANode.stack[ParfANode.p]).equals((Boolean) ParfANode.stack[ParfANode.p])));
	    }
	    else if (ParfANode.stack[ParfANode.p] instanceof String) 
	    {
	    	ParfANode.stack[--ParfANode.p] = !(new Boolean(((String) ParfANode.stack[ParfANode.p]).equals((String) ParfANode.stack[ParfANode.p])));
	    }
	}
}