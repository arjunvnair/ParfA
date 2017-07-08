public class ASTTextLiteral extends SimpleNode 
{
	String val;
	
	public ASTTextLiteral(int id) 
	{
		super(id);
	}

	public ASTTextLiteral(ParfA p, int id) 
	{
		super(p, id);
	}

	public void interpret()
	{
		ParfANode.stack[++ParfANode.p] = new String(val);
	}
}