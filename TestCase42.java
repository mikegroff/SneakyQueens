// Kyle Benko
// Java TestCase42.java
//
// Uses code by
// Sean Szumlanski
//
// SneakyQueens: TestCase42.java
//
// Several Kingdoms at war, some at peace, can you determine which ones?

import java.io.*;
import java.util.*;

public class TestCase42
{
	private static void checkTest(boolean success)
	{
		System.out.println(success ? "Hooray!" : "fail whale :(");
	}

	public static void main(String [] args)
	{
		ArrayList<String> list = new ArrayList<String>();

        // Control testcase from Szum
		list.clear();
		list.add("a1");
		list.add("b2");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 2) == false);


        // 1x1 board, one queen, against all odds (actually no odds) is safe
		list.clear();		
		list.add("a1");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 1) == true);


        // 3x3 board filled with queens, a real struggle for power 
		list.clear();
		list.add("a1");
		list.add("b1");
        list.add("c1");
        list.add("a2");
		list.add("b2");
        list.add("c2");
        list.add("a3");
		list.add("b3");
        list.add("c3");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 3) == false);

        // Scattered and safe
        list.clear();
		list.add("a1");
		list.add("d2");
        list.add("b3");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 4) == true);

        // A war splitting sides
        list.clear();
		list.add("a1");
		list.add("d2");
        list.add("b3");
        list.add("e5");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 5) == false);

        // A widow but a ruler
        list.clear();
		list.add("b2");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 4) == true);

        // A dual between monarchs
        list.clear();
		list.add("b2");
        list.add("d4");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 4) == false);

        // Just another check, of 4 queen's power
        list.clear();
		list.add("b2");
        list.add("e5");
        list.add("c4");
        list.add("a5");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 5) == false);

        // all positve diagonal attacks
        list.clear();
		list.add("b2");
        list.add("z26");
        list.add("l12");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 30) == false);

        // All negative diagonal attacks
        list.clear();
		list.add("a5");
        list.add("b4");
        list.add("c3");
        list.add("d2");
        list.add("e1");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 5) == false);

        // A square of death, no one is safe in this land
        list.clear();
		list.add("b2");
        list.add("c2");
        list.add("b3");
        list.add("c3");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 5) == false);

        // Keeping an eye on the enemy but no blood drawn
        list.clear();
		list.add("b2");
        list.add("e3");
        list.add("d6");
        list.add("a5");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 8) == true);

        // Friendly neighbors
        list.clear();
		list.add("b2");
        list.add("c4");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 4) == true);

	}
}
