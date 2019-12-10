package com.stpl.pms.daoImpl.gl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.stpl.pms.security.ZipFileProtection;

public class Shuffler {

	public static String shuffler(int gameNo, int totalNoOfPacks, int taotalNoOfBooks, int ticketsInBook,
			String tktFile, int batchNo, int startingPack) throws IOException {

		try {

			int packD =4;
			int bookD = 2;
			int tktD = 3;
			int virnD = 11;
			int gameD = 3;

			String filePath = (tktFile.substring(0, tktFile.lastIndexOf("_")));
			String shuffledFinalTickets = filePath.substring(0, filePath.lastIndexOf("_")) + "_" + batchNo
					+ "-shuffled.txt";
			String virnFileForRetail = filePath.substring(0, filePath.lastIndexOf("_")) + "_" + batchNo
					+ "_VIRN_Ticket_1234.txt";

			String bookListing = filePath.substring(0, filePath.lastIndexOf("_")) + "_" + batchNo + "_bookListing.txt";
			String packListing = filePath.substring(0, filePath.lastIndexOf("_")) + "_" + batchNo + "_packListing.txt";
			String halfPackBookListing = filePath.substring(0, filePath.lastIndexOf("_")) + "_" + batchNo
					+ "_halfPackBookListing.txt";

			List<String> packShuffledData = new ArrayList<String>();
			List<String> bookShuffledData = new ArrayList<String>();
			List<String> tktShuffledData = new ArrayList<String>();
			List<Integer> pknos = new ArrayList<Integer>();
			List<Integer> bknos = new ArrayList<Integer>();
			List<Integer> tktnos = new ArrayList<Integer>();
			for (int i = startingPack; i < startingPack + totalNoOfPacks; i++) {
				pknos.add(i);
			}
			Collections.shuffle(pknos);
			for (int i = 1; i <= taotalNoOfBooks; i++) {
				bknos.add(i);
			}
			Collections.shuffle(bknos);

			for (int i = 1; i <= ticketsInBook; i++) {
				tktnos.add(i);
			}
			Collections.shuffle(tktnos);
			int mainCtr = 0;
			BufferedReader br1 = null;
			String line = null;
			String newLine = null;
			File file = new File(shuffledFinalTickets);
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fileWriter);
			File file2 = new File(virnFileForRetail);
			FileWriter fileWriter2 = new FileWriter(file2.getAbsoluteFile());
			BufferedWriter bw2 = new BufferedWriter(fileWriter2);
			File file3 = new File(bookListing);
			FileWriter fileWriter3 = new FileWriter(file3.getAbsoluteFile());
			BufferedWriter bw3 = new BufferedWriter(fileWriter3);
			File file4 = new File(packListing);
			FileWriter fileWriter4 = new FileWriter(file4.getAbsoluteFile());
			BufferedWriter bw4 = new BufferedWriter(fileWriter4);
			File file5 = new File(halfPackBookListing);
			FileWriter fileWriter5 = new FileWriter(file5.getAbsoluteFile());
			BufferedWriter bw5 = new BufferedWriter(fileWriter5);
			br1 = new BufferedReader(new FileReader(tktFile));
			int noOfLines = 0;
			int pkNoControl = 1;
			int onlyONE = 0;
			List<String> listDup1 = new ArrayList<>();
			while ((line = br1.readLine()) != null) {
				mainCtr += 1;
				noOfLines += 1;
				if (noOfLines > taotalNoOfBooks * ticketsInBook) {
					pkNoControl += 1;
					noOfLines = 1;
				}

				line = line.substring(gameD + packD + bookD + tktD);
				newLine = line.substring(0, virnD) + '\t' + gameNo
						+ stringFormater(pknos.get(pkNoControl - 1).toString(), packD);

				newLine = newLine + line.substring(virnD + 4 + 2 * gameD + 2 * packD + bookD + tktD);// 33
				packShuffledData.add(newLine);
				// listDup1.add(newLine.substring(11, 23));//10115680186
				// System.out.println(newLine.substring(11, 23));
			}
			br1.close();
			// System.out.println("OKKKKKKKKKKK");
			System.out.println(":::::::::::::::::::pack level shuffling Successfully done:::::::::::::::::");

			List<String> listDup2 = new ArrayList<>();

			System.out.println("at 68" + mainCtr);
			mainCtr = 0;
			noOfLines = 0;
			int bkNoControl = 0;
			for (String s : packShuffledData) {
				noOfLines += 1;
				mainCtr += 1;
				if (noOfLines > ticketsInBook) {
					noOfLines = 1;
					bkNoControl += 1;
					if (bkNoControl > taotalNoOfBooks - 1) {
						bkNoControl = 0;
					}

				}

				newLine = s.substring(0, virnD + 1 + gameD + packD)
						+ stringFormater(bknos.get(bkNoControl).toString(), bookD);
				newLine = newLine + s.substring(virnD + 1 + gameD + packD + bookD);// 2
				// listDup2.add(newLine.substring(11, 23));
				bookShuffledData.add(newLine);

			}
			System.out.println("line 102   " + findDuplicates(listDup2).size());

			// System.out.println("OKKKKKKKKKKK");

			// System.out.println("at 107 " + bookShuffledData.size());
			System.out.println(":::::::::::::::::::book level shuffling Successfully done:::::::::::::::::");

			List<String> listDup3 = new ArrayList<>();
			noOfLines = 0;
			mainCtr = 0;
			int tktNoControl = 0;
			for (String s : bookShuffledData) {
				noOfLines += 1;
				mainCtr += 1;
				if (noOfLines > ticketsInBook) {
					noOfLines = 1;
					Collections.shuffle(tktnos);
					tktNoControl = 0;

					if (tktNoControl > ticketsInBook) {
						tktNoControl = 0;
					}

				}
				newLine = s.substring(0, virnD + 1 + gameD + packD + bookD)
						+ stringFormater(tktnos.get(tktNoControl).toString(), tktD);
				newLine = newLine + s.substring(virnD + 1 + gameD + packD + bookD + tktD);// 24
				tktShuffledData.add(newLine); //
				listDup3.add(newLine.substring(11, 23));
				tktNoControl += 1;

			}

			// System.out.println("line 135 " +
			// findDuplicates(listDup3).size());

			/* System.out.println("at 135     " + tktShuffledData.size()); */

			// System.out.println(":::::::::::::::::::tkt level shuffling
			// Successfully done:::::::::::::::::");

			TreeMap<String, String> sortedTicketDataAfterShuffling = new TreeMap<>();
			List<String> listDup = new ArrayList<>();
			// HashMap<Integer, String> hmap = new HashMap<Integer, String>();
			mainCtr = 0;
			noOfLines = 0;
			System.out.println("before : " + bookShuffledData.size());

			for (String s : tktShuffledData) {
				noOfLines += 1;
				mainCtr += 1;

				newLine = s.substring(0, virnD) + "\t" + gameNo + "-"
						+ s.substring(virnD + 1 + gameD, virnD + 1 + gameD + packD)
						+ s.substring(virnD + 1 + gameD + packD, virnD + 1 + gameD + packD + bookD) + "-"
						+ s.substring(virnD + 1 + gameD + packD + bookD, virnD + 1 + gameD + packD + bookD + tktD)
						+ "\t" + s.substring(virnD + 1);
				sortedTicketDataAfterShuffling.put(s.substring(virnD + 1, virnD + 1 + gameD + packD + bookD + tktD),
						s.substring(virnD + 1, virnD + 1 + gameD + packD + bookD + tktD) + newLine);

				// listDup.add(s.substring(11, 23));
			}
			System.out.println("at 156  :: " + findDuplicates(listDup).size());

			Map<String, String> virnWithTicketMapping = new LinkedHashMap<String, String>();

			mainCtr = 0;
			Set set = sortedTicketDataAfterShuffling.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				mainCtr += 1;
				Map.Entry mentry = (Map.Entry) iterator.next();
				bw.write(mentry.getValue().toString());

				virnWithTicketMapping.put(mentry.getValue().toString().substring(12, 23),
						mentry.getValue().toString().substring(24, 38));

				bw.newLine();

			}
			bw.close();

