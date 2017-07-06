public class ASTStringLiteral extends SimpleNode 
{
	String val;
	
	public ASTStringLiteral(int id) 
	{
		super(id);
	}

	public ASTStringLiteral(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new String(val);
	}
}