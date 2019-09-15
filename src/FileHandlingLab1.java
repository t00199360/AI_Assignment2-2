import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandlingLab1
{
    public static void main(String[] args)
    {
        //declare an ArrayList instance
        ArrayList<String> myAList = new ArrayList<>();
        int size = 0;
        //declare a LinkedList instance
        LinkedList<String> myLList = new LinkedList<>();
        //populate both lists with contents of a data file

        try
        {   // The name of the file which we will read from
            String filename = "words_alpha.txt";

            // Prepare to read from the file, using a Scanner object
            File file = new File(filename);
            Scanner in = new Scanner(file);

            // Read each line until end of file is reached
            while (in.hasNextLine())
            {
                // Read one string from the file
                String str = in.nextLine();
                // add str to ArrayList and LinkedList
                myAList.add(str);
                myLList.add(str);
                size++;
            }
            System.out.println("Function hasNextLine has reached its end");
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");

        }
        System.out.println("size of file: " + size);

        long startTimeAList = System.nanoTime();
        testGetForArrayList(myAList);       //GetArrayList
        long endTimeAList = System.nanoTime();
        long duration = (endTimeAList - startTimeAList);
        System.out.println("The duration of the method get ArrayList in milliseconds is: " + duration/1000000);

        long startTime = System.nanoTime();
        testGetForLinkedList(myLList);      //GetLinkedList
        long endTime = System.nanoTime();

        long durationLinkedList = (endTime - startTime);
        System.out.println("The duration of the method get LinkedList in milliseconds is: " + durationLinkedList/1000000);



        long startTimeSetArrayList = System.nanoTime();
        testSetForList(myAList);                //SetArrayList
        long endTimeSetArrayList = System.nanoTime();

        long durationSetArrayList = (endTimeSetArrayList - startTimeSetArrayList);
        System.out.println("The duration of the method set ArrayList in milliseconds is: " + durationSetArrayList/1000000);

        long startTimeSetLinkedList = System.nanoTime();
        testSetForList(myLList);                //SetLinkedList
        long endTimeSetLinkedList = System.nanoTime();

        long durationSetLinkedList = (endTimeSetLinkedList - startTimeSetLinkedList);
        System.out.println("The duration of the method set LinkedList in milliseconds is: " + durationSetLinkedList/1000000);


        long startTimeInsertArrayList = System.nanoTime();
        testInsertForList(myAList);                //InsertArrayList
        long endTimeInsertArrayList = System.nanoTime();

        long durationInsertArrayList = (endTimeInsertArrayList - startTimeInsertArrayList);
        System.out.println("The duration of the method Insert ArrayList in milliseconds is: " + durationInsertArrayList/1000000);

        long startTimeInsertLinkedList = System.nanoTime();
        testInsertForList(myLList);                //InsertLinkedList
        long endTimeInsertLinkedList = System.nanoTime();

        long durationInsertLinkedList = (endTimeInsertLinkedList - startTimeInsertLinkedList);
        System.out.println("The duration of the method Insert LinkedList in milliseconds is: " + durationInsertLinkedList/1000000);

        long startTimeRemoveArrayList = System.nanoTime();
        testRemoveForList(myAList);                //RemoveArrayList
        long endTimeRemoveArrayList = System.nanoTime();

        long durationRemoveArrayList = (endTimeRemoveArrayList - startTimeRemoveArrayList);
        System.out.println("The duration of the method Remove ArrayList in milliseconds is: " + durationRemoveArrayList/1000000);

        long startTimeRemoveLinkedList = System.nanoTime();
        testRemoveForList(myLList);                //removeLinkedList
        long endTimeRemoveLinkedList = System.nanoTime();

        long durationRemoveLinkedList = (endTimeRemoveLinkedList - startTimeRemoveLinkedList);
        System.out.println("The duration of the method remove LinkedList in milliseconds is: " + durationRemoveLinkedList/1000000);

    }

    private static void testGetForArrayList(ArrayList list)
    {
        testGetForList(list);
    }
    private static void testGetForLinkedList(LinkedList list)
    {
        testGetForList(list);
    }

    private static void testGetForList(List list)
    {
        int listSize = list.size();
        Random random = new Random();
        int reps = 50000;
        for(int i = 0; i < reps; i++) {
            // reps is the number of repetitions
            // declare reps as something large e.g. 50000
            list.get(random.nextInt(listSize)); // list is your list
            // (ArrayList or LinkedList)
        }
    }
    private static void testInsertForList(List list)
    {
        int reps= 50000;
        for (int i = 0; i< reps; i++)
            list.add(5, "Test");    //minimise RA cost
    }
    private static void testSetForList(List list)
    {
        int listSize = list.size();
        Random random = new Random();
        int reps = 50000;
        for (int i = 0; i < reps; i ++)
            list.set(random.nextInt(listSize), "test");
    }

    private static void testRemoveForList (List list)
    {
        while (list.size() > 5)
            list.remove(5);
    }

}
