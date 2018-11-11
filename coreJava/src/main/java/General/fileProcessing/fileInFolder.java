package General.fileProcessing;

import java.io.File;

public class fileInFolder {
	
	static String path = "C:\\backup\\NxtGenNptEmbDriver";

	public static void main(String[] args) {
		File folder = new File(path);
		updateDirectory(folder);
		System.out.println("Done !!");
	}
	public static void updateDirectory(File folder) {
		
	    for (File fileEntry : folder.listFiles()) {
	    	
	    	System.out.println("Processing : "+fileEntry.getName());
	    	
	        if (fileEntry.isDirectory()) {
	        	
	        	fileEntry.setReadable(true);
	        	fileEntry.setWritable(true);
	        	
	        	if(fileEntry.getName().contains("CVS")){
	        		deleteFolder(fileEntry);
	        		continue;
	        	}else{
	        		updateDirectory(new File(fileEntry.getPath()));
	        	}
	        	
	        	File f1 = new File(fileEntry.getPath());
	        	File f2 = new File(fileEntry.getPath().replace("NPT", "NxtGen").replace("Npt", "NxtGen").replace("npt", "NxtGen"));
	        	
	        	updateDirectory(fileEntry);
	        	
	        	if(fileEntry.getName().contains("NPT") ||
	        			fileEntry.getName().contains("Npt") ||
	        			fileEntry.getName().contains("npt")){
		        	if(f1.renameTo(f2)){
		        		System.out.println("RENAMED DIR : "+fileEntry.getAbsolutePath());
		        	}else{
		        		System.err.println("RENAMED DIR FAILED : "+fileEntry.getAbsolutePath());
		        	}
		        	
	        	}
	        	
	        }else{
	        	
	        	if(fileEntry.getName().contains("NPT") ||
	        			fileEntry.getName().contains("Npt") ||
	        			fileEntry.getName().contains("npt")){
	        		File f1 = new File(fileEntry.getPath());
	        		f1.setReadable(true);
	        		f1.setWritable(true);
		        	File f2 = new File(fileEntry.getPath().replace("NPT", "NxtGen").replace("Npt", "NxtGen").replace("npt", "NxtGen"));
		        	f2.setReadable(true);
	        		f2.setWritable(true);
		        	if(f1.renameTo(f2)){
		        		System.out.println("RENAMED FILE : "+fileEntry.getAbsolutePath());
		        	}else {
		        		System.err.println("RENAMED FILE FAILED : "+fileEntry.getAbsolutePath());
		        	}
		        	
	        	}
	        	
	        	
	        }
	    }
	}
	
	public static void deleteFolder(File folder){
		for(File file : folder.listFiles()){
			
			if (file.isDirectory()) {
	        		deleteFolder(file);
	        }
			
			if(file.delete()){
				System.out.println("DELETED FILE : "+file.getAbsolutePath());
			}else{
				System.err.println("CANNOT DELETE FILE : "+file.getAbsolutePath());
			}
		}
		
		if(folder.delete()){
			System.out.println("DELETED DIR : "+folder.getAbsolutePath());
		}else{
			System.err.println("CANNOT DELETE DIR : "+folder.getAbsolutePath());
		}
		
	}
}
