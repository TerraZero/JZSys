package jz.sys.api;

public class SysCallStack {
	
	public static String getLog() {
		return SysCallStack.getLog(0);
	}
	
	public static String getLog(int level) {
		StackTraceElement stack = SysCallStack.getStackElement(level + 3);
		
		if (stack == null) {
			return "null";
		}
		return "(" + stack.getFileName() + ":" + stack.getLineNumber() + ")[" + stack.getMethodName() + "]";
	}
	
	public static StackTraceElement getStackElement(int level) {
		level++;
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		
		if (stack.length >= level) {
			return stack[level];
		}
		return null;
	}
	
}
