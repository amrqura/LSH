package de.edu.uniBonn.BigData.LSH.Beans;


public class Vector {

	private int dimension;
	public double[] getData() {
		return data;
	}

	private double[] data;
	public Vector(int dimension) {
		// TODO Auto-generated constructor stub
		this.dimension=dimension;
		data=new double[dimension];
	}
	
	
	public void fillData(String [] data)
	{
		for(int i=0;i<dimension;i++)
			this.data[i]=Double.parseDouble(data[i]);
	}
	
	/**
	 * set the data in position pos equals to value value
	 * @param value
	 * @param pos
	 */
	public void set(double value,int pos)
	{
		data[pos]=value;
	}
	/**
	 * calculate the dot Product between this vector "Point" and other Point
	 * @param otherPoint
	 * @return
	 */
	public double DotProduct(Vector otherPoint)
	{
		double result=0;
		for(int i=0;i<dimension;i++)
			result+=data[i]*otherPoint.getData()[i];
		return result;
	}
	
	/**
	 * compute the norm "length" of the vector, square root of sum of components square
	 * @return
	 */
	public double getNorm()
	{
		double result=0;
		for(int i=0;i<dimension;i++)
			result+=Math.pow(data[i], 2);
		return Math.sqrt(result);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result="";
		for(int i=0;i<dimension;i++)
			result=result+data[i]+" ";
		return result;
		
	}
}
