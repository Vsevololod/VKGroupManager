package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import static org.evosuite.runtime.EvoAssertions.*;
import club.mytree.StaticHandle;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.mock.java.net.MockURI;
import org.evosuite.runtime.testdata.EvoSuiteFile;
import org.evosuite.runtime.testdata.FileSystemHandling;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class StaticHandle_ESTest extends StaticHandle_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      StaticHandle staticHandle0 = new StaticHandle();
      URI uRI0 = MockURI.URI((String) null, (String) null, "", "");
      HttpExchange httpExchange0 = mock(HttpExchange.class, new ViolatedAssumptionAnswer());
      doReturn(uRI0).when(httpExchange0).getRequestURI();
      try { 
        staticHandle0.handle(httpExchange0);
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      StaticHandle staticHandle0 = new StaticHandle();
      URI uRI0 = MockURI.URI((String) null, (String) null, (String) null, (String) null);
      FileSystemHandling.shouldAllThrowIOExceptions();
      HttpExchange httpExchange0 = mock(HttpExchange.class, new ViolatedAssumptionAnswer());
      doReturn(uRI0).when(httpExchange0).getRequestURI();
      try { 
        staticHandle0.handle(httpExchange0);
        fail("Expecting exception: IOException");
      
      } catch(IOException e) {
         verifyException("org.evosuite.runtime.vfs.VirtualFileSystem", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      StaticHandle staticHandle0 = new StaticHandle();
      URI uRI0 = MockURI.create("text/css");
      HttpExchange httpExchange0 = mock(HttpExchange.class, new ViolatedAssumptionAnswer());
      doReturn(uRI0).when(httpExchange0).getRequestURI();
      doReturn((Headers) null).when(httpExchange0).getResponseHeaders();
      try { 
        staticHandle0.handle(httpExchange0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         verifyException("club.mytree.StaticHandle", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      EvoSuiteFile evoSuiteFile0 = new EvoSuiteFile("C:\\Users\\Spiriq\\IdeaProjects\\VKGroupManager\\statictext\\html:text\\html");
      FileSystemHandling.createFolder(evoSuiteFile0);
      StaticHandle staticHandle0 = new StaticHandle();
      URI uRI0 = MockURI.URI("text/html", "text/html", "text/html");
      OutputStream outputStream0 = mock(OutputStream.class, new ViolatedAssumptionAnswer());
      HttpExchange httpExchange0 = mock(HttpExchange.class, new ViolatedAssumptionAnswer());
      doReturn(uRI0).when(httpExchange0).getRequestURI();
      doReturn(outputStream0).when(httpExchange0).getResponseBody();
      staticHandle0.handle(httpExchange0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      StaticHandle staticHandle0 = new StaticHandle();
      URI uRI0 = MockURI.create("text/hl");
      HttpExchange httpExchange0 = mock(HttpExchange.class, new ViolatedAssumptionAnswer());
      doReturn(uRI0).when(httpExchange0).getRequestURI();
      doReturn((Headers) null).when(httpExchange0).getResponseHeaders();
      try { 
        staticHandle0.handle(httpExchange0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         verifyException("club.mytree.StaticHandle", e);
      }
  }
}
