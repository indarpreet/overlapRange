package service;

import java.util.Collections;
import java.util.List;

import model.Range;
import utils.Utility;

public class RangeOverlapService {

	/**
	 * Input : This method takes list of range object. Output : Merged Range object list
	 * the list Description : It takes list of object and provides merged object in the list
	 * @param range
	 */
	public List<Range> calculateMinimumRange(List<Range> rangeList) {
		// check is input list is not null and the range of each object is in proper
		// format!!
		if (!Utility.isEmptyOrNull(rangeList) && this.checkForUnsupportedFormat(rangeList)) {
			int index = 0;
			// sort range array by increasing order of their lower bounds
			Collections.sort(rangeList);
			for (int i = 1; i < rangeList.size(); i++) {
				// merge Range object if they overlap
				Range rangePrev = rangeList.get(i - 1);
				Range rangeNext = rangeList.get(i);
				if (rangeNext.getLowerBound() <= rangePrev.getUpperBound()) {
					// merge them and change their upper and lower bounds
					rangePrev.setLowerBound(Math.min(rangePrev.getLowerBound(), rangeNext.getLowerBound()));
					rangePrev.setUpperBound(Math.max(rangePrev.getUpperBound(), rangeNext.getUpperBound()));

				} else {
					// else just add the range in the array
					index++;
					rangeList.set(index, rangeNext);
				}
			}
			return rangeList.subList(0, index + 1);
		}
		throw new NullPointerException();
	}

	/**
	 * Checks for unsupported format if the lower bound is greater than upper bound
	 * 
	 * @param rangeList
	 * @return
	 */
	private boolean checkForUnsupportedFormat(List<Range> rangeList) {
		for (Range range : rangeList) {
			if (range.getLowerBound() > range.getUpperBound()) {
				throw new UnsupportedOperationException();
			}
		}
		return true;
	}

}
