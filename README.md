Reactive Beans
==============

Reactive Beans is a tool to generate wrappers based on reactive-core, a FRP library by Naftoli Gugenheim
(check https://github.com/nafg/reactive)

The idea is to grab any bean and create a wrapper for it so that given a bean MyBean with properties within it 
(properties according to what java calls bean properties) it generates a trait MyBeanReactive, that adds a field `signals`
when mixed: within that field you can access all the properties in MyBean exposed as signals.

The code works solely based on BeanInfos, but to avoid forcing everyone to program in a javaish way, or add annotations
everywhere, an introspector for scala that creates BeanInfos for scala classes based on the uniform access principle
was added, so that vars and prop; prop_= pairs are treated as properties.

When you request the tool to create wrapper for scala.swing.TextField for example, it will detect who declared the 
properties, and will end up writing wrappers for scala.swing.{TextField, TextComponent, Component}, 
with TextFieldReactive extending TextComponentReactive whose in turn extends CompontReactive. This way wrappers respect
the hierarchy. Note that even when this is generated, all signals are always accessed through the `signals` field after
you mix the most specific wrapper for your bean.
Also note that the project that uses the wrappers must have as dependency reactive-core

Features
--------

The tools is capable of generating compilable wrapper for javax.swing and scala.swing at once.
For java, the tool should be always successful, for scala expect some rough edges as the tool is still maturing.


Compiling
---------

The code has only one dependency that it used for reflecting over scala, that is scalap. Make sure that
dependency is satisfied and you will be able to compile the code with the project management tool that you prefer for 
working with scala.

Usage
-----

    java -jar reactive-beans.jar

to get a usage output, you can follow from there. When you read the usage description, note that you must add to the
classpath the library where the classes should be extracted from (except for classes from the java sdk), so if you want
to generate wrappers for scala.swing, you must add it to the classpath, same applies for scala-library.

Current supported options are
    -bd --base-directory   : directory where generated classes are created, . is assumed as default                                                                    
    -pn --package-name     : package name outputted as first line for every class.                                                                                        
    -p predicate           : Special predicate used to react to signal changes updating the underlying
                  property. For example, when using swing, the predicate should be _.isVisible
                  where _ will be the container of the property
    -m --bean-guessing-mode: One of:
                           auto: Will request a standard BeanInfo unless the class extends ScalaObject
                                   in which case the ScalaIntrospector will be used.
                           java: Will always force obtaining the BeanInfo via java.beans.Introspector
                                   useful when you have created BeanInfo object for your scala class and want
                                   the wrapper based on those.                             scala: Will always force obtaining the BeanInfo via ScalaIntrospector,
                                   it is here for completeness, but probably will never be used


Limitations
-----------

Generated signals are one way only, that is, changes to them will affect their originating property but not the other way round.
This might be addressed in the future, but since there is no uniform way to detect changes in the original properties,
the only solution seems to be case specific (i.e.: detecting if a class has a method addPropertyChangeListener for java,
or if the class extends Publisher for scala).