public class ASTAnswer extends SimpleNode 
{
	public ASTAnswer(int id) 
	{
		super(id);
	}

	public ASTAnswer(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		if(ParfANode.variables.get("answer") != null)
			ParfANode.stack[++ParfANode.p] = ParfANode.variables.get("answer");
		else
			throw new IllegalStateException();
	}
}