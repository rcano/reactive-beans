Reactive Beans
==============

Reactive Beans is a tool to generate wrappers based on reactive-core, a FRP library by Naftoli Gugenheim
(check https://github.com/nafg/reactive )

The idea is to grab any bean and create a wrapper for it so that given a bean MyBean with properties within it 
(properties according to what java calls bean properties) it generates a trait MyBeanReactive, that adds a field `signals` and `events`
when mixed: `signals` will expose all properties, while events will expose listeners.

The code works solely based on BeanInfos, but to avoid forcing everyone to program in a javaish way, or add annotations
everywhere, an introspector for scala that creates BeanInfos for scala classes based on the uniform access principle
was added, so that vars and prop; prop_= pairs are treated as properties.

When you request the tool to create wrapper for scala.swing.TextField for example, it will detect who declared the 
properties, and will end up writing wrappers for scala.swing.{TextField, TextComponent, Component}, 
with TextFieldReactive extending TextComponentReactive whose in turn extends CompontReactive. This way wrappers respect
the hierarchy. Note that even when this is generated, all signals are always accessed through the `signals` field after
you mix the most specific wrapper for your bean, same goes for `events`.
Also note that the project that uses the wrappers must have as dependency reactive-core

Features
--------

The tools is capable of generating compilable wrapper for javax.swing and scala.swing at once.
As an example, there is a directory in the root of the repository called generatedWrappersTester which
is a tiny sbt project with the generated wrappers for both javax.swing and scala.swing.


Compiling
---------

The project is managed using sbt 0.11, to compiling should be as easy as forking and issuing compile in sbt's console.

Usage
-----

In the root folder there is a jar that was generated with proguard and pack200, this is the current "dist" until
a proper project management is configure for the repo.
Use it as

    java -cp $SCALA_HOME/lib/scala-swing.jar:$SCALA_HOME/lib/scala-library.jar:reactive-beans_2.8.1-0.6-SNAPSHOT-release.jar Launcher -pn dest.package.name -bd myProj/src/main/scala/my/dest/packageDir scala.swing.*

That will generate wrappers for the whole scala.swing classes, in the directory myProj/src/main/scala/my/dest/packageDir, with package dest.package.name
declared in the beginning of each wrapper.

Do

    java -jar reactive-beans_2.8.1-0.6-SNAPSHOT-release.jar

to get a usage output. When you read the usage description, note that you must add to the
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


Examples
--------

This is output generated for javax.swing.JComponent

    package wrappers

    //This file was auto generated
    import reactive._

    trait JComponentReactive extends javax.swing.JComponent with ContainerReactive { outer =>
            trait Signals extends super.Signals {
                    val actionMap = Var(outer.getActionMap)
                    actionMap.change.takeWhile{e => outer.isVisible} foreach (e => outer.setActionMap(e))
                    val alignmentX = Var(outer.getAlignmentX)
                    alignmentX.change.takeWhile{e => outer.isVisible} foreach (e => outer.setAlignmentX(e))
                    val alignmentY = Var(outer.getAlignmentY)
                    alignmentY.change.takeWhile{e => outer.isVisible} foreach (e => outer.setAlignmentY(e))
                    val autoscrolls = Var(outer.getAutoscrolls)
                    autoscrolls.change.takeWhile{e => outer.isVisible} foreach (e => outer.setAutoscrolls(e))
                    val border = Var(outer.getBorder)
                    border.change.takeWhile{e => outer.isVisible} foreach (e => outer.setBorder(e))
                    val componentPopupMenu = Var(outer.getComponentPopupMenu)
                    componentPopupMenu.change.takeWhile{e => outer.isVisible} foreach (e => outer.setComponentPopupMenu(e))
                    val debugGraphicsOptions = Var(outer.getDebugGraphicsOptions)
                    debugGraphicsOptions.change.takeWhile{e => outer.isVisible} foreach (e => outer.setDebugGraphicsOptions(e))
                    val doubleBuffered = Var(outer.isDoubleBuffered)
                    doubleBuffered.change.takeWhile{e => outer.isVisible} foreach (e => outer.setDoubleBuffered(e))
                    val inheritsPopupMenu = Var(outer.getInheritsPopupMenu)
                    inheritsPopupMenu.change.takeWhile{e => outer.isVisible} foreach (e => outer.setInheritsPopupMenu(e))
                    val inputVerifier = Var(outer.getInputVerifier)
                    inputVerifier.change.takeWhile{e => outer.isVisible} foreach (e => outer.setInputVerifier(e))
                    val maximumSize = Var(outer.getMaximumSize)
                    maximumSize.change.takeWhile{e => outer.isVisible} foreach (e => outer.setMaximumSize(e))
                    val minimumSize = Var(outer.getMinimumSize)
                    minimumSize.change.takeWhile{e => outer.isVisible} foreach (e => outer.setMinimumSize(e))
                    val nextFocusableComponent = Var(outer.getNextFocusableComponent)
                    nextFocusableComponent.change.takeWhile{e => outer.isVisible} foreach (e => outer.setNextFocusableComponent(e))
                    val opaque = Var(outer.isOpaque)
                    opaque.change.takeWhile{e => outer.isVisible} foreach (e => outer.setOpaque(e))
                    val preferredSize = Var(outer.getPreferredSize)
                    preferredSize.change.takeWhile{e => outer.isVisible} foreach (e => outer.setPreferredSize(e))
                    val requestFocusEnabled = Var(outer.isRequestFocusEnabled)
                    requestFocusEnabled.change.takeWhile{e => outer.isVisible} foreach (e => outer.setRequestFocusEnabled(e))
                    val toolTipText = Var(outer.getToolTipText)
                    toolTipText.change.takeWhile{e => outer.isVisible} foreach (e => outer.setToolTipText(e))
                    val transferHandler = Var(outer.getTransferHandler)
                    transferHandler.change.takeWhile{e => outer.isVisible} foreach (e => outer.setTransferHandler(e))
                    val verifyInputWhenFocusTarget = Var(outer.getVerifyInputWhenFocusTarget)
                    verifyInputWhenFocusTarget.change.takeWhile{e => outer.isVisible} foreach (e => outer.setVerifyInputWhenFocusTarget(e))

                    addPropertyChangeListener(new java.beans.PropertyChangeListener {
                            def propertyChange(evt: java.beans.PropertyChangeEvent) {
                                    def cast[R](a: Any) = a.asInstanceOf[R]
                                    evt.getPropertyName match {
                                            case "actionMap" => actionMap() = cast(evt.getNewValue)
                                            case "alignmentX" => alignmentX() = cast(evt.getNewValue)
                                            case "alignmentY" => alignmentY() = cast(evt.getNewValue)
                                            case "autoscrolls" => autoscrolls() = cast(evt.getNewValue)
                                            case "border" => border() = cast(evt.getNewValue)
                                            case "componentPopupMenu" => componentPopupMenu() = cast(evt.getNewValue)
                                            case "debugGraphicsOptions" => debugGraphicsOptions() = cast(evt.getNewValue)
                                            case "doubleBuffered" => doubleBuffered() = cast(evt.getNewValue)
                                            case "inheritsPopupMenu" => inheritsPopupMenu() = cast(evt.getNewValue)
                                            case "inputVerifier" => inputVerifier() = cast(evt.getNewValue)
                                            case "maximumSize" => maximumSize() = cast(evt.getNewValue)
                                            case "minimumSize" => minimumSize() = cast(evt.getNewValue)
                                            case "nextFocusableComponent" => nextFocusableComponent() = cast(evt.getNewValue)
                                            case "opaque" => opaque() = cast(evt.getNewValue)
                                            case "preferredSize" => preferredSize() = cast(evt.getNewValue)
                                            case "requestFocusEnabled" => requestFocusEnabled() = cast(evt.getNewValue)
                                            case "toolTipText" => toolTipText() = cast(evt.getNewValue)
                                            case "transferHandler" => transferHandler() = cast(evt.getNewValue)
                                            case "verifyInputWhenFocusTarget" => verifyInputWhenFocusTarget() = cast(evt.getNewValue)
                                            case _ =>
                                    }
                            }
                    })
            }

            override lazy val signals = new Signals {}

            trait EventStreams extends super.EventStreams {
                    object ancestor {
                            val ancestorMoved = new ESource[javax.swing.event.AncestorEvent]
                            val ancestorAdded = new ESource[javax.swing.event.AncestorEvent]
                            val ancestorRemoved = new ESource[javax.swing.event.AncestorEvent]
                    }
                    addAncestorListener(new javax.swing.event.AncestorListener {
                            def ancestorMoved(evt: javax.swing.event.AncestorEvent) {ancestor.ancestorMoved.fire(evt)}
                            def ancestorAdded(evt: javax.swing.event.AncestorEvent) {ancestor.ancestorAdded.fire(evt)}
                            def ancestorRemoved(evt: javax.swing.event.AncestorEvent) {ancestor.ancestorRemoved.fire(evt)}
                    })
                    val vetoableChange = new ESource[java.beans.PropertyChangeEvent]
                    addVetoableChangeListener(new java.beans.VetoableChangeListener {
                            def vetoableChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.vetoableChange.fire(evt)}
                    })
            }

            override lazy val events = new EventStreams {}
    }

Notice that it is inheriting signals and events from ContainerReactive and ComponentReactive, so for instance, you can write:
    
    myWrappedComponent.events.mouse.mouseClicked foreach (e => println("Button " + e.getButton + " was clicked"))
    myWrappedComponent.events.mouse.mousePressed foreach (e => println("Button " + e.getButton + " was pressed"))
    myWrappedComponent.events.mouse.mouseReleased foreach (e => println("Button " + e.getButton + " was released"))
    myWrappedComponent.events.component.componentMoved foreach (e => println("myWrappedComponent was moved"))
    myWrappedComponent.signals.background foreach (newColor => println("New background = " + newColor))

Limitations
-----------

Generated signals are one way only unless the class that is being wrapped supports addPropertyChangeListener.
That is, changes to them will affect their originating property but not the other way round.