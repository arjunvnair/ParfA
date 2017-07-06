import java.util.ArrayList;

public class ASTListAddStatement extends SimpleNode 
{
	public ASTListAddStatement(int id) 
	{
		super(id);
	}

	public ASTListAddStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		String identifier = ((ASTId) jjtGetChild(0)).name;
		ArrayList<Object> list = (ArrayList<Object>) ParfANode.variables.get(identifier);
		for(int i = 1; i < jjtGetNumChildren(); i++)
		{
			jjtGetChild(i).interpret();
			list.add(ParfANode.stack[ParfANode.p--]);
		}
		ParfANode.variables.put(identifier, list);
	}
}