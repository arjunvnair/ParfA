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
			if(val.getClass().equals(String.class))
				try
				{
					val = Double.parseDouble((String) val);
				}
				catch(NumberFormatException e)
				{
					val = new Double(0.0);
				}
			else if(!val.getClass().equals(Double.class))
			{
				System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " is a " + getName(c) + " and cannot store a " + getName(val.getClass()) + ".");
				throw new IllegalStateException();
			}
		else if(c.equals(String.class))
			val = val.toString();
		else if(c.equals(Boolean.class) | c.equals(ArrayList.class))
			if(!c.equals(val.getClass()))
			{
				System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", " + identifier + " is a " + getName(c) + " and cannot store a " + getName(val.getClass()) + ".");
				throw new IllegalStateException();
			}
		else
		{
			System.err.println("A fatal exception occurred when processing line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", try running the program again.");
			throw new IllegalStateException();
		}
    	ParfANode.variables.put(identifier, val);
    }
}