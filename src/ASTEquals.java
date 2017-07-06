import java.util.ArrayList;

public class ASTEquals extends SimpleNode 
{
	public ASTEquals(int id) 
	{
		super(id);
	}

	public ASTEquals(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    if (ParfANode.stack[ParfANode.p] instanceof Double && ParfANode.stack[ParfANode.p - 1] instanceof Double) 
	    {
	    	ParfANode.stack[--ParfANode.p] = new Boolean(((Double) ParfANode.stack[ParfANode.p]).equals((Double) ParfANode.stack[ParfANode.p + 1]));
	    }
	    else if (ParfANode.stack[ParfANode.p] instanceof Boolean && ParfANode.stack[ParfANode.p - 1] instanceof Boolean) 
	    {
	    	ParfANode.stack[--ParfANode.p] = new Boolean(((Boolean) ParfANode.stack[ParfANode.p]).equals((Boolean) ParfANode.stack[ParfANode.p + 1]));
	    }
	    else if (ParfANode.stack[ParfANode.p] instanceof String && ParfANode.stack[ParfANode.p - 1] instanceof String) 
	    {
	    	ParfANode.stack[--ParfANode.p] = new Boolean(((String) ParfANode.stack[ParfANode.p]).equals((String) ParfANode.stack[ParfANode.p + 1]));
	    }
	    else if (ParfANode.stack[ParfANode.p] instanceof ArrayList<?> && ParfANode.stack[ParfANode.p - 1] instanceof ArrayList<?>) 
	    {
	    	ParfANode.stack[--ParfANode.p] = new Boolean(((ArrayList<?>) ParfANode.stack[ParfANode.p]).equals((ArrayList<?>) ParfANode.stack[ParfANode.p + 1]));
	    }
	    else
	    	throw new IllegalStateException();
	}
}