package reactivebeans

import java.io.File

case class GeneratorSettings(baseFolder: File,
                             packageName: String,
                             specialPredicate: Option[String],
                             beanGuessMode: Generator.BeanGuessMode.Value,
                             generateTestClasses: Boolean,
                             beanFixes: Seq[String])
