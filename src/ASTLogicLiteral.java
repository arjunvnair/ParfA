public class ASTLogicLiteral extends SimpleNode 
{
	Boolean val;
	
	public ASTLogicLiteral(int id) 
	{
		super(id);
	}

	public ASTLogicLiteral(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new Boolean(val);
	}
}