			System.out.println(":::::::::::::::::::Sorting Done :::::::::::::::::");
			// copyShuffledFile(shuffledFinalTickets, filePath, gameNo);

			Map<String, String> virndata = new HashMap<String, String>();

			BufferedReader brt = null;
			String file1 = filePath + "_After-Merge-Final-VIRN.txt";
			brt = new BufferedReader(new FileReader(file1));
			String line1 = null;
			while ((line1 = brt.readLine()) != null) {
				virndata.put(line1.substring(5), line1);
			}
			brt.close();

			Set set1 = virnWithTicketMapping.entrySet();
			Iterator iterator1 = set.iterator();
			while (iterator1.hasNext()) {
				Map.Entry mentry = (Map.Entry) iterator1.next();
				// System.out.println(mentry.getValue().toString().substring(0,
				// 11));
				bw2.write(virndata.get(mentry.getValue().toString().substring(12, 23)));
				bw2.write("\t");
				bw2.write(mentry.getValue().toString().substring(24, 38));
				bw2.write("\t");
				bw2.write("1234");
				bw2.newLine();
				/*
				 * bw3.write(mentry.getValue().toString().substring(0, 9) +
				 * "\t"); bw3.write(mentry.getValue().toString().substring(24,
				 * 34)); bw3.newLine();
				 * 
				 * bw4.write(mentry.getValue().toString().substring(0, 6) +
				 * "\t"); bw4.write(mentry.getValue().toString().substring(24,
				 * 31)); bw4.newLine();
				 */

			}

