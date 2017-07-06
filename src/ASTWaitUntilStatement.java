public class ASTWaitUntilStatement extends SimpleNode 
{
	public ASTWaitUntilStatement(int id) 
	{
		super(id);
	}

	public ASTWaitUntilStatement(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		try
		{
			do
			{
				jjtGetChild(0).interpret();
			}
			while(!((Boolean) ParfANode.stack[ParfANode.p--]).booleanValue());
		}
		catch(ClassCastException e)
		{
			throw new IllegalStateException();
		}
	}
}