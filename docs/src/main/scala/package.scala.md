
```scala
package ohnosequences.statika

import ohnosequences.statika.bundles._

package object aws {

  type AnyLinuxAMICompatible = AnyCompatible { type Environment <: AnyLinuxAMIEnvironment }
  // type AnyAMICompatible = AnyCompatible { type Environment <: AnyAMIEnvironment }
  type AMICompatible[E <: AnyLinuxAMIEnvironment, B <: AnyBundle] = Compatible[E,B]

  implicit def linuxAMICompSyntax[C <: AnyLinuxAMICompatible]
    (comp: C): LinuxAMICompSyntax[C] = LinuxAMICompSyntax(comp)
}

```




[main/scala/package.scala]: package.scala.md
[main/scala/amis.scala]: amis.scala.md