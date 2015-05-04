
## Amazon Machine Images (AMIs)

This abstraction represents AMIs, that are supposed to be used in distributions
to control, that all the members are installed with the same image.


```scala
package ohnosequences.statika.aws

import ohnosequences.statika._, bundles._, instructions._

object amis extends Module(api) {


  abstract class AnyAMI extends Environment { ami =>

    val id: String
    val amiVersion: String

    // TODO why not put all the Java/Scala install here?

```

This method checks that the machine on which it's called has the corresponding image.

```scala
    final def install: Results = {
      
      try {
        
        val amiId = io.Source.fromURL(api.metadataLocalAMIIdURL).mkString

        if (amiId == id)
          success(s"Checked that the Amazon Machine Image id is ${id}")
        else
          failure(s"AMI should be ${id}. Found ${amiId}")

      } catch {

        case ct: scala.util.control.ControlThrowable => 
          throw ct
        
        case e:  Exception => 
          failure(s"Couldn't check AMI id because of ${e}")
      }
    }

  }
```

A constructor for ami objects

```scala
  abstract class AMI(val id: String, val amiVersion: String) extends AnyAMI

  // no need to add a new trait here
  type AMICompatible[E <: AnyAMI, B <: AnyBundle] = Compatible[E,B]
}
```


------

### Index

+ src
  + test
    + scala
      + [amazonLinuxTests.scala][test/scala/amazonLinuxTests.scala]
      + [AMITest.scala][test/scala/AMITest.scala]
  + main
    + scala
      + [AmazonLinuxAMI.scala][main/scala/AmazonLinuxAMI.scala]
      + [api.scala][main/scala/api.scala]
      + [AMI.scala][main/scala/AMI.scala]

[test/scala/amazonLinuxTests.scala]: ../../test/scala/amazonLinuxTests.scala.md
[test/scala/AMITest.scala]: ../../test/scala/AMITest.scala.md
[main/scala/AmazonLinuxAMI.scala]: AmazonLinuxAMI.scala.md
[main/scala/api.scala]: api.scala.md
[main/scala/AMI.scala]: AMI.scala.md