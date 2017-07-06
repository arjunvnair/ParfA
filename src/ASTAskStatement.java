import java.io.IOException;

public class ASTAskStatement extends SimpleNode 
{
	String name;
	String val;
	
	public ASTAskStatement(int id) 
	{
		super(id);
	}

	public ASTAskStatement(ParfA p, int id) 
	{
		super(p, id);
	}

	@Override
	public void interpret()
	{
		char[] input = new char[64];
		jjtGetChild(0).interpret();
	    try
	    {
	    	ParfANode.printer.write(ParfANode.stack[ParfANode.p].toString() + " ");
		   	ParfANode.printer.flush();
	        ParfANode.reader.read(input);
	    }
	    catch (IOException e) 
	  	{
	    	throw new IllegalStateException(e);
	  	}
        ParfANode.variables.put("answer", (new String(input)).trim());
	}
}