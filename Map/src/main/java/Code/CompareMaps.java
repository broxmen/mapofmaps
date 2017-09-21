package Code;

import java.util.HashMap;
import java.util.logging.Logger;


public class CompareMaps {
	/**
	 * @param leftChildMap
	 * @param rightChildMap
	 * @param parentKey
	 * @return compared result of maps
	 */
	
	public HashMap<String, HashMap<String, Object>> compareMapsMethod(HashMap<String, String> leftChildMap, HashMap<String, String> rightChildMap,String parentKey) {

		Logger log = Logger.getLogger(CompareMegaMaps.class.getName());
		
		log.info("creating hash map");
		HashMap<String,Object> hashMap = new HashMap<String,Object>();							//hashmap to store updated values
    	
    	log.info("creating result map");
    	HashMap<String, HashMap<String,Object>> mapOfMaps = new HashMap<String, HashMap<String,Object>>();		//hashmap to store result
    	log.info("result map created");
    	
    	try{
    		log.info("traversing each entry of leftChildMap");
	    	for (HashMap.Entry m : leftChildMap.entrySet()) {
	    		log.info("getting left key");
	            String leftChildMapKey = (String) m.getKey();
	            log.info("getting left key's value");
	            String leftChildMapValue = (String) m.getValue();
	            log.info("getting right key's value");
	            String matchingKeys = rightChildMap.get(leftChildMapKey);
	            log.info("checking if its changed/unchanged value");
	            if(rightChildMap.containsKey(leftChildMapKey))
	            {
		            if (leftChildMapValue.equals(matchingKeys)) 									//if keys are equal
		                hashMap.put(leftChildMapKey, new Values(parentKey+"-"+leftChildMapKey,leftChildMapValue, matchingKeys,"UNCHANGED"));			//if values are same
		            else
		            	hashMap.put(leftChildMapKey, new Values(parentKey+"-"+leftChildMapKey,leftChildMapValue,matchingKeys,"CHANGED"));				//if values are changed
	            }
	            else if(!rightChildMap.containsKey(leftChildMapKey))
	            {
	            	log.info("checking if it is a deleted value");
	            	hashMap.put(leftChildMapKey, new Values(parentKey+"-"+leftChildMapKey,leftChildMapValue,"NULL","DELETED"));						//if values are deleted
	            }
	    	}
	    	log.info("traversing right child map");
	    	for (HashMap.Entry m : rightChildMap.entrySet()) {
	            String rightChildMapKey = (String) m.getKey();
	            String rightChildMapValue = (String) m.getValue();
	            
	            if(!leftChildMap.containsKey(rightChildMapKey))
	            {
	            		log.info("checking if it is an added value");
		                hashMap.put(rightChildMapKey, new Values(parentKey+"-"+rightChildMapKey,"NULL",rightChildMapValue,"ADDED"));					//if values are added
	            
	            }
	    	}
	    } catch (NullPointerException np) {
	        System.out.println(np);
	    }
    																			//add all maps to a single map and return it
	    mapOfMaps.put("result", hashMap);
	    log.info("values added to result map");
	    log.info("returning result map");
	    return (mapOfMaps);  
	}
}
