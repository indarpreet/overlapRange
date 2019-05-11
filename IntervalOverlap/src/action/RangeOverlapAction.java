package action;

import java.util.ArrayList;
import java.util.List;

import model.Range;
import model.UserResponse;
import service.RangeOverlapService;
import utils.Utility;

public class RangeOverlapProblem {

	/**
	 * Input from UI/other services
	 * @param args
	 */
	public static void main(String[] args) {
		// Input : [94133,94133] [94200,94299] [94226,94399]
		// Output : [94133,94133] [94200,94399]
		Range range1 = new Range(94133, 94133);
		Range range2 = new Range(94200, 94299);
		Range range3 = new Range(94226, 94399);
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(range3);
		rangeList.add(range2);
		rangeList.add(range1);
		RangeOverlapProblem rangeOverlapProblem = new RangeOverlapProblem();
		UserResponse minRangeList = rangeOverlapProblem.calculateMinimumRange(rangeList);
		if(null != minRangeList.getError()) {
			System.out.println(minRangeList.getError());
		}else {
			System.out.println(Utility.SUCCESS);
			printRangeList((List<Range>) minRangeList.getResponse());
		}

	}
	/**
	 * algorithm that produces the minimum number of ranges
	 * @param rangeList
	 */
	public UserResponse calculateMinimumRange(List<Range> rangeList) {
		UserResponse userResponse = new UserResponse();
		try {
			RangeOverlapService overlapService = new RangeOverlapService();
		    rangeList = overlapService.calculateMinimumRange(rangeList);
		    userResponse.setResponse(rangeList);
		} catch (NullPointerException e) {
			userResponse.setError(Utility.LIST_EMPTY);
		} catch (UnsupportedOperationException e) {
			userResponse.setError(Utility.UNSUPPORTED_INPUT);
		} catch (Exception e) {
			userResponse.setError(Utility.EXCEPTION);
		}
		return userResponse;
	}
	
	/**
	 * Prints the list in the console
	 * @param rangeList
	 * @param index
	 */
	public static void printRangeList(List<Range> rangeList) {
		StringBuffer sb = new StringBuffer();
		for (Range range : rangeList) {
			sb.append("[").append(range.getLowerBound()).append(",").append(range.getUpperBound())
					.append("]").append(" ");

		}
		System.out.println(sb.toString());
	}

}