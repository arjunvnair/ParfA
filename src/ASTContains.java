import java.util.ArrayList;

public class ASTContains extends SimpleNode 
{
	public ASTContains(int id) 
	{
		super(id);
	}

	public ASTContains(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		try
		{
			jjtGetChild(0).interpret();
			ArrayList<Object> list = (ArrayList<Object>) ParfANode.stack[ParfANode.p];
			jjtGetChild(1).interpret();
			ParfANode.stack[--ParfANode.p] = new Boolean(list.contains(ParfANode.stack[ParfANode.p + 1]));		
		}
		catch(ClassCastException e)
		{
			throw new IllegalStateException();
		}
	}
}