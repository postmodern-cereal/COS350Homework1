//By Noah Ransom

import java.util.*;
import java.util.Collections;

class Homework1
{

	public String fail = "FAIL";
	public int calls;
	public LinkedList<String> makeJourney(LinkedList<Integer> sticks, int distance, String workingString, Homework1 h1)
	{
        h1.calls++;
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
	        	toReturn.addAll(makeJourney(sticks, (distance - sticks.get(i)), (workingString + sticks.get(i).toString() + " "), h1));
	        }
	    }


	    return toReturn;
	}

	public void printJourneys(LinkedList<String> journeys)
	{
		Collections.sort(journeys, new LengthComparator());
		while(journeys.size() > 0)
		{
			System.out.println(journeys.remove());
		}
        System.out.println("Made " + calls + " recursive calls.");
	}

    //public int distance; //how far we need to go
    //public int numSticks; //how many pogo sticks there are
    //public Integer[] pogoSticks; //contains jump distances for pogo sticks

    public void prepSticks(LinkedList<Integer> sticks, Homework1 h1)
    {
        sticks.clear();
        h1.calls = 0;
        int distance = 0;
        Integer[] test1 = {5, 10, 1, 3};
        System.out.println("\nPerforming first test. Input: 5, 10, 1, 3");
        for(int i = 0; i < 4; i++)
        {
            sticks.add(test1[i]);
        }

        LinkedList<Integer> stickCopy = new LinkedList<Integer>();
        stickCopy = sticks;

        for(int i = 5; i <= 30; i += 5)
        {
            distance = i;
            h1.calls = 0;
            h1.makeJourney(sticks, distance, " ", h1);
            System.out.println("\t " + distance + ": " + h1.calls + " recursive calls");
            sticks = stickCopy;
        }
        stickCopy.add(7);
        stickCopy.add(4);
        sticks = stickCopy;
        System.out.println("\nTest 2. Input: 5, 10, 1, 3, 7, 4, 11, 25");
        for(int i = 20; i <= 50; i += 10)
        {
            distance = i;
            h1.calls = 0;
            h1.makeJourney(sticks, distance, " ", h1);
            System.out.println("\t " + distance + ": " + h1.calls + " recursive calls");
            sticks = stickCopy;
        }

    }

    public static void main(String[] args)
    {
    	Homework1 h1 = new Homework1();
        h1.calls = 0;
    	LinkedList<Integer> pogoSticks = new LinkedList<Integer>();
    	int distance;
        //pogoSticks.addAll(test);
        h1.prepSticks(pogoSticks, h1);
    	/*Scanner scan = new Scanner(System.in);
    	System.out.println("Enter an input.");

    	distance = scan.nextInt();
    	String str = " ";
    	while(scan.hasNext())
    	{
    		pogoSticks.add(scan.nextInt());
    		System.out.println(pogoSticks.getLast());


    	}
    	scan.close();*/
        //int distance = 5;
        //int numSticks = 4;
        //Integer[] pogoSticks = new Integer[numSticks];
       /* pogoSticks[0] = 5;
        pogoSticks[1] = 10;
        pogoSticks[2] = 1;
        pogoSticks[3] = 3;*/
        //h1.makeJourney(pogoSticks, distance, " ", h1);
        //h1.printJourneys(h1.makeJourney(pogoSticks, distance, " ", h1));
        //System.out.println("Done");
    }
}
