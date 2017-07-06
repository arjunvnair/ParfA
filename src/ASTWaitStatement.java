public class ASTWaitStatement extends SimpleNode 
{
	public ASTWaitStatement(int id) 
	{
		super(id);
	}

	public ASTWaitStatement(ParfA p, int id) 
	{
		super(p, id);
	}	

	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			Thread.sleep(1000 * (int) ((Double) ParfANode.stack[ParfANode.p--]).doubleValue());
		}
		catch(ClassCastException e)
		{
			throw new IllegalStateException();
		}
		catch(InterruptedException e)
		{
			throw new IllegalStateException();
		}
	}
}