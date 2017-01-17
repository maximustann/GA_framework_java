/*
 * Boxiong Tan (Maximus Tann)
 * Title:        GA framework
 * Description:  GA framework for general optimization purpose
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2016-2019, The Victoria University of Wellington
 * WriteFileHai.java - write result to file
 */
package wsrp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import FileHandlers.WriteByRow;

public class WriteFileWSRP {
	private WriteByRow fitnessWriter;
	private WriteByRow timeWriter;
	private String fitnessAddr;
	private String timeAddr;
	private String base;

	/**
	 *
	 * @param fitnessAddr an address to store fitness results
	 * @param timeAddr an address to store time results
	 */
	public WriteFileWSRP(String fitnessAddr, String timeAddr){
//		fitnessWriter = new WriteByRow(",", 6);
//		timeWriter = new WriteByRow(",", 1);
		this.fitnessAddr = fitnessAddr;
		this.timeAddr = timeAddr;
	}

	public WriteFileWSRP(String base){
		this.base = base;
	}
	public void writeGenerationsFitnessToFile(ArrayList<ArrayList<double[]>> fitness) throws IOException {
		int generation = fitness.size();
		for(int i = 0; i < generation; i++){
			String generationAddr = base + "/generationFitness/" + i;
			File dir = new File(generationAddr);
			dir.mkdir();
			generationAddr += "/fitness.csv";
			fitnessWriter = new WriteByRow(",", 0);
			fitnessWriter.writeArray(generationAddr, fitness.get(i));
		}
		System.out.println("Done");
	}

	/**
	 * write results to files.
	 * @param fitness fitness values
	 * @param time time values
	 * @throws IOException
	 */
	public void writeResults(ArrayList<ArrayList<double[]>> fitness, ArrayList<Double> time,
							Object nonDonSet) throws IOException{
		fitnessWriter = new WriteByRow(",", 0);
		timeWriter = new WriteByRow(",", 1);
		WriteByRow nonDonSetWriter = new WriteByRow(",", 1);

		for(int i = 0; i < fitness.size(); i++){
			String runAddr = base + "/runFitness/" + i;
			fitnessAddr = base + "/runFitness/" + i + "/fitness.csv";
			timeAddr = base + "/runFitness/" + i + "/time.csv";
			String nonDonSetAddr = base + "/runFitness/" + i + "/nonDominatedSet.csv";
			File dir = new File(runAddr);
			fitnessWriter.writeArray(fitnessAddr, fitness.get(i));
			ArrayList<Double> tempTime = new ArrayList<Double>();
			tempTime.add(time.get(i));
			timeWriter.write(timeAddr, tempTime);
			nonDonSetWriter.writeArray(nonDonSetAddr, ((ArrayList<ArrayList<double[]>>) nonDonSet).get(i));
		}
	}
}
