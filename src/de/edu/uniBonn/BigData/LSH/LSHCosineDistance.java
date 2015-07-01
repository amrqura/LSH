package de.edu.uniBonn.BigData.LSH;

import java.awt.Dimension;

import de.edu.uniBonn.BigData.LSH.Beans.Vector;
import de.edu.uniBonn.BigData.LSH.Hash.CosineDistanceProcessor;
import de.edu.uniBonn.BigData.LSH.Hash.CosineHash;

public class LSHCosineDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args==null || args.length!=3)
		{
			System.err.println("you should run the program with three arguments");
			System.exit(0);
		}
		int d=Integer.parseInt(args[0]); // d dimension
		String XvectorString=args[1];
		String YvectorString=args[2];
		Vector X=new Vector(d);
		Vector Y=new Vector(d);
		// filling the vector
		X.fillData(XvectorString.split(","));
		Y.fillData(YvectorString.split(","));
		// compute the actual distance
		// cos alpha=dotProduct(x,y)/[norm(X)*norm(Y)]
		System.out.println("vector X is "+X);
		System.out.println("vector Y is "+Y);
		CosineDistanceProcessor processor=new CosineDistanceProcessor();
		processor.computeAlpha(d, X, Y);
		
		// get 10 random samples
		for(int i=0;i<10;i++)
		{
			// refill the vector with random values
			for(int j=0;j<d;j++)
			{
				X.set(getRandomValue(-15, 15), j);
				Y.set(getRandomValue(-15, 15), j);
			}
			System.out.println("vector X is "+X);
			System.out.println("vector Y is "+Y);
			// recompute the distance
			processor.computeAlpha(d, X, Y);
			
		}
		
		
	}



	private static double getRandomValue(double Min,double Max)
	{
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}


}
