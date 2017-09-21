package Code;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;


public class GenerateArray {
	/**
	 * @param resultSet(Map)
	 * @return  arraylist(array form of resultSet Map)
	 * @throws Exception
	 */
	
	public ArrayList getJsonArray( HashMap<String,Object> resultSet) throws Exception
	{
		Logger log = Logger.getLogger(GenerateArray.class.getName());
		ArrayList<String> temp=new ArrayList<String>();									//new arrayList
		int k=0,j=0;
		log.info("traversing each entry of resultSet");
		for(HashMap.Entry m: resultSet.entrySet())										//for each key-value pair in resultSet, add it to arrayList
		{
			Class<? extends Object> c1 = m.getValue().getClass();
			Field[] fields = c1.getDeclaredFields();
			log.info("traversing field of resultSet's value");
			for (int i = 0; i < fields.length; i++) 
			{
				log.info("get each field's value");
				 Object value = fields[i].get(m.getValue());
				 log.info("adding it to arrayList");
				 temp.add(value.toString());
				 log.info("added to arrayList");
			}
			j++;
		}
		log.info("returning the arrayList");
		return temp;																	//return arrayList
	}
	

}
