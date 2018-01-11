import TLImplicits._
import shapeless._
val A = "A" :: Type
val a = "a" :: A
val ListA = "List(A)" :: Type
val as = "as" :: ListA
val ListAInd = ("nil" ::: ListA) |: ("cons" ::: A ->>: ListA -->>: ListA ) =: ListA
val nil :: cons :: HNil = ListAInd.intros
val Bool = "Boolean" :: Type
val b = "b" :: Bool
val BoolInd = ("true" ::: Bool) |: ("false" ::: Bool) =: Bool
val tru :: fls :: HNil = BoolInd.intros
val recLB = ListAInd.rec(Bool)
val isNil = recLB(tru)(a :-> (as :-> (b :-> fls)))
isNil(nil) == tru
isNil(cons(a)(nil)) == fls
isNil(("f" :: ListA ->: ListA)(cons(a)(as)))
