package com.dlm.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		try {
			a();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 根据属性名获取属性值
	 */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * 获取属性名数组
	 */
	private static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			// System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/**
	 * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 */
	private static List getFiledsInfo(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		List list = new ArrayList();
		Map infoMap = null;
		for (int i = 0; i < fields.length; i++) {
			infoMap = new HashMap();
			infoMap.put("type", fields[i].getType().toString());
			infoMap.put("name", fields[i].getName());
			infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}

	/**
	 * 获取对象的所有属性值，返回一个对象数组
	 */
	public static Object[] getFiledValues(Object o) {
		String[] fieldNames = new Test().getFiledName(o);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = new Test().getFieldValueByName(fieldNames[i], o);
		}
		return value;
	}

	/**
	 * 测试iterator为null时是否会报错
	 * @throws Exception
	 * @作者 邓力萌
	 * @Tags
	 * @创建时间 2019年3月5日下午4:08:22
	 */
	public static void a() throws Exception {
		try {
			int a = 1 / 0;
		} catch (Exception e) {
			throw new Exception("dfd");
		}
	}

}
