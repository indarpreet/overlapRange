package utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utility {

	/**
	 * Exception and success message constants
	 */
	public static final String LIST_EMPTY = "The list is empty";
	public static final String UNSUPPORTED_INPUT = "Unsupported input";
	public static final String EXCEPTION = "Error occured";
	public static final String SUCCESS = "Task successfully executed";
	
	/**
	 * String constants
	 */
	public static final String EMPTY_STRING = " ";
	public static final String SQUARE_BRACKET_CLOSE = "]";
	public static final String COMMA = ",";
	public static final String SQUARE_BRACKET_OPEN = "[";

	/**
	 * To check if the object is null or of specific collection to check for empty
	 * @param input
	 * @return
	 */
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
