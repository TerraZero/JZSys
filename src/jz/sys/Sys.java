package jz.sys;

import jz.sys.api.SysAPI;
import jz.sys.api.a.SysComponent;

@SysComponent(name="Sys")
public class Sys {
	
	private static SysAPI handling;
	
	static {
		Sys.handling = new SysAPI() {
			
			@Override
			public String name() {
				return "Sys";
			}
			
		};
	}

	public static void log(String message, Object... params) {
		Sys.handling.log(message, params);
	}
	
}
