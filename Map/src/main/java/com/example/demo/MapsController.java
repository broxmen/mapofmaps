package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Code.CompareMegaMaps;
import Code.GenerateArray;


@RestController
public class MapsController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String body = "";
		try {
			body = FileUtils.readFileToString(
					new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\index.html"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
	@RequestMapping("/compare")
	@ResponseBody
	public String compare(@RequestBody String string) {
		HashMap<String,HashMap<String,String>> leftMapOfMaps = new HashMap<String, HashMap<String, String>>();
		HashMap<String,HashMap<String,String>> rightMapOfMaps = new HashMap<String, HashMap<String, String>>();
		HashMap<String, Object> result = new HashMap<String, Object>(); 
		String str = "";
		try {
		JSONParser parser = new JSONParser();
		JSONObject root,left,right,leftSubMap,rightSubMap;
		
		root = (JSONObject)parser.parse(string);
		left = (JSONObject)parser.parse(root.get("left").toString());
		right = (JSONObject)parser.parse(root.get("right").toString());
		
		Set<String> leftKeys = left.keySet();
		Set<String> rightKeys = right.keySet();
		
		String mainCountLeft = left.get("maincount").toString();
		String mainCountRight = right.get("maincount").toString();
		
		leftKeys.remove("maincount");
		rightKeys.remove("maincount");
		
		for(String mapKey : leftKeys)
		{
			
			leftSubMap = (JSONObject)parser.parse(left.get(mapKey).toString());
			Set<String> leftSubMapKeys = leftSubMap.keySet();
			System.out.println(mapKey);
			HashMap<String, String> leftMap = new HashMap<String, String>();
			for(String key : leftSubMapKeys )
			{
				leftMap.put(key,leftSubMap.get(key).toString());
			}
			leftMapOfMaps.put(mapKey, leftMap);
			
		}
		System.out.println(leftMapOfMaps);
		
		for(String mapKey : rightKeys)
		{
			
			rightSubMap = (JSONObject)parser.parse(right.get(mapKey).toString());
			Set<String> rightSubMapKeys = rightSubMap.keySet();
			System.out.println(mapKey);
			HashMap<String, String> rightMap = new HashMap<String, String>();
			for(String key : rightSubMapKeys )
			{
				rightMap.put(key,rightSubMap.get(key).toString());
			}
			rightMapOfMaps.put(mapKey, rightMap);
			
		}
		//System.out.println(rightMapOfMaps);
		CompareMegaMaps mmp = new CompareMegaMaps();
		result = mmp.compareMegaMapsMethod(leftMapOfMaps, rightMapOfMaps);
//		GenerateJSON result1 = new GenerateJSON();
//		str = result1.generateJSON(result);
		//System.out.println(str);
		GenerateArray arrayResult=new GenerateArray();
		 ArrayList jsonArrayResult=arrayResult.getJsonArray(result);
		 
		 Iterator<String> iterator=jsonArrayResult.iterator();
		 
		 int i=0;
		  str = "{\"items\":[ ";
		 while (iterator.hasNext()) {
			 switch(i)
			 {
			 case 0:
				 str+="{\"key\" : ";
				 break;
			 case 1:
				 str+="\"value1\" : ";
				 break;
			 case 2:
				 str+="\"value2\" : ";
				 break;
			 case 3:
				 str+="\"status\" : ";
				 break;
			default:
				 System.exit(0);
			 }
			 i++;
			 str+="\""+iterator.next()+"\"";
			 if(i==4) {
				 str+="} ";
				 i=0;
			 }
			 if(iterator.hasNext()&&i!=4)
			 {
				 str+=", ";
			 }
		}
		 str+=" ]}";
		 System.out.println("\n\n"+str);
		 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
