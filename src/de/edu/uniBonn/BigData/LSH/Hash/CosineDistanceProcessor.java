package de.edu.uniBonn.BigData.LSH.Hash;

import java.util.List;

import de.edu.uniBonn.BigData.LSH.Beans.Vector;

public class CosineDistanceProcessor {

	public void computeAlpha(int dimension ,Vector X,Vector Y)
	{
		double cosAlpha=X.DotProduct(Y)/(X.getNorm()*Y.getNorm());
		double alpha=Math.acos(cosAlpha)*(180/Math.PI);
		System.out.println("the accurate alpha between X and Y ="+alpha);
		
		CosineHash hashFunction=new CosineHash(dimension);
		int numOfIteration=0;
		int numberofMathch=0;
		while (numOfIteration<=1000){
			hashFunction=new CosineHash(dimension);
			numOfIteration++;
			if(hashFunction.hash(X)==hashFunction.hash(Y))
				numberofMathch++;
			
			if(numOfIteration%50==0) // if it devisibale by 10
				System.out.println("number of iteration ="+numOfIteration+" and alpha="+getAlpha(numberofMathch, numOfIteration));
		}
	}
	
	
	private double getAlpha(double match,double total)
	{
		double cosAlpha=1-(match/total);
		//cosAlpha*=Math.PI;
		return Math.acos(cosAlpha)*(180/Math.PI);
	}
	
}
