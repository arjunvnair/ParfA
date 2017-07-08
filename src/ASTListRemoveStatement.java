import java.util.ArrayList;

public class ASTListRemoveStatement extends SimpleNode 
{
	public ASTListRemoveStatement(int id) 
	{
		super(id);
	}

	public ASTListRemoveStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void interpret()
	{
		String identifier = ((ASTId) jjtGetChild(0)).name;
		try
		{
			ArrayList<Object> list = (ArrayList<Object>) ParfANode.variables.get(identifier);
			for(int i = 1; i < jjtGetNumChildren(); i++)
			{
				jjtGetChild(i).interpret();
				list.remove(ParfANode.stack[ParfANode.p--]);
			}
			ParfANode.variables.put(identifier, list);
		}
	    catch(ClassCastException e)
	    {
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " is not a list.");
	    	throw new IllegalStateException();
	    }
	}
}