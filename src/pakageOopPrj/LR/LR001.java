package pakageOopPrj.LR;

import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;

public class LR001 {

	public static void main(String[] args) {
		SimpleRegression regression = new SimpleRegression();
//		regression.addData(1.0, 2.0);
//		regression.addData(2.0, 4.0);
//		regression.addData(3.0, 6.0);
//		
//		System.out.println(regression.getIntercept());
//		// displays intercept of regression line
//
//		System.out.println(regression.getSlope());
//		// displays slope of regression line
//
//		System.out.println(regression.getSlopeStdErr());
//		// displays slope standard error
//		    
//		regression.clear();
		
		double[][] data = { { 1, 3 }, {2, 5 }, {3, 7 }, {4, 14 }, {5, 11 }};
		regression.addData(data);
		
		System.out.println(regression.getIntercept());
		// displays intercept of regression line

		System.out.println(regression.getSlope());
		// displays slope of regression line

		System.out.println(regression.getSlopeStdErr());
		// displays slope standard error
			
	}

}
