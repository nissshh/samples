package com.deere.warranty.compare;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 
 */

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */
public abstract class AbstractTest {

		/**
		 * @return File at specific path
		 * @throws IOException
		 * @throws URISyntaxException
		 */
		protected File getFile(String fileName) throws IOException, URISyntaxException {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			return file;
		}

}
