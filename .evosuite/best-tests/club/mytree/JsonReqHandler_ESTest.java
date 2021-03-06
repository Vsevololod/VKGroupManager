
package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import club.mytree.JsonReqHandler;
import com.sun.net.httpserver.HttpExchange;
import java.net.URI;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.net.MockURI;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class JsonReqHandler_ESTest extends JsonReqHandler_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      JsonReqHandler jsonReqHandler0 = new JsonReqHandler();
      // Undeclared exception!
      try { 
        jsonReqHandler0.handle((HttpExchange) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("club.mytree.JsonReqHandler", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      JsonReqHandler jsonReqHandler0 = new JsonReqHandler();
      URI uRI0 = MockURI.URI("OuItm5t?Ph~x3q");
      HttpExchange httpExchange0 = mock(HttpExchange.class, new ViolatedAssumptionAnswer());
      doReturn(uRI0).when(httpExchange0).getRequestURI();
      // Undeclared exception!
      try { 
        jsonReqHandler0.handle(httpExchange0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }
}
