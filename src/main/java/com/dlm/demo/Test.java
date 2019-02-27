package com.dlm.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		/*
		 * StudentsUnsatisfiedConditionsDto dto=new
		 * StudentsUnsatisfiedConditionsDto();
		 * //System.out.println(JSON.toJSONString(getFiledName(dto))); String []
		 * fields=getFiledName(dto); for (String string : fields) {
		 * System.out.println("private Boolean is"+string.substring(0,1).
		 * toUpperCase()+string.substring(1)+"Null;"); }
		 */
		// System.out.println( JSON.toJSONString(getFiledsInfo(new people())));
		// FreshmanForConfirmDto dto=new FreshmanForConfirmDto();
		String[] fields = getFiledName(new Object());
		for (String string : fields) {
			// String td="<td title="+"\"${"+string+"}\">{{if
			// "+string+"}}√{{else}}{{/if}}</td>";
			String td2 = string;
			// String s = " <td class='width04' title=\"${" + td2 + "}\">${" +
			// td2 + "}</td>";
			String s = "		<td  class='width90' title=\"\"></td>";
			System.out.println(s);
		}
		/*
		 * people people=new people("YY",18,0); Object
		 * vObject=getFieldValueByName("age",people);
		 * System.out.println(JSON.toJSONString(vObject));
		 * System.out.println(JSON.toJSONString(getFiledName(people)));
		 * System.out.println(JSON.toJSONString(getFiledsInfo(people)));
		 * System.out.println(JSON.toJSONString(getFiledValues(people)));
		 */

		// System.out.println(String.format("%tc", new Date()));
		// System.out.println(new Date());
		/*
		 * String jsString=
		 * "{\"tableType\":2,\"grade\":\"2021\",\"queryParam\":{\"code\":0,\"msg\":\"success\",\"data\":[{\"settingId\":\"6f92eb0a637541d6a57ac9ce25060527\",\"settingType\":1,\"fieldName\":\"grade\",\"displayName\":\"年级\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":3},{\"settingId\":\"d86d7151d933497e978c82f8ddcdf54f\",\"settingType\":1,\"fieldName\":\"candidateNo\",\"displayName\":\"考生号\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":4},{\"settingId\":\"83fc0f7ceee04ddf892121227dbdfb84\",\"settingType\":1,\"fieldName\":\"nationCode\",\"displayName\":\"民族\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":5},{\"settingId\":\"c22b445e52c447a7925df93359b89825\",\"settingType\":1,\"fieldName\":\"trainingLevel\",\"displayName\":\"培养层次\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":6},{\"settingId\":\"e40d54f9e2574e05a4a4e227f1aa7f30\",\"settingType\":1,\"fieldName\":\"entranceDate\",\"displayName\":\"入学日期\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":7},{\"settingId\":\"b181902dfd934b6aaffccd3131c1c908\",\"settingType\":1,\"fieldName\":\"idCardTypeCode\",\"displayName\":\"证件类型\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":8},{\"settingId\":\"0edb5b3dd19942b9b30a0ab684fe279b\",\"settingType\":1,\"fieldName\":\"idCard\",\"displayName\":\"证件号\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":9},{\"settingId\":\"d65865e5ec1d4e34b0976924c8d72dd6\",\"settingType\":1,\"fieldName\":\"trainingWayCode\",\"displayName\":\"办学形式\",\"isEnabled\":0,\"isTolerateNull\":1,\"orderNO\":1},{\"settingId\":\"d4f6e60832a247e0a77cafb90881e1e0\",\"settingType\":1,\"fieldName\":\"birthday\",\"displayName\":\"出生日期\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":2},{\"settingId\":\"b321a0c5859c48c389f3cf9b128bcfe5\",\"settingType\":1,\"fieldName\":\"sexCode\",\"displayName\":\"性别\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":10},{\"settingId\":\"a925643ef7b94d74a700e1791bca157a\",\"settingType\":1,\"fieldName\":\"studentName\",\"displayName\":\"姓名\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":11},{\"settingId\":\"1976e4a3c1cd406f9afcc4a04ca2b20f\",\"settingType\":1,\"fieldName\":\"studentNo\",\"displayName\":\"学号\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":12},{\"settingId\":\"1e2c7d1bca2847da9fd8fa7e74228618\",\"settingType\":1,\"fieldName\":\"studyFormCode\",\"displayName\":\"学习形式\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":13},{\"settingId\":\"a2a82275a25844cda51479f65375e027\",\"settingType\":1,\"fieldName\":\"educationSystem\",\"displayName\":\"学制\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":14},{\"settingId\":\"c57d40d5ef064746b9c5d00a1bc2faa0\",\"settingType\":1,\"fieldName\":\"PoliticalStatusCode\",\"displayName\":\"政治面貌\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":15},{\"settingId\":\"7fb77c3f4b5c4afbaeb63a949b03ab1b\",\"settingType\":1,\"fieldName\":\"schoolType\",\"displayName\":\"办学类型\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":16},{\"settingId\":\"cc9aebf7a2114125ab8af81afb908e87\",\"settingType\":1,\"fieldName\":\"departmentNo\",\"displayName\":\"系所号\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":17},{\"settingId\":\"5815078f3e9146f4a66b14c5cb939cab\",\"settingType\":1,\"fieldName\":\"otherSchoolForm\",\"displayName\":\"其他办学形式\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":18},{\"settingId\":\"b58bf19704a145d192e790befd9ac20d\",\"settingType\":1,\"fieldName\":\"majorNo\",\"displayName\":\"专业号\",\"isEnabled\":1,\"isTolerateNull\":1,\"orderNO\":19}]}}";
		 * JSONObject object=JSON.parseObject(jsString);
		 * System.out.println(object.get("grade")==null); System.out.println(new
		 * a().aBoolean);
		 */
	}

	static class a {
		Boolean aBoolean;
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
}
