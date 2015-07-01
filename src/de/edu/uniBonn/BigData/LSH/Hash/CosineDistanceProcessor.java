package de.edu.uniBonn.BigData.LSH.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.edu.uniBonn.BigData.LSH.Beans.Vector;

public class CosineDistanceProcessor {

	public void computeAlpha(int dimension ,Vector X,Vector Y)
	{
		Integer [] indecies={10,50,100,200,400,800,1000,5000,10000};
		List<Integer> indeciesList=Arrays.asList(indecies);
		double cosAlpha=X.DotProduct(Y)/(X.getNorm()*Y.getNorm());
		double alpha=Math.acos(cosAlpha)*(180/Math.PI);
		System.out.println("the accurate alpha between X and Y ="+alpha);
		
		CosineHash hashFunction=new CosineHash(dimension);
		int numOfIteration=0;
		int numberofMathch=0;
		while (numOfIteration<=10000){
			hashFunction=new CosineHash(dimension);
			numOfIteration++;
			if(hashFunction.hash(X)==hashFunction.hash(Y))
				numberofMathch++;
			
			if(indeciesList.contains(numOfIteration)) // if it devisibale by 10
				System.out.println("number of iteration ="+numOfIteration+" and alpha="+getAlpha(numberofMathch, numOfIteration));
		}
	}
	
	
	private double getAlpha(double match,double total)
	{
		//double cosAlpha=1-(match/total);
		//cosAlpha*=Math.PI;
		//return Math.acos(cosAlpha)*(180/Math.PI);
		
		
		return (1-(match/total))*
				180;
	}
	
}
