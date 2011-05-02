/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reactivebeans

import java.io.File

object ClassLister {
  
  def listClasses(classOrPackage: String): List[String] = {
    var res: List[String] = Nil
    
    val runtime = java.lang.management.ManagementFactory.getRuntimeMXBean
    
//    println("Classpath: " + runtime.getClassPath)
//    println("Boot Classpath: " + runtime.getBootClassPath)
    var classPath = runtime.getClassPath.split(File.pathSeparator)
    classPath ++= runtime.getBootClassPath.split(File.pathSeparator) filter (_.endsWith("rt.jar"))
    
    Thread.currentThread.getContextClassLoader match {
      case urlCL: java.net.URLClassLoader =>
        urlCL.getURLs
      case _ => 
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
    val jar = new JarFile(path)
    val entries = jar.entries
    var res: List[String] = Nil
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
    res
  }
  def findInFolder(folder: File, classOrPackage: String): List[String] = {
    println("Searching in directory " + folder)
//    val regex = classOrPackage.replaceAll("\\.", "/").replaceAll("**", "[.]*").replaceAll("*(?<!\\])", "[^/]*")
//    println("Glob regex " + regex)
    var res: List[String] = Nil
    val f = new File(folder, classOrPackage.replaceAll("\\.", File.separator))
    if (f.isDirectory) {
      f.listFiles foreach (f => res ::= classOrPackage + "." + f.getName.dropRight(6))
    } else res ::= classOrPackage + "." + f.getName.dropRight(6)
    
    res
  }
}
