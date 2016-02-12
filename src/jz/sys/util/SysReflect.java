package jz.sys.util;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import jz.sys.Sys;
import jz.sys.api.a.SysComponent;
import jz.sys.reflect.Annot;
import jz.sys.reflect.AnnotWrapper;
import jz.sys.reflect.Reflect;
import jz.sys.reflect.loader.ReflectFile;
import jz.sys.reflect.loader.ReflectLoader;

public class SysReflect {
	
	public static void main(String[] args) {
		AnnotWrapper<SysComponent> w = new AnnotWrapper<SysComponent>(SysComponent.class);

		for (Annot<SysComponent> a : w.getAnnots()) {
			Sys.log(a.getAnnot().name());
		}
	}

	public static List<Reflect> annot(Class<? extends Annotation> annotation) {
		List<Reflect> list = new ArrayList<Reflect>();
		
		for (ReflectFile file : ReflectLoader.sysloader().load()) {
			if (file.reflect().hasAnnotation(annotation)) {
				list.add(file.reflect());
			}
		}
		return list;
	}
	
}
