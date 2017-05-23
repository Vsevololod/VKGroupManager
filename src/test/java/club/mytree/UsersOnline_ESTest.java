package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import club.mytree.UsersOnline;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UsersOnline_ESTest extends UsersOnline_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UsersOnline usersOnline0 = new UsersOnline(266, 0);
      assertEquals(0, usersOnline0.count);
      assertEquals(266, usersOnline0.time);
  }
}
