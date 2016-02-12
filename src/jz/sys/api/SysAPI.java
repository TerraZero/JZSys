package jz.sys.api;

public interface SysAPI {
	
	public String name();

	public default void log(String message, Object... params) {
		message = SysString.placeholder(message, params);
		System.out.println(SysCallStack.getLog(1) + ": " + message);
	}
	
	public default void warn(String message, Object... params) {
		message = SysString.placeholder(message, params);
		System.out.println(SysCallStack.getLog(1) + "[WARNING]: " + message);
	}
	
	public default void error(String message, Exception e, Object... params) {
		this.errorI(message, 2, e, params);
	}
	
	public default void errorI(String message, int level, Exception e, Object... params) {
		message = SysString.placeholder(message, params);
		System.out.println(SysCallStack.getLog(level) + "[ERROR]: " + message);
		
		if (e != null) {
			StackTraceElement[] stack = e.getStackTrace();
			System.out.println(e);
			for (int i = 0; i < stack.length; i++) {
				System.out.println(stack[i].toString());
			}
		}
	}
	
	public default void exception(Exception e) {
		this.errorI("Default error handling.", 2, e);
	}
	
}
