package utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utility {

		public static final String LIST_EMPTY = "The list is empty";
		public static final String UNSUPPORTED_INPUT = "Unsupported input";
		public static final String EXCEPTION = "Error occured";
		public static final String SUCCESS = "Task successfully executed";
		
	
	   public static boolean isEmptyOrNull(Object input) {
	        if (null == input) {
	            return true;
	        } else if (input instanceof Set<?>) {
	            return ((Set<?>) input).isEmpty();
	        } else if (input instanceof List<?>) {
	            return ((List<?>) input).isEmpty();
	        } else if (input instanceof Map<?, ?>) {
	            return ((Map<?, ?>) input).isEmpty();
	        } else if (input instanceof Object) {
	            return false;
	        }
	        return true;
	    }
}
