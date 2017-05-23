package club.mytree;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class UpdateDBOnTimer_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "club.mytree.UpdateDBOnTimer"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(UpdateDBOnTimer_ESTest_scaffolding.class.getClassLoader() ,
      "com.alibaba.fastjson.asm.ClassWriter",
      "com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer",
      "com.alibaba.fastjson.serializer.AwtCodec",
      "com.alibaba.fastjson.util.ASMUtils",
      "com.alibaba.fastjson.parser.JSONLexerBase",
      "com.alibaba.fastjson.parser.deserializer.ParseProcess",
      "com.alibaba.fastjson.parser.deserializer.FieldTypeResolver",
      "org.apache.http.config.Lookup",
      "org.apache.http.HttpMessage",
      "org.apache.http.HttpRequestInterceptor",
      "club.mytree.VkClient",
      "com.alibaba.fastjson.serializer.SerializeWriter",
      "com.alibaba.fastjson.serializer.ReferenceCodec",
      "org.apache.http.conn.ClientConnectionManager",
      "com.alibaba.fastjson.JSONException",
      "com.alibaba.fastjson.serializer.ObjectArrayCodec",
      "org.apache.http.conn.HttpClientConnectionManager",
      "com.alibaba.fastjson.serializer.ToStringSerializer",
      "org.apache.http.HttpRequest",
      "org.apache.http.HttpException",
      "com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer",
      "org.apache.http.client.AuthenticationStrategy",
      "com.alibaba.fastjson.TypeReference",
      "com.alibaba.fastjson.serializer.ObjectSerializer",
      "com.alibaba.fastjson.serializer.DateCodec",
      "org.apache.http.conn.socket.ConnectionSocketFactory",
      "com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer",
      "com.alibaba.fastjson.parser.deserializer.EnumDeserializer",
      "org.apache.http.client.CredentialsProvider",
      "org.apache.http.conn.util.PublicSuffixMatcher",
      "com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask",
      "org.apache.http.client.ClientProtocolException",
      "com.alibaba.fastjson.serializer.BigDecimalCodec",
      "org.apache.http.client.methods.Configurable",
      "com.alibaba.fastjson.serializer.PrimitiveArraySerializer",
      "com.alibaba.fastjson.util.FieldInfo",
      "com.alibaba.fastjson.annotation.JSONField",
      "org.apache.http.client.methods.HttpUriRequest",
      "com.alibaba.fastjson.parser.SymbolTable",
      "com.alibaba.fastjson.JSONArray",
      "com.alibaba.fastjson.JSONAware",
      "com.alibaba.fastjson.serializer.LongCodec",
      "org.apache.http.client.methods.AbortableHttpRequest",
      "org.apache.http.client.HttpClient",
      "com.alibaba.fastjson.util.ASMClassLoader",
      "com.alibaba.fastjson.PropertyNamingStrategy",
      "com.alibaba.fastjson.parser.deserializer.JSONPDeserializer",
      "org.apache.http.client.methods.AbstractExecutionAwareRequest",
      "com.alibaba.fastjson.serializer.AppendableSerializer",
      "club.mytree.Main",
      "com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer",
      "com.alibaba.fastjson.util.ServiceLoader",
      "com.alibaba.fastjson.serializer.ASMSerializerFactory$Context",
      "com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer",
      "com.alibaba.fastjson.parser.DefaultJSONParser",
      "org.apache.http.protocol.HttpProcessor",
      "com.alibaba.fastjson.parser.deserializer.MapDeserializer",
      "org.apache.http.client.RedirectStrategy",
      "com.alibaba.fastjson.serializer.BigIntegerCodec",
      "com.alibaba.fastjson.util.IdentityHashMap",
      "com.alibaba.fastjson.JSON",
      "com.alibaba.fastjson.serializer.StringCodec",
      "com.alibaba.fastjson.serializer.SerializeFilterable",
      "org.apache.http.protocol.HttpContext",
      "com.alibaba.fastjson.asm.Opcodes",
      "org.apache.http.HttpResponse",
      "org.apache.http.impl.client.HttpClientBuilder",
      "com.alibaba.fastjson.JSONStreamAware",
      "com.alibaba.fastjson.serializer.SerializeBeanInfo",
      "com.alibaba.fastjson.serializer.SerializerFeature",
      "com.alibaba.fastjson.serializer.CalendarCodec",
      "com.alibaba.fastjson.util.IOUtils",
      "org.apache.http.conn.ConnectionKeepAliveStrategy",
      "com.alibaba.fastjson.util.TypeUtils",
      "com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer",
      "org.apache.http.conn.routing.HttpRoutePlanner",
      "org.apache.http.Consts",
      "com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory",
      "com.alibaba.fastjson.serializer.MiscCodec",
      "com.alibaba.fastjson.serializer.IntegerCodec",
      "com.alibaba.fastjson.serializer.SerializeFilter",
      "org.apache.http.util.Args",
      "org.apache.http.conn.util.PublicSuffixListParser",
      "org.apache.http.HttpEntity",
      "org.apache.http.client.methods.HttpRequestBase",
      "org.apache.http.conn.util.PublicSuffixMatcherLoader",
      "org.apache.http.conn.socket.LayeredConnectionSocketFactory",
      "org.apache.http.HttpResponseInterceptor",
      "club.mytree.UpdateDBOnTimer",
      "org.apache.http.client.methods.HttpGet",
      "org.apache.commons.cli.ParseException",
      "com.alibaba.fastjson.parser.deserializer.TimeDeserializer",
      "com.alibaba.fastjson.JSONObject",
      "com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer",
      "org.apache.http.impl.execchain.ClientExecChain",
      "com.alibaba.fastjson.serializer.CharacterCodec",
      "com.alibaba.fastjson.parser.deserializer.ObjectDeserializer",
      "org.apache.http.conn.SchemePortResolver",
      "com.alibaba.fastjson.parser.JSONLexer",
      "com.alibaba.fastjson.asm.Label",
      "com.alibaba.fastjson.serializer.JSONSerializer",
      "com.alibaba.fastjson.util.JavaBeanInfo",
      "com.alibaba.fastjson.serializer.SerializeConfig",
      "com.alibaba.fastjson.serializer.AtomicCodec",
      "com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer",
      "org.apache.http.client.CookieStore",
      "com.alibaba.fastjson.serializer.FloatCodec",
      "org.apache.http.message.AbstractHttpMessage",
      "com.alibaba.fastjson.parser.JSONReaderScanner",
      "org.apache.http.client.HttpRequestRetryHandler",
      "org.apache.http.impl.client.CloseableHttpClient",
      "com.alibaba.fastjson.parser.deserializer.FieldDeserializer",
      "org.apache.commons.cli.CommandLineParser",
      "com.alibaba.fastjson.serializer.CollectionCodec",
      "org.apache.http.impl.client.InternalHttpClient",
      "org.apache.http.client.methods.HttpExecutionAware",
      "org.apache.http.client.UserTokenHandler",
      "com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory$Context",
      "com.alibaba.fastjson.asm.MethodVisitor",
      "org.apache.http.ConnectionReuseStrategy",
      "org.apache.http.conn.util.DomainType",
      "com.alibaba.fastjson.parser.deserializer.NumberDeserializer",
      "com.alibaba.fastjson.annotation.JSONType",
      "com.alibaba.fastjson.serializer.JavaBeanSerializer",
      "com.alibaba.fastjson.serializer.DoubleSerializer",
      "com.alibaba.fastjson.serializer.ASMSerializerFactory",
      "com.alibaba.fastjson.serializer.BooleanCodec",
      "com.alibaba.fastjson.parser.Feature",
      "com.alibaba.fastjson.parser.ParserConfig",
      "com.alibaba.fastjson.parser.ParseContext"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(UpdateDBOnTimer_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "club.mytree.Main",
      "com.alibaba.fastjson.parser.Feature",
      "com.alibaba.fastjson.serializer.SerializerFeature",
      "com.alibaba.fastjson.util.IOUtils",
      "com.alibaba.fastjson.JSON",
      "com.alibaba.fastjson.util.ASMUtils",
      "com.alibaba.fastjson.util.TypeUtils",
      "com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory",
      "com.alibaba.fastjson.util.ASMClassLoader",
      "com.alibaba.fastjson.serializer.MiscCodec",
      "com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer",
      "com.alibaba.fastjson.parser.deserializer.TimeDeserializer",
      "com.alibaba.fastjson.serializer.DateCodec",
      "com.alibaba.fastjson.serializer.CalendarCodec",
      "com.alibaba.fastjson.parser.deserializer.MapDeserializer",
      "com.alibaba.fastjson.serializer.CollectionCodec",
      "com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer",
      "com.alibaba.fastjson.serializer.StringCodec",
      "com.alibaba.fastjson.serializer.CharacterCodec",
      "com.alibaba.fastjson.parser.deserializer.NumberDeserializer",
      "com.alibaba.fastjson.serializer.IntegerCodec",
      "com.alibaba.fastjson.serializer.LongCodec",
      "com.alibaba.fastjson.serializer.BigIntegerCodec",
      "com.alibaba.fastjson.serializer.BigDecimalCodec",
      "com.alibaba.fastjson.serializer.FloatCodec",
      "com.alibaba.fastjson.serializer.BooleanCodec",
      "com.alibaba.fastjson.serializer.ReferenceCodec",
      "com.alibaba.fastjson.serializer.AtomicCodec",
      "com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer",
      "com.alibaba.fastjson.parser.deserializer.JSONPDeserializer",
      "com.alibaba.fastjson.parser.ParserConfig",
      "com.alibaba.fastjson.JSONException",
      "club.mytree.VkClient",
      "org.apache.http.conn.util.PublicSuffixMatcherLoader",
      "org.apache.http.Consts",
      "org.apache.http.conn.util.DomainType",
      "com.alibaba.fastjson.parser.DefaultJSONParser",
      "com.alibaba.fastjson.parser.JSONLexerBase",
      "com.alibaba.fastjson.util.ServiceLoader",
      "com.alibaba.fastjson.parser.JSONReaderScanner",
      "com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory$Context",
      "com.alibaba.fastjson.serializer.AwtCodec",
      "com.alibaba.fastjson.serializer.ASMSerializerFactory",
      "com.alibaba.fastjson.serializer.DoubleSerializer",
      "com.alibaba.fastjson.serializer.PrimitiveArraySerializer",
      "com.alibaba.fastjson.serializer.ObjectArrayCodec",
      "com.alibaba.fastjson.serializer.AppendableSerializer",
      "com.alibaba.fastjson.serializer.ToStringSerializer",
      "com.alibaba.fastjson.serializer.SerializeConfig",
      "com.alibaba.fastjson.serializer.SerializeWriter"
    );
  }
}
