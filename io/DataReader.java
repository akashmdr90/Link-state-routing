package io;

import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReader {

	private int[] portList;

	public int[] getPortList() {
		return portList;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	private int[][] adjMatrix;
	private HashMap portToIndex;

	public DataReader(String[] args) {
		portList = new int[args.length];
		adjMatrix = new int[args.length][args.length];
		portToIndex = new HashMap();
		readPorts(args);
		readNeighboringInfo();
		print2DArray(adjMatrix);
	}

	private void readNeighboringInfo() {
		Scanner sc = new Scanner(System.in);
		int tempPort, tempPortIndex;
		for (int i = 0; i < portList.length; i++) {
			System.out.println("Node " + portList[i]
					+ " neighbor list - Usage: port distance");
			System.out.println("Enter neighbors and cost:");

			do {
				tempPort = sc.nextInt();
				if (tempPort != -1) {
					tempPortIndex = (Integer) portToIndex.get(tempPort);
					int dist = sc.nextInt();
					adjMatrix[i][tempPortIndex] = dist; 
				} else
					sc.nextInt();

			} while (tempPort != -1);
			System.out.println("----------------------------");

		}
	}

	private static void print2DArray(int[][] theArray) {



	try{
    		PrintWriter writer = new PrintWriter("plaintext.txt", "UTF-8");
   		for (int row = 0; row < theArray.length; row++) {
			for (int col = 0; col < theArray[row].length; col++) {
				System.out.print(theArray[row][col] + " ");
				writer.print(theArray[row][col] + " ");
			}
			writer.println();
         		System.out.println();
		}
		writer.close();
	}
	catch (IOException e) {
   	// do something
		}

	}

	private void readPorts(String[] args) {

		try {
			for (int i = 0; i < args.length; i++) {
				portList[i] = Integer.parseInt(args[i]);
				portToIndex.put(portList[i], i);
			}

		} catch (Exception e) {
			System.out
					.println("Usage: program portNo1 portNo2 portNo3 ... portNo_N");
			System.exit(-1);
		}
	}
}
