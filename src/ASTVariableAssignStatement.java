import java.util.ArrayList;

public class ASTVariableAssignStatement extends SimpleNode 
{
	public ASTVariableAssignStatement(int id) 
    {
		super(id);
    }

    public ASTVariableAssignStatement(ParfA p, int id)
    {
    	super(p, id);
    }

    @Override
    public void interpret()
    {
    	jjtGetChild(1).interpret();
		Object val = ParfANode.stack[ParfANode.p--];
		String identifier = ((ASTId) jjtGetChild(0)).name;
		Class<?> c = ParfANode.variables.get(identifier).getClass();
		if(c.equals(Double.class))
		{
			if(val.getClass().equals(String.class))
				val = Double.parseDouble((String) val);
		}
		else if(c.equals(String.class))
			val = val.toString();
		else if(!(c.equals(Boolean.class) | c.equals(ArrayList.class)))
			throw new IllegalStateException();
    	ParfANode.variables.put(identifier, val);
    }
}