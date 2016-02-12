package jz.sys.api;

import jz.sys.util.SysCallStack;
import jz.sys.util.SysString;

public interface SysAPI {
	
	public String name();

	public default void log(String message, Object... params) {
		this.logI(message, 0, params);
	}
	
	public default void logI(String message, int level, Object... params) {
		message = SysString.placeholder(message, params);
		System.out.println(SysCallStack.getLog(level + 2) + ": " + message);
	}
	
	public default void warn(String message, Object... params) {
		this.warnI(message, 0, params);
	}
	
	public default void warnI(String message, int level, Object... params) {
		message = SysString.placeholder(message, params);
		System.out.println(SysCallStack.getLog(level + 2) + "[WARNING]: " + message);
	}
	
	public default void error(String message, Exception e, Object... params) {
		this.errorI(message, 0, e, params);
	}
	
	public default void errorI(String message, int level, Exception e, Object... params) {
		message = SysString.placeholder(message, params);
		System.out.println(SysCallStack.getLog(level + 2) + "[ERROR]: " + message);
		
		if (e != null) {
			StackTraceElement[] stack = e.getStackTrace();
			System.err.println(e);
			for (int i = 0; i < stack.length; i++) {
				System.err.println(stack[i].toString());
			}
		}
	}
	
	public default void exception(Exception e) {
		this.errorI("Default error handling.", 0, e);
	}
	
}
