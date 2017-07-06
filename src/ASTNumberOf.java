import java.util.ArrayList;

public class ASTNumberOf extends SimpleNode 
{
	public ASTNumberOf(int id) 
	{
		super(id);
	}

	public ASTNumberOf(ParfA p, int id) 
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
			int num = 0;
			for(Object o : list)
				if(o.equals(ParfANode.stack[p]))
					num++;
			ParfANode.stack[--ParfANode.p] = new Double(num);
		}
		catch(ClassCastException e)
		{
			throw new IllegalStateException();
		}
	}
}