package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import action.RangeOverlapAction;
import model.Range;
import service.RangeOverlapService;

public class RangeOverlapTest {
	private RangeOverlapService service;

	@Before
	public void setUp() {
		service = new RangeOverlapService();
	}

	@Test(expected = NullPointerException.class)
	public void testRangeOverlapNullPointer() {
		// given
		List<Range> rangeList = null;
		// when
		service.calculateMinimumRange(rangeList);
		// then
		fail("The range list is empty");
	}

	@Test()
	public void testRangeOverlapWithArbitraryInput() {
		// given
		Range range1 = new Range(94133, 94133);
		Range range2 = new Range(94200, 94299);
		Range range3 = new Range(94226, 94399);
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(range3);
		rangeList.add(range2);
		rangeList.add(range1);
		// when
		rangeList = service.calculateMinimumRange(rangeList);
		// then
		assertEquals(2, rangeList.size());
	}

	@Test()
	public void testRangeOverlapWithArbitraryNegativeInput() {
		// given
		Range range1 = new Range(-00003, -00000);
		Range range2 = new Range(-00000, -00000);
		Range range3 = new Range(-94399, -00000);
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(range3);
		rangeList.add(range2);
		rangeList.add(range1);
		rangeList = service.calculateMinimumRange(rangeList);

		// then
		assertEquals(1, rangeList.size());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRangeOverlapWithArbitraryNegativeInputUnsupportedFormat() {
		// given
		Range range1 = new Range(-00000, -00003);
		Range range2 = new Range(-00000, -00000);
		Range range3 = new Range(-94399, -00000);
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(range3);
		rangeList.add(range2);
		rangeList.add(range1);
		rangeList = service.calculateMinimumRange(rangeList);
		// then
		assertEquals(0, rangeList.size());
	}

	@Test()
	public void testArbitraryValues() {
		Range range1 = new Range(93200, 95033);
		Range range2 = new Range(94200, 94298);
		Range range3 = new Range(94299, 94699);
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(range1);
		rangeList.add(range2);
		rangeList.add(range3);
		rangeList = service.calculateMinimumRange(rangeList);
		// then
		assertEquals(1, rangeList.size());
		RangeOverlapAction.printRangeList(rangeList);
	}

	@Test()
	public void testSingleValue() {
		Range range1 = new Range(93200, 95033);
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(range1);

		rangeList = service.calculateMinimumRange(rangeList);
		// then
		assertEquals(1, rangeList.size());
		RangeOverlapAction.printRangeList(rangeList);
	}

	@Test(expected = NullPointerException.class)
	public void testWithArrayListEmptyValue() {
		List<Range> rangeList = new ArrayList<Range>();
		rangeList = service.calculateMinimumRange(rangeList);
		// then
		assertEquals(1, rangeList.size());
		RangeOverlapAction.printRangeList(rangeList);
	}
}
