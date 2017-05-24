package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import club.mytree.VkClient;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class VkClient_ESTest extends VkClient_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      try { 
        VkClient.parseUsersInGroup("java.lang.StackTraceElement");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         verifyException("com.alibaba.fastjson.parser.DefaultJSONParser", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      try { 
        VkClient.parseUsersInGroup("-Sv_4~*");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
          verifyException("com.alibaba.fastjson.parser.JSONLexerBase", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      try { 
        VkClient.parseUsersInGroup("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
        verifyException("club.mytree.VkClient", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      try { 
        VkClient.parseUsersInGroup("'kyI'");
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
          verifyException("club.mytree.VkClient", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      try { 
        VkClient.parseOnlineUsers("4Lm6-Z>aj)");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         verifyException("com.alibaba.fastjson.parser.DefaultJSONParser", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      try { 
        VkClient.parseOnlineUsers("-UcIH|_jzU9=^,|H");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         verifyException("com.alibaba.fastjson.parser.JSONLexerBase", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      try { 
        VkClient.parseOnlineUsers("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         verifyException("club.mytree.VkClient", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      try { 
        VkClient.parseOnlineUsers("6");
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         verifyException("club.mytree.VkClient", e);
      }
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      VkClient vkClient0 = new VkClient();
  }
}
