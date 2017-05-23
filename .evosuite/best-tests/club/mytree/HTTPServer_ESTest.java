
package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import club.mytree.HTTPServer;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class HTTPServer_ESTest extends HTTPServer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      HTTPServer hTTPServer0 = new HTTPServer();
      hTTPServer0.run();
  }
}
