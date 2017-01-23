//By Noah Ransom

import java.util.*;

public String makeJourney(int[] sticks, int distance)
{
    LinkedList toReturn;
    String toReturn = " ";
    for(int i = 0; i < sticks.length; i++)
    {
        if(sticks[i] == distance)
        {
            //create a copy of current string that ends here, add to list
            toReturn += (sticks[i].toString); //tostring not for int: fix later
            //added to returns
        }
        else if(sticks[i] >= distance)
        {
            //don't create a copy
            //don't add this to the string
        }
        else
        {
            //copy the current string
            //add this number to it
            toReturn.add(sticks[i].toString)
            return toReturn += makeJourney(sticks, (distance - sticks[i]));
        }
    }
}

class Homework1
{
    public int distance; //how far we need to go
    public int numSticks; //how many pogo sticks there are
    public int[] pogoSticks; //contains jump distances for pogo sticks

    public static void main(String[] args)
    {
        /*distance = 5;
        numSticks = 4;
        pogoSticks = new int[numSticks];
        pogoSticks[0] = 5;
        pogoSticks[1] = 10;
        pogoSticks[2] = 1;
        pogoSticks[3] = 3;
        */
        String foo = "  ";
        int bas = 1;
        char bar = (char)(bas + 48);
        foo += bar;

        System.out.println(foo);
    }
}
