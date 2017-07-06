public class ASTNumberLiteral extends SimpleNode 
{
	Double val;
	
	public ASTNumberLiteral(int id) 
	{
		super(id);
	}

	public ASTNumberLiteral(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new Double(val);
	}
}