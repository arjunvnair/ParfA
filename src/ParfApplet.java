/**
 * Copyright (c) 2017 Arjun Nair
 */

import java.applet.Applet;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ParfApplet extends Applet 
{
	private static final long serialVersionUID = 1L;
	public static void run(String code)
	{
		InputStream stream = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		ParfA.run(stream);
	}
}
