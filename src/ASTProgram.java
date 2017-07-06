public class ASTProgram extends SimpleNode 
{
	public ASTProgram(int id) 
	{
		super(id);
	}

	public ASTProgram(ParfA p, int id) 
	{
		super(p, id);
	}
	
	@Override
	public void interpret()
	{
		for (int i = 0; i < jjtGetNumChildren(); i++) 
			jjtGetChild(i).interpret();
	}
}