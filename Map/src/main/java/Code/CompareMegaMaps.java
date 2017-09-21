package Code;

import java.util.HashMap;
import java.util.logging.Logger;


public class CompareMegaMaps {
	/**
	 * @param mapOfMapsLeft
	 * @param mapOfMapsRight
	 * @return compared result of two mapOfMaps
	 */
	
	public HashMap<String,Object> compareMegaMapsMethod(HashMap<String, HashMap<String, String>> mapOfMapsLeft, HashMap<String, HashMap<String, String>> mapOfMapsRight) {
		
		Logger log = Logger.getLogger(CompareMegaMaps.class.getName());
		log.info("creating a result set hashmap");
		HashMap<String,Object> resultSet = new HashMap<String,Object>();							//result to store
		log.info("result set hash map created");
		log.info("creating a temporary mega map");
		HashMap<String, HashMap<String,Object>> mapOfMapsReturn = new HashMap<String, HashMap<String,Object>>();
		log.info("temporary mega map created");
		CompareMaps compareMap = new CompareMaps();
		
		try{
			log.info("traversing each entry of leftMapOfMap");
	    	for (HashMap.Entry leftMapOfMapKey : mapOfMapsLeft.entrySet()) 
	    	{
	            String leftMapKey = (String) leftMapOfMapKey.getKey();
	            HashMap<String, String> leftMapValue = (HashMap<String, String>) leftMapOfMapKey.getValue();
	            HashMap<String, String> rightMapKey = mapOfMapsRight.get(leftMapKey);
	            
	           //$
	           log.info("checking if leftMap key is present in right map");
	           if(mapOfMapsRight.containsKey(leftMapKey))											//to check changed/unchanged values
	            {
	        	   log.info("calling compareMapsMethod for changed/unchanged values");
	        	   mapOfMapsReturn = compareMap.compareMapsMethod(leftMapValue, rightMapKey,leftMapKey);
		          
	        	   log.info("traversing each entry of compareMapsMethod returned map value");
	        	   for (HashMap.Entry mapOfMapsReturnKey : mapOfMapsReturn.entrySet()) 
		           {
			            HashMap<String, Object> tempMap =  (HashMap<String, Object>) mapOfMapsReturnKey.getValue();
			        	for (HashMap.Entry tempKey : tempMap.entrySet())
			        	{
			            	resultSet.put(leftMapKey+"-"+tempKey.getKey().toString(), tempKey.getValue());
			            	log.info("Added to resultset map");
			        	}
			         
			    	}
	            }
	           else
	            {
	        	    log.info("traversing each entry of leftMapOfMap for deleted values");
	            	for(HashMap.Entry leftKeys : leftMapValue.entrySet())							//to check deleted values
	            		resultSet.put(leftMapOfMapKey.getKey()+"-"+leftKeys.getKey().toString(), new Values(leftMapOfMapKey.getKey()+"-"+leftKeys.getKey().toString(),leftKeys.getValue().toString(),"NULL","DELETED"));
	            	log.info("Added to resultset map");
	            }
	    	}
	    	log.info("traversing each entry of rightMapOfMap for added values");
	    	for (HashMap.Entry rightMapOfMapsKey : mapOfMapsRight.entrySet()) {
	            String rightMapKey = (String) rightMapOfMapsKey.getKey();
	            HashMap<String, String> rightMapValue =  (HashMap<String, String>) rightMapOfMapsKey.getValue();
	            
	            if(!mapOfMapsLeft.containsKey(rightMapKey))
	            {
	            	//$
	            	
	            	for (HashMap.Entry leftKeys : rightMapValue.entrySet()) {						//to check added values
	    	            	resultSet.put(rightMapOfMapsKey.getKey()+"-"+leftKeys.getKey().toString(), new Values(rightMapOfMapsKey.getKey()+"-"+leftKeys.getKey().toString(),"NULL",leftKeys.getValue().toString(),"ADDED"));
	    	            	log.info("Added to resultset map");
	            	}
	            }
	    	}
	    	
	    	
		}

	  catch (NullPointerException np) {
	        System.out.println(np);

	}
		
		 return(resultSet);																			//return final result


}
}
