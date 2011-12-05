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
is a tiny sbt project with the generated wrappers for both javax.swing and scala.swing already generated.


Compiling
---------

The project is managed using sbt 0.11, compiling should be as easy as forking and issuing compile in sbt's console.

Usage
-----

Once pacakged with sbt, you can run it like:

    java -cp $SCALA_HOME/lib/scala-swing.jar:$SCALA_HOME/lib/scala-library.jar:reactive-beans_2.9.1-1.1.jar reactivebeans.Generator -pn dest.package.name -bd myProj/src/main/scala/my/dest/packageDir scala.swing.*

That will generate wrappers for the whole scala.swing classes, in the directory myProj/src/main/scala/my/dest/packageDir, with package dest.package.name
declared in the beginning of each wrapper.

Do

    java -cp $SCALA_HOME/lib/scala-library.jar:reactive-beans_2.9.1-1.1.jar

to get a usage output. When you read the usage description, note that you must add to the
classpath the library where the classes should be extracted from (except for classes from the java sdk), so if you want
to generate wrappers for scala.swing, you must add it to the classpath, same applies for scala-library.

    Options:
    reactive-beans [options] <toProcess>...
             -bd --base-directory: directory where generated classes are created, . is assumed as default
             -pn --package-name: package name outputted as first line for every class.
             -p predicate: Special predicate used to react to signal changes updating the underlying
                           property. For example, when using swing, the predicate should be _.isVisible
                           where _ will be the container of the property
             -m --bean-guessing-mode: One of:
                                    auto: Will request a standard BeanInfo unless the class extends ScalaObject
                                            in which case the ScalaIntrospector will be used.
                                    java: Will always force obtaining the BeanInfo via java.beans.Introspector
                                            useful when you have created BeanInfo object for your scala class and want
                                            the wrapper based on those.
                                    scala: Will always force obtaining the BeanInfo via ScalaIntrospector,
                                            it is here for completeness, but probably will never be used.
             --bean-fixes: Specifies classes or packages to look for BeanFix.
                           Some beans are broken and they don't expose their properties and events
                           properly, for example all javax.swing.JTextComponents like JTextField and
                           JTextArea do not expose changes to text property via property changes, so
                           in order to keep the signal updated, a DocumentListener has to be registered.
                           Fixes like the one said, are provided by implementations of BeanFix, such
                           instances get a change to generate more code into the final output.
                           reactivebeans.defaultbeanfixes.* should be used when creating javax.swing classes,
                           it contains several common fixes to javax.swing like the one above.
             <toProcess>: class or package written in java naming convention like javax.swing.JLabel



Examples
--------

