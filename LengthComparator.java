import java.util.Comparator;

public class LengthComparator implements Comparator<String>
{

	@Override
	public int compare(String arg0, String arg1)
	{
		//arg0 compared to arg1
		//negative: less than
		//zero: equal to
		//positive: greater than
		if(arg0.length() == arg1.length())
		{
			return 0;
		}
		return arg0.length() < arg1.length() ? 1 : -1;

	}

}
