package de.edu.uniBonn.BigData.LSH.Hash;

import java.util.Random;

import de.edu.uniBonn.BigData.LSH.Beans.Vector;

public class CosineHash {

	private Vector randUnitVector ;
	Random rand  = new Random();

	/**
	 * constructor of hash cosine , it builds random unit vector by select each dimension from Gaussian distribution then normalize it.
	 * @param dimension
	 */
	public CosineHash(int dimension) {
		// TODO Auto-generated constructor stub
		randUnitVector=new Vector(dimension);
		
		// filling the vector
		for(int i=0;i<dimension;i++)
		{
			double val = rand.nextGaussian();
			randUnitVector.set(val, i);
		}
		//System.out.println("the length now is"+randUnitVector.getNorm());
		// normalize it 
		double normValue=randUnitVector.getNorm();
		for(int i=0;i<dimension;i++)
			randUnitVector.getData()[i]=randUnitVector.getData()[i]/normValue;
		//System.out.println("the length now is"+randUnitVector.getNorm());
		
	}
	
	
	public int hash(Vector param)
	{
		if(param.DotProduct(randUnitVector)>=0)
			return 1;
		else
			return 0;
		
	}
}
