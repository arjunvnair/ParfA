public class ASTId extends SimpleNode 
{
	String name;
	
	public ASTId(int id) 
	{
		super(id);
	}

	public ASTId(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = ParfANode.variables.get(name);
	}
}