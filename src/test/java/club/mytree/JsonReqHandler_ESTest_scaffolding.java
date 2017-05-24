package club.mytree;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class JsonReqHandler_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "club.mytree.JsonReqHandler"; 
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
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(JsonReqHandler_ESTest_scaffolding.class.getClassLoader() ,
      "org.sqlite.SQLiteConnection",
      "org.sqlite.date.FastDatePrinter$TimeZoneNumberRule",
      "org.sqlite.date.FastDateParser$3",
      "org.sqlite.date.FastDateParser$4",
      "com.alibaba.fastjson.util.ASMUtils",
      "org.sqlite.core.Codes",
      "com.alibaba.fastjson.JSONPath",
      "com.alibaba.fastjson.parser.JSONScanner",
      "org.sqlite.SQLiteConfig$JournalMode",
      "org.hsqldb.jdbc.JDBCDriver",
      "com.alibaba.fastjson.parser.JSONLexerBase",
      "com.alibaba.fastjson.parser.deserializer.ParseProcess",
      "org.sqlite.SQLiteConfig$PragmaValue",
      "org.sqlite.jdbc4.JDBC4Connection",
      "org.sqlite.SQLiteConfig$Pragma",
      "org.hsqldb.jdbc.JDBCDriver$1",
      "org.sqlite.SQLiteException",
      "org.sqlite.date.FastDateFormat",
      "org.sqlite.date.FastDatePrinter$TwentyFourHourField",
      "com.alibaba.fastjson.serializer.SerializeWriter",
      "com.alibaba.fastjson.serializer.ReferenceCodec",
      "com.alibaba.fastjson.JSONException",
      "org.sqlite.date.FormatCache",
      "org.sqlite.date.FastDateParser$CopyQuotedStrategy",
      "com.alibaba.fastjson.serializer.ObjectArrayCodec",
      "com.alibaba.fastjson.serializer.ToStringSerializer",
      "org.sqlite.SQLiteConfig$Encoding",
      "com.alibaba.fastjson.serializer.SerialContext",
      "com.alibaba.fastjson.serializer.AfterFilter",
      "org.sqlite.date.DateParser",
      "com.alibaba.fastjson.TypeReference",
      "com.alibaba.fastjson.serializer.ObjectSerializer",
      "org.sqlite.core.CoreConnection",
      "org.sqlite.date.FastDatePrinter",
      "org.sqlite.date.FastDatePrinter$Rule",
      "org.hsqldb.persist.HsqlProperties",
      "org.sqlite.util.OSInfo",
      "com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider",
      "club.mytree.JsonReqHandler",
      "com.alibaba.fastjson.serializer.BigDecimalCodec",
      "org.sqlite.date.FastDateParser",
      "org.sqlite.date.FastDatePrinter$NumberRule",
      "org.sqlite.SQLiteConfig$SynchronousMode",
      "com.alibaba.fastjson.serializer.PrimitiveArraySerializer",
      "com.alibaba.fastjson.util.FieldInfo",
      "com.alibaba.fastjson.serializer.PropertyFilter",
      "org.sqlite.core.DB",
      "org.sqlite.jdbc3.JDBC3Connection",
      "com.alibaba.fastjson.parser.SymbolTable",
      "com.alibaba.fastjson.serializer.NameFilter",
      "org.hsqldb.map.ValuePoolHashMap",
      "com.alibaba.fastjson.JSONArray",
      "com.alibaba.fastjson.JSONAware",
      "com.alibaba.fastjson.serializer.LongCodec",
      "com.alibaba.fastjson.util.ASMClassLoader",
      "com.alibaba.fastjson.parser.JSONToken",
      "com.alibaba.fastjson.serializer.AppendableSerializer",
      "org.sqlite.date.FastDateParser$Strategy",
      "club.mytree.Main",
      "com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer",
      "com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer",
      "com.alibaba.fastjson.serializer.ASMSerializerFactory$Context",
      "org.sqlite.date.FastDatePrinter$TimeZoneNameRule",
      "com.alibaba.fastjson.serializer.ContextValueFilter",
      "org.sqlite.SQLiteJDBCLoader",
      "com.alibaba.fastjson.parser.DefaultJSONParser",
      "org.sqlite.BusyHandler",
      "com.alibaba.fastjson.serializer.ContextObjectSerializer",
      "com.alibaba.fastjson.serializer.BeanContext",
      "com.alibaba.fastjson.serializer.BigIntegerCodec",
      "com.alibaba.fastjson.util.IdentityHashMap",
      "com.alibaba.fastjson.JSON",
      "com.alibaba.fastjson.serializer.StringCodec",
      "com.alibaba.fastjson.serializer.SerializeFilterable",
      "org.sqlite.SQLiteConfig$LockingMode",
      "org.sqlite.date.FormatCache$MultipartKey",
      "org.sqlite.date.FastDateParser$NumberStrategy",
      "org.sqlite.date.FastDatePrinter$TwelveHourField",
      "com.alibaba.fastjson.JSONWriter",
      "org.sqlite.date.FastDateParser$TimeZoneStrategy",
      "com.alibaba.fastjson.asm.Opcodes",
      "com.alibaba.fastjson.JSONReader",
      "com.alibaba.fastjson.JSONStreamAware",
      "com.alibaba.fastjson.serializer.SerializeBeanInfo",
      "org.sqlite.core.NativeDB",
      "org.sqlite.date.DatePrinter",
      "com.alibaba.fastjson.serializer.SerializerFeature",
      "org.sqlite.SQLiteConfig$DatePrecision",
      "org.sqlite.date.FastDatePrinter$TimeZoneDisplayKey",
      "org.hsqldb.lib.Iterator",
      "org.sqlite.SQLiteConfig$TransactionMode",
      "org.sqlite.SQLiteOpenMode",
      "com.alibaba.fastjson.util.IOUtils",
      "org.sqlite.ProgressHandler",
      "com.alibaba.fastjson.util.TypeUtils",
      "org.sqlite.date.FastDateParser$ISO8601TimeZoneStrategy",
      "com.alibaba.fastjson.serializer.MiscCodec",
      "com.alibaba.fastjson.serializer.IntegerCodec",
      "org.sqlite.Function",
      "com.alibaba.fastjson.util.IOUtils$1",
      "com.alibaba.fastjson.serializer.SerializeFilter",
      "club.mytree.SQLiteConnection",
      "org.sqlite.date.FastDateFormat$1",
      "org.hsqldb.lib.FileAccess",
      "com.alibaba.fastjson.parser.deserializer.ExtraProcessor",
      "com.alibaba.fastjson.serializer.BeforeFilter",
      "org.hsqldb.DatabaseURL",
      "com.alibaba.fastjson.parser.deserializer.ExtraProcessable",
      "org.hsqldb.map.HashIndex",
      "club.mytree.UpdateDBOnTimer",
      "org.apache.commons.cli.ParseException",
      "org.sqlite.date.FastDatePrinter$TwoDigitMonthField",
      "com.alibaba.fastjson.util.ParameterizedTypeImpl",
      "com.alibaba.fastjson.JSONObject",
      "com.alibaba.fastjson.serializer.CharacterCodec",
      "com.alibaba.fastjson.parser.deserializer.ObjectDeserializer",
      "com.alibaba.fastjson.parser.JSONLexer",
      "org.sqlite.jdbc4.JDBC4DatabaseMetaData",
      "com.alibaba.fastjson.asm.Label",
      "org.sqlite.core.DB$ProgressObserver",
      "com.alibaba.fastjson.util.ASMClassLoader$1",
      "com.alibaba.fastjson.serializer.JSONSerializer",
      "com.alibaba.fastjson.util.JavaBeanInfo",
      "com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer",
      "org.sqlite.SQLiteConfig$DateClass",
      "com.alibaba.fastjson.serializer.SerializeConfig",
      "com.alibaba.fastjson.serializer.AtomicCodec",
      "org.sqlite.SQLiteConfig",
      "org.sqlite.JDBC",
      "org.hsqldb.map.BaseHashMap",
      "com.alibaba.fastjson.serializer.FloatCodec",
      "com.alibaba.fastjson.parser.JSONReaderScanner",
      "org.sqlite.date.FastDatePrinter$CharacterLiteral",
      "com.alibaba.fastjson.serializer.ValueFilter",
      "com.alibaba.fastjson.JSONPathException",
      "org.sqlite.date.FastDatePrinter$PaddedNumberField",
      "com.alibaba.fastjson.parser.deserializer.FieldDeserializer",
      "org.sqlite.SQLiteConfig$TempStore",
      "org.hsqldb.map.ValuePool",
      "org.apache.commons.cli.CommandLineParser",
      "org.hsqldb.lib.ObjectComparator",
      "com.alibaba.fastjson.serializer.Labels",
      "org.sqlite.date.FastDatePrinter$Iso8601_Rule",
      "org.sqlite.jdbc3.JDBC3DatabaseMetaData",
      "org.sqlite.date.FastDateParser$CaseInsensitiveTextStrategy",
      "org.sqlite.core.CoreDatabaseMetaData",
      "org.sqlite.date.FastDateParser$1",
      "com.alibaba.fastjson.asm.MethodVisitor",
      "org.sqlite.date.FastDateParser$2",
      "com.alibaba.fastjson.serializer.LabelFilter",
      "org.sqlite.date.FastDatePrinter$TwoDigitNumberField",
      "com.alibaba.fastjson.serializer.JavaBeanSerializer",
      "com.alibaba.fastjson.serializer.DoubleSerializer",
      "com.alibaba.fastjson.util.IdentityHashMap$Entry",
      "com.alibaba.fastjson.serializer.ASMSerializerFactory",
      "com.alibaba.fastjson.serializer.BooleanCodec",
      "com.alibaba.fastjson.parser.Feature",
      "com.alibaba.fastjson.parser.ParserConfig",
      "com.alibaba.fastjson.serializer.PropertyPreFilter",
      "com.alibaba.fastjson.parser.ParseContext"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.sun.net.httpserver.HttpExchange", false, JsonReqHandler_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(JsonReqHandler_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "club.mytree.Main",
      "com.alibaba.fastjson.parser.Feature",
      "com.alibaba.fastjson.serializer.SerializerFeature",
      "com.alibaba.fastjson.util.IOUtils",
      "com.alibaba.fastjson.JSON",
      "com.alibaba.fastjson.util.ASMUtils",
      "com.alibaba.fastjson.serializer.ASMSerializerFactory",
      "com.alibaba.fastjson.util.ASMClassLoader",
      "com.alibaba.fastjson.serializer.BooleanCodec",
      "com.alibaba.fastjson.serializer.CharacterCodec",
      "com.alibaba.fastjson.serializer.IntegerCodec",
      "com.alibaba.fastjson.serializer.LongCodec",
      "com.alibaba.fastjson.serializer.FloatCodec",
      "com.alibaba.fastjson.serializer.DoubleSerializer",
      "com.alibaba.fastjson.serializer.BigDecimalCodec",
      "com.alibaba.fastjson.serializer.BigIntegerCodec",
      "com.alibaba.fastjson.serializer.StringCodec",
      "com.alibaba.fastjson.serializer.PrimitiveArraySerializer",
      "com.alibaba.fastjson.serializer.ObjectArrayCodec",
      "com.alibaba.fastjson.serializer.MiscCodec",
      "com.alibaba.fastjson.serializer.AppendableSerializer",
      "com.alibaba.fastjson.serializer.ToStringSerializer",
      "com.alibaba.fastjson.serializer.AtomicCodec",
      "com.alibaba.fastjson.serializer.ReferenceCodec",
      "com.alibaba.fastjson.serializer.SerializeConfig",
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
      "org.sqlite.SQLiteOpenMode",
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
      "org.sqlite.util.OSInfo"
    );
  }
}
