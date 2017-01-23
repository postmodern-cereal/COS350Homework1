//By Noah Ransom

import java.util.*;


class Homework1
{
	
	public String fail = "FAIL";
	
	public LinkedList<String> makeJourney(LinkedList<Integer> sticks, int distance, String workingString)
	{
		//at top level, workingString is just a space
		//create working string that is used to base moves on
		//pass working string to recursive calls
		//if no completion possible, set string to default invalid value
	    LinkedList<String> toReturn;
	    toReturn = new LinkedList<String>();
	    
	    for(int i = 0; i < sticks.size(); i++)
	    {
	        if(sticks.get(i) == distance)
	        {
	            //create a copy of current string that ends here, add to list
	            //toReturn += (sticks.get(i).toString); //tostring not for int: fix later
	            //added to returns
	        	String tmp = (workingString + sticks.get(i).toString());
	        	tmp = tmp.trim(); //no whitespace on front or rear
	        	toReturn.add(tmp);
	        	
	        	
	        }
	        else if(sticks.get(i) > distance)
	        {
	            //don't create a copy
	            //don't add this to the string
	        	continue;
	        	
	        }
	        else
	        {
	        	
	            //copy the current string
	            //add this number to it
	            //toReturn.add(sticks.get(i).toString)
	            //return toReturn += makeJourney(sticks, (distance - sticks.get(i)));
	        	toReturn.addAll(makeJourney(sticks, (distance - sticks.get(i)), (workingString + sticks.get(i).toString() + " ")));
	        }
	    }
	    
	    
	    return toReturn;
	}

	public void printJourneys(LinkedList<String> journeys)
	{
		journeys.sort(new LengthComparator());
		while(journeys.size() > 0)
		{
			System.out.println(journeys.remove());
		}
	}
	
    //public int distance; //how far we need to go
    //public int numSticks; //how many pogo sticks there are
    //public Integer[] pogoSticks; //contains jump distances for pogo sticks

    public static void main(String[] args)
    {
    	Homework1 h1 = new Homework1();
    	LinkedList<Integer> pogoSticks = new LinkedList<Integer>();
    	int distance;
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter an input.");
    	
    	distance = scan.nextInt();
    	String str = " ";
    	while(scan.hasNext())
    	{
    		pogoSticks.add(scan.nextInt());
    		System.out.println(pogoSticks.getLast());
    		
    		
    	}
    	scan.close();
        //int distance = 5;
        //int numSticks = 4;
        //Integer[] pogoSticks = new Integer[numSticks];
       /* pogoSticks[0] = 5;
        pogoSticks[1] = 10;
        pogoSticks[2] = 1;
        pogoSticks[3] = 3;*/
        h1.makeJourney(pogoSticks, distance, " ");
        h1.printJourneys(h1.makeJourney(pogoSticks, distance, " "));
        System.out.println("Done");
    }
}