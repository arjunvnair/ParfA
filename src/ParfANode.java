import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ParfANode 
{
	protected static Writer printer = new PrintWriter(System.out);
	protected static Reader reader = new InputStreamReader(System.in);
    protected static Object[] stack = new Object[1024];
    protected static int p = -1;
    protected static Map<String, Object> variables = new HashMap<String, Object>();
    public void interpret() 
    {
    	throw new UnsupportedOperationException();
    }
    public static String getName(Class<?> c)
    {
    	if(c.equals(Double.class))
    		return "number";
    	else if(c.equals(Boolean.class))
    		return "logic";
    	else if(c.equals(String.class))
    		return "text";
    	else if(c.equals(ArrayList.class))	
    		return "list";
    	else
    		return "unknown type";
    }
    public static void setReader(Reader reader) 
    {
    	ParfANode.reader = reader;
    }
    public static void setPrinter(Writer printer) 
    {
    	ParfANode.printer = printer;
    }
}
