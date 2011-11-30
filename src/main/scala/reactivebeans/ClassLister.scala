package reactivebeans

import java.io.File
import java.net.URLClassLoader

object ClassLister {
  
  def listClasses(classOrPackage: String): List[String] = {
    var res: List[String] = Nil
    
    val runtime = java.lang.management.ManagementFactory.getRuntimeMXBean
    
    //merge visible classpath
    def absPaths(paths: Seq[String]) = paths.map(new File(_).getAbsolutePath()).toSet
    
    val classPath = absPaths(runtime.getClassPath.split(File.pathSeparator)) ++
    absPaths(runtime.getBootClassPath.split(File.pathSeparator)) ++ {
      //add jars found in the classLoader too
      val cls = Seq(getClass.getClassLoader, ClassLoader.getSystemClassLoader())
      val res = for (loader <- cls) yield loader match {
        case ucl: URLClassLoader =>
          ucl.getURLs() map (u => new File(u.toURI).getAbsolutePath())
      }
      res.flatten
    }
    
    for (path <- classPath) {
      if (path.endsWith(".jar")) res ++= findInJar(path, classOrPackage: String)
      else res ++= findInFolder(new File(path), classOrPackage: String)
    }
        
    res
  }
  
  def findInJar(path: String, classOrPackage: String): List[String] = {
    println("Searching in jar " + path)
    import java.util.jar._
    var res: List[String] = Nil
    try {
      val jar = new JarFile(path)
      val entries = jar.entries
      val regex = classOrPackage.replaceAll("\\.", "/").replaceAll("\\*\\*", "[.]*").replaceAll("\\*(?<!\\])", "[^/]*") + "\\.class"
      //    println("Glob regex " + regex)
      val classOrPackageAsPath = classOrPackage.replaceAll("\\.", "/")
      val numOfSlashs = classOrPackageAsPath.count(_ == '/')
      while (entries.hasMoreElements) {
        val entry = entries.nextElement.getName
        if (entry.matches(regex)) {
          res ::= entry.dropRight(6).replaceAll("/", ".")
        }
      }
    } catch {case e => println(e + " while processing jar: " + path + ". Skipped")}
    res
  }
  def findInFolder(folder: File, classOrPackage: String): List[String] = {
    if (folder.isFile()) return Nil
    println("Searching in directory " + folder)
    val regex = classOrPackage.replaceAll("\\.", "/").replaceAll("\\*\\*", "[.]*").replaceAll("\\*(?<!\\])", "[^/]*") + "\\.class"
    def classNameFromFile(file: File) = file.getPath.replaceAll("\\.class", "").replaceAll("/", ".")
    var res: List[String] = Nil
    
    def traverse(folder: File) { //naive recurse, may result in StackOverflow
      val fileList = folder.listFiles //might be null
      if (fileList != null) {
        for (file <- folder.listFiles) {
          if (file.isFile) { if (file.getPath matches regex) res ::= classNameFromFile(file) }
          else traverse(file)
        }
      }
    }
    traverse(folder)
    res
  }
}
