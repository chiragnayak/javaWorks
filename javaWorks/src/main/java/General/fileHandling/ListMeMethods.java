package General.fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.naming.spi.DirStateFactory.Result;

public class ListMeMethods {

	static String path = "C:\\Eclipse_Workspace_head\\SwiftEmbDriver\\src\\main\\java";

	static boolean debug = false;

	static int count = 0;

	static int start = path.length() + 1;
	
	static HashMap<String, Integer> mapping = new HashMap<>();

	public static void main(String[] args) throws Exception {

		File folder = new File(path);
		updateDirectory(folder);
		System.out.println("Done !!");

//		EmbUtils.printCentreAlignedBanner("Total " + count);
	}

	public static void updateDirectory(File folder) throws Exception {

		for (File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory() && !fileEntry.getName().equalsIgnoreCase("CVS")) {

				updateDirectory(new File(fileEntry.getPath()));

				String path = fileEntry.getAbsolutePath().substring(start);

//				System.out.println("Processing : " + path);
//				System.out.println("++++++++++++++++++++++++++");

				getApolloContainer(path);

			}
		}

	}

	public static ArrayList<Class> getApolloContainer(String containerKeyword) throws Exception {

		Class[] clazzIt = null;

		ArrayList<Class> xxx = new ArrayList<>();

		if (path.contains(".jar")) {
			clazzIt = getClassNamesInPackage(path, "src.main.java");
		} else {
			clazzIt = getClassesInPackage(containerKeyword, null);
		}

		for (Class currentClass : clazzIt) {
			
			int countForClass = 0;

			boolean found = false;

			Method[] fields = currentClass.getDeclaredMethods();

			for (Method curr : fields) {

				if (curr.getReturnType().isAssignableFrom(Result.class)) {

					countForClass++;

				}

			}

			if(!currentClass.getName().contains("Enum") && currentClass.getName().contains("swift.drivers.embDriver.interfaces.actions.")){
				
				String [] name = currentClass.getName().split("\\.");
				
				if(mapping.get(name[name.length-1].trim())==null){
					
					System.out.println(name[5] +", "+name[name.length-1]+","+countForClass);
					mapping.put(name[name.length-1], countForClass);
					count = countForClass + count;
				}
				
				
			}

		}

		return xxx;

	}

	/*
	 * *************************************************************************
	 * *************************************
	 * 
	 * Scans all classes accessible from the context class loader which belong
	 * to the given package and sub-packages. and extended to support use of JAR
	 * files
	 * 
	 * @param packageName The base package
	 * 
	 * @param regexFilter an optional class name pattern.
	 * 
	 * @return The classes
	 * 
	 * *************************************************************************
	 * *************************************
	 */
	public static Class[] getClassesInPackage(String packageName, String regexFilter)

	{
		Pattern regex = null;
		if (regexFilter != null)
			regex = Pattern.compile(regexFilter);

		try {

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			assert classLoader != null;
			String path = packageName.replace('\\', '/');
			Enumeration resources = classLoader.getResources(path);
			List<String> dirs = new ArrayList();
			while (resources.hasMoreElements()) {
				URL resource = (URL) resources.nextElement();
				dirs.add(resource.getFile());
			}
			TreeSet<String> classes = new TreeSet();
			for (String directory : dirs) {
				classes.addAll(findClasses(directory, packageName.replace('\\', '/').replaceAll("/", "."), regex));
			}
			ArrayList classList = new ArrayList();
			for (String clazz : classes) {
				classList.add(Class.forName(clazz));

			}

			// Iterator x = classList.iterator();
			//
			// while(x.hasNext()){
			// System.out.println(x.next());
			// }

			return (Class[]) classList.toArray(new Class[classes.size()]);

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * *************************************************************************
	 * *************************************
	 * 
	 * Recursive method used to find all classes in a given path (directory or
	 * zip file url). Directories are searched recursively.
	 * 
	 * @param path The base directory or url from which to search.
	 * 
	 * @param packageName The package name for classes found inside the base
	 * directory
	 * 
	 * @param regex an optional class name pattern. e.g. .*Test
	 * 
	 * @return The classes
	 * 
	 ***************************************************************************************************************/
	private static TreeSet findClasses(String path, String packageName, Pattern regex) throws Exception {
		TreeSet classes = new TreeSet();
		if (path.startsWith("file:") && path.contains("!")) {

			String[] split = path.split("!");
			URL jar = new URL(split[0]);
			ZipInputStream zip = new ZipInputStream(jar.openStream());
			ZipEntry entry;

			while ((entry = zip.getNextEntry()) != null) {
				if (entry.getName().endsWith(".class")) {
					String className = entry.getName().replaceAll("[$].*", "").replaceAll("[.]class", "").replace('/',
							'.');

					if (className.startsWith(packageName) && (regex == null || regex.matcher(className).matches())) {
						// System.out.println("--ENTRY NAME
						// "+entry.getName()+"----$$-- CLASS NAME -$$--
						// "+className+"-------##-- PACKAGE NAME -##--
						// "+packageName);
						classes.add(className);
					}

				}
			}
		}

		File dir = new File(path);

		if (!dir.exists()) {
			return classes;
		}

		File[] files = dir.listFiles();

		for (File file : files) {
			// System.out.println("----- FILE NAME ---- "+file.getName());

			if (file.isDirectory())

			{
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file.getAbsolutePath(), packageName + "." + file.getName(), regex));
			} else if (file.getName().endsWith(".class")) {

				String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);

				// System.out.println("----- CLASS NAME ---- "+className);

				if (regex == null || regex.matcher(className).matches())
					classes.add(className);
			}
		}

		return classes;

	}

	/**
	 * 
	 * To Fetch Class Names and hence return class(es) in package name from
	 * inside the jar file.
	 * 
	 * @param jarName
	 * @param packageName
	 * @return
	 */
	public static Class[] getClassNamesInPackage(String jarName, String packageName) {

		boolean debug = false;

		ArrayList<String> classes = new ArrayList<String>();

		packageName = packageName.replaceAll("\\.", "/");
		System.out.println("Jar Name : " + jarName + " | Looking for " + packageName);
		try {
			JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
			JarEntry jarEntry;

			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if ((jarEntry.getName().startsWith(packageName)) && (jarEntry.getName().endsWith(".class"))) {
					if (debug)
						System.out.println("Found " + jarEntry.getName().replaceAll("/", "\\."));
					classes.add(jarEntry.getName().replaceAll("/", "\\."));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<Class> classesToReturn = new ArrayList<Class>();

		Pattern p = Pattern.compile("([\\w\\W]*).class");

		for (String className : classes) {

			Matcher m = p.matcher(className);

			if (m.find()) {
				try {
					classesToReturn.add(Class.forName(m.group(1)));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		return classesToReturn.toArray(new Class[classesToReturn.size()]);
	}

}
