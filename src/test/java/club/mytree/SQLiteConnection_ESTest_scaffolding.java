package club.mytree;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class SQLiteConnection_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "club.mytree.SQLiteConnection"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "Cp1251"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.country", "RU"); 
    java.lang.System.setProperty("user.language", "ru"); 
    java.lang.System.setProperty("user.timezone", "Europe/Moscow"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(SQLiteConnection_ESTest_scaffolding.class.getClassLoader() ,
      "club.mytree.UserOnline",
      "org.sqlite.SQLiteConnection",
      "org.sqlite.core.NativeDB",
      "org.sqlite.date.DatePrinter",
      "org.sqlite.date.FastDatePrinter$TimeZoneNumberRule",
      "org.sqlite.SQLiteConfig$DatePrecision",
      "org.sqlite.date.FastDatePrinter$TimeZoneDisplayKey",
      "org.sqlite.date.FastDateParser$3",
      "org.sqlite.date.FastDateParser$4",
      "org.hsqldb.lib.Iterator",
      "org.sqlite.SQLiteJDBCLoader$1",
      "org.sqlite.SQLiteConfig$TransactionMode",
      "org.sqlite.core.Codes",
      "org.sqlite.SQLiteOpenMode",
      "org.sqlite.ProgressHandler",
      "org.sqlite.SQLiteConfig$JournalMode",
      "org.hsqldb.jdbc.JDBCDriver",
      "org.sqlite.date.FastDateParser$ISO8601TimeZoneStrategy",
      "org.sqlite.SQLiteConfig$PragmaValue",
      "org.sqlite.jdbc4.JDBC4Connection",
      "org.sqlite.SQLiteConfig$Pragma",
      "org.hsqldb.jdbc.JDBCDriver$1",
      "org.sqlite.Function",
      "org.sqlite.SQLiteException",
      "org.sqlite.date.FastDateFormat",
      "org.sqlite.date.FastDatePrinter$TwentyFourHourField",
      "org.sqlite.date.FormatCache",
      "org.sqlite.date.FastDateParser$CopyQuotedStrategy",
      "club.mytree.SQLiteConnection",
      "org.sqlite.date.FastDateFormat$1",
      "org.hsqldb.lib.FileAccess",
      "org.sqlite.SQLiteConfig$Encoding",
      "org.hsqldb.DatabaseURL",
      "org.hsqldb.map.HashIndex",
      "org.sqlite.date.DateParser",
      "org.sqlite.core.CoreConnection",
      "org.sqlite.date.FastDatePrinter",
      "org.sqlite.date.FastDatePrinter$TwoDigitMonthField",
      "org.sqlite.date.FastDatePrinter$Rule",
      "org.hsqldb.persist.HsqlProperties",
      "org.sqlite.util.OSInfo",
      "org.sqlite.date.FastDateParser",
      "org.sqlite.jdbc4.JDBC4DatabaseMetaData",
      "org.sqlite.date.FastDatePrinter$NumberRule",
      "org.sqlite.core.DB$ProgressObserver",
      "org.sqlite.SQLiteConfig$SynchronousMode",
      "org.sqlite.core.DB",
      "org.sqlite.SQLiteConfig$DateClass",
      "org.sqlite.jdbc3.JDBC3Connection",
      "org.sqlite.SQLiteConfig",
      "org.sqlite.JDBC",
      "org.hsqldb.map.ValuePoolHashMap",
      "org.hsqldb.map.BaseHashMap",
      "org.sqlite.date.FastDatePrinter$CharacterLiteral",
      "org.sqlite.date.FastDateParser$Strategy",
      "org.sqlite.date.FastDatePrinter$PaddedNumberField",
      "org.sqlite.SQLiteConfig$TempStore",
      "org.hsqldb.map.ValuePool",
      "org.hsqldb.lib.ObjectComparator",
      "org.sqlite.date.FastDatePrinter$TimeZoneNameRule",
      "org.sqlite.SQLiteJDBCLoader",
      "org.sqlite.BusyHandler",
      "org.sqlite.date.FastDatePrinter$Iso8601_Rule",
      "org.sqlite.jdbc3.JDBC3DatabaseMetaData",
      "org.sqlite.date.FastDateParser$CaseInsensitiveTextStrategy",
      "org.sqlite.core.CoreDatabaseMetaData",
      "org.sqlite.date.FastDateParser$1",
      "org.sqlite.SQLiteConfig$LockingMode",
      "org.sqlite.date.FormatCache$MultipartKey",
      "org.sqlite.date.FastDateParser$NumberStrategy",
      "org.sqlite.date.FastDateParser$2",
      "org.sqlite.date.FastDatePrinter$TwelveHourField",
      "org.sqlite.date.FastDateParser$TimeZoneStrategy",
      "club.mytree.UsersOnline",
      "org.sqlite.date.FastDatePrinter$TwoDigitNumberField"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(SQLiteConnection_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.sqlite.JDBC",
      "org.hsqldb.jdbc.JDBCDriver",
      "org.sqlite.core.CoreConnection",
      "org.sqlite.date.FormatCache",
      "org.sqlite.date.FastDateFormat",
      "org.sqlite.date.FastDatePrinter",
      "org.sqlite.date.FastDatePrinter$TwoDigitMonthField",
      "org.sqlite.date.FastDateParser$ISO8601TimeZoneStrategy",
      "org.sqlite.date.FastDateParser",
      "org.hsqldb.DatabaseURL",
      "org.hsqldb.persist.HsqlProperties",
      "org.hsqldb.map.BaseHashMap",
      "org.hsqldb.map.ValuePool",
      "org.sqlite.core.NativeDB",
      "org.sqlite.SQLiteJDBCLoader",
      "org.sqlite.util.OSInfo",
      "org.sqlite.SQLiteConfig",
      "org.sqlite.SQLiteConfig$Encoding",
      "org.sqlite.SQLiteConfig$JournalMode",
      "org.sqlite.SQLiteConfig$LockingMode",
      "org.sqlite.SQLiteConfig$SynchronousMode",
      "org.sqlite.SQLiteConfig$TempStore",
      "org.sqlite.SQLiteConfig$TransactionMode",
      "org.sqlite.SQLiteConfig$DatePrecision",
      "org.sqlite.SQLiteConfig$DateClass",
      "org.sqlite.SQLiteConfig$Pragma",
      "org.sqlite.SQLiteOpenMode"
    );
  }
}
