//Ibrahim Mohamed

package arraysibrahimmohamed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraysIbrahimMohamed
{

    public static void main(String[] args) throws Exception
    {
        String sNum;
        double gpa, range1 = 0.0, range2 = 0.49;
        int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0, r7 = 0, r8 = 0;

        List<Integer> tempStars = new ArrayList<>();
        List<Integer> stars = new ArrayList<>();
        List<String> students = new ArrayList<>();
        List<Double> gpaArray = new ArrayList<>();

        Scanner gpaData = new Scanner(new File("studentdata.txt"));

        while (gpaData.hasNext())
        {
            sNum = gpaData.next();
            students.add(sNum);

            gpa = gpaData.nextDouble();
            gpaArray.add(gpa);
        }

        for (int i = 0; i < gpaArray.size(); i++)
        {
            double num = gpaArray.get(i);
            if (num >= 0.0 && num < 0.5)
            {
                r1++;
            } else if (num >= 0.5 && num < 1.0)
            {
                r2++;
            } else if (num >= 1.0 && num < 1.5)
            {
                r3++;
            } else if (num >= 1.5 && num < 2.0)
            {
                r4++;
            } else if (num >= 2.0 && num < 2.5)
            {
                r5++;
            } else if (num >= 2.5 && num < 3.0)
            {
                r6++;
            } else if (num >= 3.0 && num < 3.5)
            {
                r7++;
            } else if (num >= 3.5 && num <= 4.0)
            {
                r8++;
            }
        }

        tempStars.add(r1);
        tempStars.add(r2);
        tempStars.add(r3);
        tempStars.add(r4);
        tempStars.add(r5);
        tempStars.add(r6);
        tempStars.add(r7);
        tempStars.add(r8);

        for (int i = 0; i < tempStars.size(); i++)
        {
            int num = tempStars.get(i);
            num = ((num + 5) / 10) * 10;
            stars.add(num);
        }

        for (int i = 0; i < stars.size(); i++)
        {
            if (range2 != 3.99)
            {
                System.out.println(range1 + " to " + range2 + " \t ("
                        + tempStars.get(i) + ") \t " 
                        + repeat("*", stars.get(i) / 10));
                range1 += .5;
                range2 += .5;
            } else
            {
                range2 += 0.01;
                System.out.println(range1 + " to " + range2 + " \t ("
                        + tempStars.get(i) + ") \t " + repeat("*", stars.get(i) / 10));
            }
        }
        
        System.out.println("\n");

        for (int i = 0; i < gpaArray.size(); i++)
        {
            int rank = 1;
            int tie = -1;
            for (int j = 0; j < gpaArray.size(); j++)
            {
                double num1 = gpaArray.get(i);
                double num2 = gpaArray.get(j);

                if (num1 < num2)
                {
                    rank++;
                } else if (num1 == num2)
                {
                    tie++;
                }
            }
            switch (tie)
            {

                case 0:
                    System.out.println(students.get(i) + "  \t" + gpaArray.get(i)
                            + "\t" + rank);
                    break;
                case 1:
                    System.out.println(students.get(i) + "  \t" + gpaArray.get(i)
                            + "\tT" + rank + " with " + tie + " other");
                    break;
                default:
                    System.out.println(students.get(i) + "  \t" + gpaArray.get(i)
                            + "\tT" + rank + " with " + tie + " others");
                    break;
            }
        }
    }

    public static String repeat(String str, int times)
    {
        return new String(new char[times]).replace("\0", str);
    }

}
