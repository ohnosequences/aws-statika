
```scala
package ohnosequences.statika.aws.test

import org.scalatest._

import ohnosequences.statika.aws._, amis._, amazonLinuxAMIs._
import ohnosequences.statika.bundles._

class AmazonLinuxAmiTestSuite extends FunSuite {


  // TODO tests for script ops
  import ohnosequences.awstools.regions.Region._

  object euAMI extends amzn_ami_pv_64bit(Ireland)(1)

  object stupid extends Module

  val stupidMetadata = new AnyArtifactMetadata {
    val organization: String = "ohnosequences"
    val artifact: String = "uhoh"
    val version: String = "0.1.0"
    val artifactUrl: String = "asdfadf"
  }

  implicit val ICanHazStupid = new Compatible(euAMI, stupid, stupidMetadata)

  test("accessing the user script and instance specs through implicits") {

    val zzz = euAMI userScript stupid

    import ohnosequences.awstools.ec2.InstanceType._

    val ss = euAMI.instanceSpecsFor(stupid)(
      instanceType  = t2_small,
      keyPair       = "uh.pem",
      role          = Some("god")
    )
  }
  

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

[test/scala/amazonLinuxTests.scala]: amazonLinuxTests.scala.md
[test/scala/AMITest.scala]: AMITest.scala.md
[main/scala/AmazonLinuxAMI.scala]: ../../main/scala/AmazonLinuxAMI.scala.md
[main/scala/api.scala]: ../../main/scala/api.scala.md
[main/scala/AMI.scala]: ../../main/scala/AMI.scala.md