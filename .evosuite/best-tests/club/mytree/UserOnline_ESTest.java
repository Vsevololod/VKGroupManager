package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import club.mytree.UserOnline;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UserOnline_ESTest extends UserOnline_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UserOnline userOnline0 = new UserOnline(0, (-2107));
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      UserOnline userOnline0 = new UserOnline();
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      UserOnline userOnline0 = new UserOnline(0, 0, (-1099));
  }
}
