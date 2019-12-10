package com.stpl.pms.daoImpl.gl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

public class FileMergerDaoImpl {

	public String mergerAllFiles(int gameNo, List<String> fileNames, List<String> virnFileList,
			int no_Of_Tickets_Per_Book, int no_Of_Books_Per_Pack, int totalNoOfPacks) {
		// TODO Auto-generated method stub
		try {
			BufferedReader brTkt = null;
			BufferedReader brVirn = null;
			String line = null;
			String backUpPath = fileNames.get(0);
			String basePath = fileNames.get(0);
			String directoryPath = basePath.substring(0, basePath.lastIndexOf("/") + 1);
			basePath = basePath.substring(basePath.lastIndexOf("/") + 1);
			int index = basePath.lastIndexOf("(");
			basePath = basePath.substring(0, index);
			Calendar cal = Calendar.getInstance();
			String date = (cal.get(Calendar.DATE) > 9 ? cal.get(Calendar.DATE) : "0" + cal.get(Calendar.DATE)) + "-"
					+ ((cal.get(Calendar.MONTH) + 1) > 9 ? (cal.get(Calendar.MONTH) + 1)
							: "0" + (cal.get(Calendar.MONTH) + 1))
					+ "-" + cal.get(Calendar.YEAR);

			String mergeTickets = directoryPath + basePath.substring(0, basePath.lastIndexOf("_"))
					+ "_After-Merge-Final-Tickets.txt";
			String mergeVirn = directoryPath + basePath.substring(0, basePath.lastIndexOf("_"))
					+ "_After-Merge-Final-VIRN.txt";

			String mergeTickets1 = directoryPath + basePath.substring(0, basePath.lastIndexOf("_")) + "_" + date
					+ "_tickets.txt";
			String mergeVirn1 = directoryPath + basePath.substring(0, basePath.lastIndexOf("_")) + "_" + date
					+ "_virn.txt";

			File mergeTicketsfile = new File(mergeTickets1);
			File mergeVirnfile = new File(mergeVirn1);
			if (mergeTicketsfile.createNewFile() && mergeVirnfile.createNewFile()) {
				System.out.println("::::::::::FILE IS CREATED::::::");
			}
			File file = new File(mergeTickets);
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fileWriter);

			File file1 = new File(mergeVirn);
			FileWriter fileWriter1 = new FileWriter(file1.getAbsoluteFile());
			BufferedWriter bw1 = new BufferedWriter(fileWriter1);

			boolean f = true;
			int l = 0;
			System.out.println(":::::::::::::::::::::MERGE TICKET ::::::::::::::::");
			for (String s : fileNames) {
				brTkt = new BufferedReader(new FileReader(s));
				while ((line = brTkt.readLine()) != null) {

					
					bw.write(line);
					
					bw.newLine();
				}

			}
			bw.close();
			brTkt.close();
			f= true;
			l= 0;
			line = null;
			System.out.println("::::::::::MERGE VIRN:::::::::::");
			for (String s : virnFileList) {
				brVirn = new BufferedReader(new FileReader(s));
				while ((line = brVirn.readLine()) != null) {
					
					bw1.write(line);
					bw1.newLine();
				}

			}

			bw1.close();
			brVirn.close();
			System.out.println("Done::::CREATING BACKUP DIRECTORY :::::::::");
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			backUpPath = backUpPath.substring(0, backUpPath.lastIndexOf("/"));
			System.out.println("BACKUP PATH:"+backUpPath);
			CreateBackupDir(gameNo, backUpPath);
			MoveFile(mergeVirn, backUpPath, gameNo);
			MoveFile(mergeTickets, backUpPath, gameNo);
			return "success";

		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}

	}

	public void CreateBackupDir(int gameNo, String path) {
		File file = new File(path + "/docs/.empty");
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");

			} else {
				System.out.println("Failed to create directory!");
			}
		}
		File file1 = new File(path + "/docs/.empty/" + gameNo);
		if (!file1.exists()) {
			if (file1.mkdir()) {
				System.out.println(gameNo + " dir is created!");
			}
		}
	}

	public void MoveFile(String fromPath, String toPath, int gameNo) {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {

			File afile = new File(fromPath);
			String fileName = fromPath.substring(fromPath.lastIndexOf("/"), fromPath.length());
			File bfile = new File(toPath + "/docs/.empty/" + gameNo + fileName);
			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();
			System.out.println("File is copied successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
