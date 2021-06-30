package General;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class codility {
	
	static class A {
		
		private A(){
			System.out.println("A");
		}
		
		public static void x() {
			
		}
	}
	
	class B extends A {
		B(){
			System.out.println("B");
			x();
		}
		
	}
	

	public static void main(String[] args) {
		
		System.out.println((3*0.1==0.3));
		
		codility c = new codility();
		
		int x [] = new int [5];
		int i;
		for(i=0; i<x.length; i++) {
			x[i]=i;
		}
		
		System.out.println(x[i]);
		String files = "my.song.mp3 11b\r\n" + "greatSong.flac 1000b\r\n" + "not3.txt 5b\r\n" + "video.mp4 200b\r\n"
				+ "game.exe 100b\r\n" + "mov!e.mkv 10000b";

		HashMap<String, Long> dataMap = new HashMap<>();
		dataMap.put("music", 0L);
		dataMap.put("image", 0L);
		dataMap.put("movie", 0L);
		dataMap.put("other", 0L);
		String[] data = files.split("\n");

		Pattern music = Pattern.compile("[.]*\\.mp3|aac|flac$");
		Pattern image = Pattern.compile("[.]*\\.jpg|bmp|gif$");
		Pattern movie = Pattern.compile("[.]*\\.mp4|avi|mkv$");
		Pattern other = Pattern.compile("[.]*\\.[\\w\\W]+$");
		
		for (String line : data) {
			
			System.out.println(line);

			String[] split = line.split(" ");

			Matcher temp = music.matcher(split[0]);
			if (temp.find()) {
				long curr = dataMap.get("music");
				long newCurr = curr + Long.valueOf(split[1].split("b")[0]);
				dataMap.put("music", newCurr);
				continue;
			}

			temp = image.matcher(split[0]);
			if (temp.find()) {
				long curr = dataMap.get("image");
				long newCurr = curr + Long.valueOf(split[1].split("b")[0]);
				dataMap.put("image", newCurr);
				continue;
			}
			
			temp = movie.matcher(split[0]);
			if (temp.find()) {
				long curr = dataMap.get("movie");
				long newCurr = curr + Long.valueOf(split[1].split("b")[0]);
				dataMap.put("movie", newCurr);
				continue;
			}
			
			temp = other.matcher(split[0]);
			if (temp.find()) {
				long curr = dataMap.get("other");
				long newCurr = curr + Long.valueOf(split[1].split("b")[0]);
				dataMap.put("other", newCurr);
			}
		}
		
		StringBuilder sb = new StringBuilder();
			
		sb.append("music "+dataMap.get("music")+"b\n");
		sb.append("images "+dataMap.get("image")+"b\n");
		sb.append("movies "+dataMap.get("movie")+"b\n");
		sb.append("other "+dataMap.get("other")+"b\n");
			
		System.out.println(sb.toString());

	}

}
