import TLImplicits._
import shapeless._
val A = "A" :: Type
val a = "a" :: A
val a1 = "a1" :: A
val a2 = "a2" :: A
val ListA = "List(A)" :: Type
val as = "as" :: ListA
val as1 = "as1" :: ListA
val ListAInd = ("nil" ::: ListA) |: ("cons" ::: A ->>: ListA -->>: ListA ) =: ListA
val nil :: cons :: HNil = ListAInd.intros
val recLL = ListAInd.rec(ListA)
val errorList = "error" :: ListA
val tail = recLL(errorList)(a :-> (as :-> (as1 :-> as)))
val list = cons(a)(cons(a1)(cons(a2)(nil)))
tail(list).fansi
tail(list)
