
```scala
package ohnosequences.statika.aws

import ohnosequences.statika.bundles._
import java.net.URL

object api extends Module {
  
  val statusAWSTag = "statika-status"

  lazy val metadataLocalURL      = new URL("http://169.254.169.254/latest/meta-data")
  lazy val metadataLocalAMIIdURL = new URL(metadataLocalURL, "ami-id")

  sealed trait Architecture
  case object x32 extends Architecture { override def toString = "32" }
  case object x64 extends Architecture { override def toString = "64" }

  sealed trait InstanceStatus
  case object preparing extends InstanceStatus
  case object building  extends InstanceStatus
  case object applying  extends InstanceStatus
  case object success   extends InstanceStatus
  case object failure   extends InstanceStatus
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