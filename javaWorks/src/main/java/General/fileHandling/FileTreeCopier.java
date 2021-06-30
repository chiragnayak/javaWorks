package General.fileHandling;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

import General.PrintUtility;

public class FileTreeCopier {
	
	static String  names = "CeserCardCreator,Npb1_10ad,Npbc_20p_ge_2p_ge10_t,Npbc_20p_ge,Npbc_40p_ge_t,Npbc_40p_ge,Npbc_4p_ge10_t,Npbe1_10ad_e,PHYC_20P_GE_2P_GE10_T";

	static String path = "C:\\Users\\cnayak\\testCopy\\SwiftCeserEmbDriver\\src\\main\\java";
	static String targetpath = "C:\\Users\\cnayak\\testCopy\\NxtGenCeserEmbDriver\\src\\main\\java";

	static boolean debug = false;

	static int count = 0;

	static int start = path.length() + 1;
	
	static HashMap<String, Integer> mapping = new HashMap<>();
	
	static ArrayList<String> replaceMe = new ArrayList<>();
	
	static ArrayList<String> replaced = new ArrayList<>();
	static ArrayList<String> preserved = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		replaceMe = (ArrayList<String>) Arrays.stream(names.split(",")).collect(Collectors.toList());

		File folderSource = new File(path);
		File folderTarget = new File(targetpath);
		updateDirectory(folderSource, folderTarget);
		System.out.println("Done !!");

		PrintUtility.printBanner("Total " + count);
	}

	public static void updateDirectory(File folderSource, File folderTarget) throws Exception {

		for (File fileEntry : folderSource.listFiles()) {
			
			if(fileEntry.getName().equalsIgnoreCase("CVS")){
				return;
			}

			if (fileEntry.isDirectory()) {
				
				File sourcePath = new File(fileEntry.getPath());
				
				File targetPathMapped = new File(fileEntry.getPath().replace(path, targetpath));
				
				updateDirectory(sourcePath, targetPathMapped);

			}else{

				String [] struc = fileEntry.getPath().split("\\\\");
				
				String name = struc[struc.length-1].split(".java")[0].trim();
				
				if(replaceMe.contains(name)){
					File sourcePath = new File(fileEntry.getPath());
					
					File targetPathMapped = new File(fileEntry.getPath().replace(path, targetpath));

					Files.copy(sourcePath.toPath(), targetPathMapped.toPath(),StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Processed .. "+name);
					replaced.add(name);
				}else{
					System.out.println("Skipped .. "+name);
					preserved.add(name);
				}
				
			}
		}

	}
}
