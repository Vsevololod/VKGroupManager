package club.mytree;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import club.mytree.SQLiteConnection;
import club.mytree.UserOnline;
import java.util.LinkedList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class SQLiteConnection_ESTest extends SQLiteConnection_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      LinkedList<UserOnline> linkedList0 = new LinkedList<UserOnline>();
      SQLiteConnection sQLiteConnection0 = new SQLiteConnection("CREATE TABLE IF NOT EXISTS users (id INTEGER, online INTEGER, time INTEGER)", true);
      try { 
        sQLiteConnection0.update(linkedList0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         verifyException("club.mytree.SQLiteConnection", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SQLiteConnection sQLiteConnection0 = new SQLiteConnection("", true);
      try { 
        sQLiteConnection0.getUsersOnline((-2258), (-2258));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         verifyException("club.mytree.SQLiteConnection", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      SQLiteConnection sQLiteConnection0 = new SQLiteConnection("C", true);
      try { 
        sQLiteConnection0.getAllData();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         verifyException("club.mytree.SQLiteConnection", e);
      }
  }
}
