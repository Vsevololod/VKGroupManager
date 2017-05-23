package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import club.mytree.UpdateDBOnTimer;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UpdateDBOnTimer_ESTest extends UpdateDBOnTimer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UpdateDBOnTimer updateDBOnTimer0 = new UpdateDBOnTimer();
      updateDBOnTimer0.run();
  }
}