This is output generated for javax.swing.JComponent

    package reactive.jswing

    import reactive._

    //This file was auto generated
    trait JComponentReactive extends javax.swing.JComponent with ContainerReactive {
      outer =>
      trait Signals extends super.Signals {
        //helper method to treat var as signals without specifying the type
        //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
        @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
        lazy val `UIClassID` = varAsSignal(Var(outer.getUIClassID))
        lazy val `accessibleContext` = varAsSignal(Var(outer.getAccessibleContext))
        lazy val `actionMap` = {
          val res = Var(outer.getActionMap)
          res foreach (e => if (e != outer.getActionMap) outer.setActionMap(e))
          res
        }
        override lazy val `alignmentX` = {
          val res = Var(outer.getAlignmentX)
          res foreach (e => if (e != outer.getAlignmentX) outer.setAlignmentX(e))
          res
        }
        override lazy val `alignmentY` = {
          val res = Var(outer.getAlignmentY)
          res foreach (e => if (e != outer.getAlignmentY) outer.setAlignmentY(e))
          res
        }
        lazy val `ancestorListeners` = varAsSignal(Var(outer.getAncestorListeners))
        lazy val `autoscrolls` = {
          val res = Var(outer.getAutoscrolls)
          res foreach (e => if (e != outer.getAutoscrolls) outer.setAutoscrolls(e))
          res
        }
        lazy val `baselineResizeBehavior` = varAsSignal(Var(outer.getBaselineResizeBehavior))
        lazy val `border` = {
          val res = Var(outer.getBorder)
          res foreach (e => if (e != outer.getBorder) outer.setBorder(e))
          res
        }
        lazy val `componentPopupMenu` = {
          val res = Var(outer.getComponentPopupMenu)
          res foreach (e => if (e != outer.getComponentPopupMenu) outer.setComponentPopupMenu(e))
          res
        }
        lazy val `debugGraphicsOptions` = {
          val res = Var(outer.getDebugGraphicsOptions)
          res foreach (e => if (e != outer.getDebugGraphicsOptions) outer.setDebugGraphicsOptions(e))
          res
        }
        lazy val `doubleBuffered` = {
          val res = Var(outer.isDoubleBuffered)
          res foreach (e => if (e != outer.isDoubleBuffered) outer.setDoubleBuffered(e))
          res
        }
        lazy val `graphics` = varAsSignal(Var(outer.getGraphics))
        lazy val `height` = varAsSignal(Var(outer.getHeight))
        lazy val `inheritsPopupMenu` = {
          val res = Var(outer.getInheritsPopupMenu)
          res foreach (e => if (e != outer.getInheritsPopupMenu) outer.setInheritsPopupMenu(e))
          res
        }
        lazy val `inputVerifier` = {
          val res = Var(outer.getInputVerifier)
          res foreach (e => if (e != outer.getInputVerifier) outer.setInputVerifier(e))
          res
        }
        lazy val `managingFocus` = varAsSignal(Var(outer.isManagingFocus))
        override lazy val `maximumSize` = {
          val res = Var(outer.getMaximumSize)
          res foreach (e => if (e != outer.getMaximumSize) outer.setMaximumSize(e))
          res
        }
        override lazy val `minimumSize` = {
          val res = Var(outer.getMinimumSize)
          res foreach (e => if (e != outer.getMinimumSize) outer.setMinimumSize(e))
          res
        }
        lazy val `nextFocusableComponent` = {
          val res = Var(outer.getNextFocusableComponent)
          res foreach (e => if (e != outer.getNextFocusableComponent) outer.setNextFocusableComponent(e))
          res
        }
        lazy val `opaque` = {
          val res = Var(outer.isOpaque)
          res foreach (e => if (e != outer.isOpaque) outer.setOpaque(e))
          res
        }
        lazy val `optimizedDrawingEnabled` = varAsSignal(Var(outer.isOptimizedDrawingEnabled))
        lazy val `paintingForPrint` = varAsSignal(Var(outer.isPaintingForPrint))
        lazy val `paintingTile` = varAsSignal(Var(outer.isPaintingTile))
        override lazy val `preferredSize` = {
          val res = Var(outer.getPreferredSize)
          res foreach (e => if (e != outer.getPreferredSize) outer.setPreferredSize(e))
          res
        }
        lazy val `registeredKeyStrokes` = varAsSignal(Var(outer.getRegisteredKeyStrokes))
        lazy val `requestFocusEnabled` = {
          val res = Var(outer.isRequestFocusEnabled)
          res foreach (e => if (e != outer.isRequestFocusEnabled) outer.setRequestFocusEnabled(e))
          res
        }
        lazy val `rootPane` = varAsSignal(Var(outer.getRootPane))
        lazy val `toolTipText` = {
          val res = Var(outer.getToolTipText)
          res foreach (e => if (e != outer.getToolTipText) outer.setToolTipText(e))
          res
        }
        lazy val `topLevelAncestor` = varAsSignal(Var(outer.getTopLevelAncestor))
        lazy val `transferHandler` = {
          val res = Var(outer.getTransferHandler)
          res foreach (e => if (e != outer.getTransferHandler) outer.setTransferHandler(e))
          res
        }
        lazy val `verifyInputWhenFocusTarget` = {
          val res = Var(outer.getVerifyInputWhenFocusTarget)
          res foreach (e => if (e != outer.getVerifyInputWhenFocusTarget) outer.setVerifyInputWhenFocusTarget(e))
          res
        }
        lazy val `vetoableChangeListeners` = varAsSignal(Var(outer.getVetoableChangeListeners))
        lazy val `visibleRect` = varAsSignal(Var(outer.getVisibleRect))
        lazy val `width` = varAsSignal(Var(outer.getWidth))
        lazy val `x` = varAsSignal(Var(outer.getX))
        lazy val `y` = varAsSignal(Var(outer.getY))

        outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
          def propertyChange(evt: java.beans.PropertyChangeEvent) {
            def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
            evt.getPropertyName match {
              case "`UIClassID`" => assign(`UIClassID`, evt.getNewValue)
              case "`accessibleContext`" => assign(`accessibleContext`, evt.getNewValue)
              case "`actionMap`" => assign(`actionMap`, evt.getNewValue)
              case "`alignmentX`" => assign(`alignmentX`, evt.getNewValue)
              case "`alignmentY`" => assign(`alignmentY`, evt.getNewValue)
              case "`ancestorListeners`" => assign(`ancestorListeners`, evt.getNewValue)
              case "`autoscrolls`" => assign(`autoscrolls`, evt.getNewValue)
              case "`baselineResizeBehavior`" => assign(`baselineResizeBehavior`, evt.getNewValue)
              case "`border`" => assign(`border`, evt.getNewValue)
              case "`componentPopupMenu`" => assign(`componentPopupMenu`, evt.getNewValue)
              case "`debugGraphicsOptions`" => assign(`debugGraphicsOptions`, evt.getNewValue)
              case "`doubleBuffered`" => assign(`doubleBuffered`, evt.getNewValue)
              case "`graphics`" => assign(`graphics`, evt.getNewValue)
              case "`height`" => assign(`height`, evt.getNewValue)
              case "`inheritsPopupMenu`" => assign(`inheritsPopupMenu`, evt.getNewValue)
              case "`inputVerifier`" => assign(`inputVerifier`, evt.getNewValue)
              case "`managingFocus`" => assign(`managingFocus`, evt.getNewValue)
              case "`maximumSize`" => assign(`maximumSize`, evt.getNewValue)
              case "`minimumSize`" => assign(`minimumSize`, evt.getNewValue)
              case "`nextFocusableComponent`" => assign(`nextFocusableComponent`, evt.getNewValue)
              case "`opaque`" => assign(`opaque`, evt.getNewValue)
              case "`optimizedDrawingEnabled`" => assign(`optimizedDrawingEnabled`, evt.getNewValue)
              case "`paintingForPrint`" => assign(`paintingForPrint`, evt.getNewValue)
              case "`paintingTile`" => assign(`paintingTile`, evt.getNewValue)
              case "`preferredSize`" => assign(`preferredSize`, evt.getNewValue)
              case "`registeredKeyStrokes`" => assign(`registeredKeyStrokes`, evt.getNewValue)
              case "`requestFocusEnabled`" => assign(`requestFocusEnabled`, evt.getNewValue)
              case "`rootPane`" => assign(`rootPane`, evt.getNewValue)
              case "`toolTipText`" => assign(`toolTipText`, evt.getNewValue)
              case "`topLevelAncestor`" => assign(`topLevelAncestor`, evt.getNewValue)
              case "`transferHandler`" => assign(`transferHandler`, evt.getNewValue)
              case "`verifyInputWhenFocusTarget`" => assign(`verifyInputWhenFocusTarget`, evt.getNewValue)
              case "`vetoableChangeListeners`" => assign(`vetoableChangeListeners`, evt.getNewValue)
              case "`visibleRect`" => assign(`visibleRect`, evt.getNewValue)
              case "`width`" => assign(`width`, evt.getNewValue)
              case "`x`" => assign(`x`, evt.getNewValue)
              case "`y`" => assign(`y`, evt.getNewValue)
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
        outer.addAncestorListener(new javax.swing.event.AncestorListener {
          def ancestorMoved(evt: javax.swing.event.AncestorEvent) {EventStreams.this.ancestor.ancestorMoved.fire(evt)}
          def ancestorAdded(evt: javax.swing.event.AncestorEvent) {EventStreams.this.ancestor.ancestorAdded.fire(evt)}
          def ancestorRemoved(evt: javax.swing.event.AncestorEvent) {EventStreams.this.ancestor.ancestorRemoved.fire(evt)}
        })
        object vetoableChange {
          val vetoableChange = new ESource[java.beans.PropertyChangeEvent]
        }
        outer.addVetoableChangeListener(new java.beans.VetoableChangeListener {
          def vetoableChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.vetoableChange.vetoableChange.fire(evt)}
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

Besides generating Reactive traits for each bean, it also generates a ReactiveProxy, which are identical
to the traits except for beign instantiated using a preexistant instance of the bean (and you only get exposed signals and events
that are public, in contrast with the extend-like trait that also have access to protected fields). This might come in
handy when the component is already created

Limitations
-----------

Generated signals are one way only unless the class that is being wrapped supports addPropertyChangeListener.
That is, changes to them will affect their originating property but not the other way round.

Handling of generics is quite limited. Though simple ones like A <: B will work, higher kinds won't. Nevertheless,
it should be easy to correct the generated source file.