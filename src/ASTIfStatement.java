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
	    		else
	    			jjtGetChild(i * 2).interpret();
	    	}
	    }
	}
}