			for (int x = 1; x <= totalNoOfPacks; x++) {
				for (int y = 1; y <= taotalNoOfBooks; y++) {
					bw3.write(String.valueOf(gameNo) + stringFormater(Integer.toString(x), packD)
							+ stringFormater(Integer.toString(y), bookD) + "\t");
					bw3.write(String.valueOf(gameNo) + "-" + stringFormater(Integer.toString(x), packD)
							+ stringFormater(Integer.toString(y), bookD));
					bw3.newLine();
					if (y == 1 || y == (taotalNoOfBooks / 2) || y == ((taotalNoOfBooks / 2) + 1)
							|| y == taotalNoOfBooks) {
						bw5.write(String.valueOf(gameNo) + stringFormater(Integer.toString(x), packD)
								+ stringFormater(Integer.toString(y), bookD) + "\t");
						bw5.write(String.valueOf(gameNo) + "-" + stringFormater(Integer.toString(x), packD)
								+ stringFormater(Integer.toString(y), bookD));
						bw5.newLine();
					}

				}
				bw4.write(String.valueOf(gameNo) + stringFormater(Integer.toString(x), packD) + "\t");
				bw4.write(String.valueOf(gameNo) + "-" + stringFormater(Integer.toString(x), packD));
				bw4.newLine();
			}
			bw2.close();
			bw3.close();
			bw4.close();
			bw5.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		ZipFileProtection.sms_mail_activity = 0;
		return "success";

	}

	/*
	 * private static void copyShuffledFile(String frompath, String toPath, int
	 * gameNo) { // TODO Auto-generated method stub try { if
	 * (frompath.contains("TextFiles")) { InputStream inStream = null;
	 * OutputStream outStream = null; File afile = new File(frompath); String
	 * fileName = frompath.substring(frompath.lastIndexOf("/"),
	 * frompath.length()); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); toPath = toPath.substring(0,
	 * toPath.lastIndexOf("/")); File bfile = new File(toPath + "/docs/.empty/"
	 * + gameNo + fileName); inStream = new FileInputStream(afile); outStream =
	 * new FileOutputStream(bfile); byte[] buffer = new byte[1024]; int length;
	 * while ((length = inStream.read(buffer)) > 0) {
	 * 
	 * outStream.write(buffer, 0, length);
	 * 
	 * }
	 * 
	 * inStream.close(); outStream.close();
	 * 
	 * }
	 * 
	 * else { System.out.println(":::::NO COPY OF SHUFFLED FILE :::::"); } }
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	private static String stringFormater(String value, int packD) {

		int t = value.length();
		String temp = "";
		for (int i = t; i < packD; i++) {
			temp += "0";
		}

		return temp.concat(value);
	}

	public static Set<String> findDuplicates(List<String> listContainingDuplicates) {

		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}
		return setToReturn;
	}
}