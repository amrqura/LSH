package de.edu.uniBonn.BigData.LSH.Hash;

import java.util.List;

import de.edu.uniBonn.BigData.LSH.Beans.Vector;

public class CosineDistanceProcessor {

	public void computeAlpha(int dimension ,Vector X,Vector Y)
	{
		
		CosineHash hashFunction=new CosineHash(dimension);
		int numOfIteration=0;
		int numberofMathch=0;
		while (numOfIteration<=1000){
			numOfIteration++;
			if(hashFunction.hash(X)==hashFunction.hash(Y))
				numberofMathch++;
			
			if(numOfIteration%10==0) // if it devisibale by 10
				System.out.println("number of iteration ="+numberofMathch+" and alpha="+getAlpha(numberofMathch, numOfIteration));
		}
	}
	
	
	private double getAlpha(double match,double total)
	{
		double cosAlpha=1-(match/total);
		cosAlpha*=Math.PI;
		return Math.acos(cosAlpha)*(180/Math.PI);
	}
	
}
