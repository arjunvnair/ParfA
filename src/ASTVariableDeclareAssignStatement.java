import java.util.ArrayList;

public class ASTVariableDeclareAssignStatement extends SimpleNode 
{
	int type;
	String name;
	
	public ASTVariableDeclareAssignStatement(int id) 
	{
		super(id);
	}

	public ASTVariableDeclareAssignStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
		Object val = ParfANode.stack[ParfANode.p--];
		Class<?> c;
		if(type == ParfAConstants.NUMBER)
		{
			c = Double.class;
			if(val.getClass().equals(String.class))
				try
				{
					val = Double.parseDouble((String) val);
				}
				catch(NumberFormatException e)
				{
					throw new IllegalStateException();
				}
		}
		else if(type == ParfAConstants.LOGIC)
		{
			c = Boolean.class;
		}
		else if(type == ParfAConstants.TEXT)
		{
			c = String.class;
			val = val.toString();
		}
		else if(type == ParfAConstants.LIST)
		{
			c = ArrayList.class;
		}
		else
			throw new IllegalStateException();
		if(!(val.getClass().equals(c)))
			throw new IllegalStateException();
    	ParfANode.variables.put(name, val);
	}
}