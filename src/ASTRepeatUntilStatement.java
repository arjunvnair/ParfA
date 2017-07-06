public class ASTRepeatUntilStatement extends SimpleNode 
{
	public ASTRepeatUntilStatement(int id) 
	{
		super(id);
	}

	public ASTRepeatUntilStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		try
		{
			while(true)
			{
				jjtGetChild(0).interpret();
			    if(!((Boolean) ParfANode.stack[ParfANode.p--]).booleanValue())
			    	jjtGetChild(1).interpret();
			    else 
			    	break;
			}
		}
		catch(ClassCastException e)
		{
			throw new IllegalStateException();
		}
	}
}