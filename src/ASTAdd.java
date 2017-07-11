/**
 * Copyright (c) 2017 Arjun Nair
 */
import java.util.ArrayList;

/**
 * Tree node for the + operator.
 * @author Arjun Nair
 */
public class ASTAdd extends SimpleNode 
{
	public ASTAdd(int id) 
    {
		super(id);
    }

	public ASTAdd(ParfA p, int id) 
    {
		super(p, id);
    }
  
	@SuppressWarnings("unchecked")
	@Override
	public void interpret()
	{
		jjtGetChild(0).interpret();
	    jjtGetChild(1).interpret();
	    try
	    {
	    	if(ParfANode.stack[ParfANode.p - 1] instanceof String)
	    		ParfANode.stack[--ParfANode.p] = new String(ParfANode.stack[ParfANode.p].toString() + ParfANode.stack[ParfANode.p + 1].toString());
	    	else if(ParfANode.stack[ParfANode.p - 1] instanceof ArrayList && ParfANode.stack[ParfANode.p] instanceof ArrayList)
	    	{
	    		ArrayList<Object> list = new ArrayList<Object>();
		    	list.addAll((ArrayList<Object>) ParfANode.stack[ParfANode.p - 1]);
		    	list.addAll((ArrayList<Object>) ParfANode.stack[ParfANode.p]);
		    	ParfANode.stack[--ParfANode.p] = new ArrayList<Object>(list);
	    	}
	    	else
	    		ParfANode.stack[--ParfANode.p] = new Double(((Double) ParfANode.stack[ParfANode.p]).doubleValue() + ((Double) ParfANode.stack[ParfANode.p + 1]).doubleValue());
	    }
	    catch(ClassCastException e)
	    {
	    	System.err.println("Runtime error at line: " + jjtGetLastToken().endLine + ", column: " + jjtGetLastToken().endColumn + ", cannot add " + getName(ParfANode.stack[ParfANode.p + 1].getClass()) + " to " + getName(ParfANode.stack[ParfANode.p].getClass()) + ".");
	    	throw new IllegalStateException();
	    }
  }
}