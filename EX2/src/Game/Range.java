package Game;

public class Range {
	double min,max;

	public double dx()
	{
		return max-min;
	}

	public double pr(double x)
	{
		return (x-min)/dx();
	}

	private boolean isinrange(double x)
	{
		boolean ans = true;
		if(x<min || x>max)
		{
			ans = false;
		}
		return ans;
	}

	double val(double x)
	{
		return min+x*dx();
	}

}
