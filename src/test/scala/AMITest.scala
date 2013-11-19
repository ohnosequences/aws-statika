/* ## AWS Statika tests */

package ohnosequences.statika.aws.tests

import ohnosequences.statika._
import ohnosequences.statika.aws._
import ohnosequences.typesets._
import org.scalatest._

class AMITests extends FunSuite {

  /* There is _some metadata_ which has _something_ */
  class SomeMetadata(val smth: String) extends AnyMetadata

  /* And there is _some special metadata_ which is very special */
  case class SomeSpecialMetadata(specialSmth: String) extends SomeMetadata(specialSmth)

  /*  Now we create a funny AMI, that needs _some metadata_, 
      because it uses _something_ from it in it's user script */
  case object amimi extends AMI[SomeMetadata]("id", "version") {
    override def userScript(
        md: MetadataBound
      , distName: String
      , bundleName: String
      , creds: AWSCredentials = RoleCredentials
      ): String =
        md.smth +" "+ distName +" "+ bundleName +"?"
  }

  /* There is a bundle and a distribution which contains it and uses `amimi` */
  case object bun extends Bundle()

  case object dist extends AWSDistribution(
      metadata = SomeSpecialMetadata("¡whoa!") // note that here we use _some special metadata_!
    , ami = amimi
    , members = bun :~: ∅
    , deps = ∅
    )

  /* And the happy end of this story is that we check that user script look like we expect */
  test("Specific metadata in AMI") {
    assert(dist.ami.userScript(dist.metadata, dist.fullName, bun.fullName) === dist.userScript(bun))
    assert(dist.userScript(bun) === "¡whoa! "+dist.fullName+" "+bun.fullName+"?")
  }

}
