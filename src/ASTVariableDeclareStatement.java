import java.util.ArrayList;

public class ASTVariableDeclareStatement extends SimpleNode 
{
	int type;
	String name;
	
	public ASTVariableDeclareStatement(int id) 
	{
		super(id);
	}

	public ASTVariableDeclareStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		if(type == ParfAConstants.NUMBER)
			ParfANode.variables.put(name, new Double(0));
		else if(type == ParfAConstants.LOGIC)
			ParfANode.variables.put(name, new Boolean(false));
		else if(type == ParfAConstants.TEXT)
		    ParfANode.variables.put(name, new String(""));
		else if(type == ParfAConstants.LIST)
			ParfANode.variables.put(name, new ArrayList<Object>());
		else
			throw new IllegalStateException();
	}
}