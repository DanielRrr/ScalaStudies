import TLImplicits._
import shapeless._
val A = "A" :: Type
val a = "a" :: A
val a1 = "a1" :: A
val a2 = "a2" :: A
val ListA = "List(A)" :: Type
val as = "as" :: ListA
val ListAInd = ("nil" ::: ListA) |: ("cons" ::: A ->>: ListA -->>: ListA ) =: ListA
val nil :: cons :: HNil = ListAInd.intros
val recLA = ListAInd.rec(A)
val errorEl = "error" :: A
val head = recLA(errorEl)(a :-> (as :-> (a1 :-> a)))
val list = cons(a)(cons(a1)(cons(a2)(nil)))
head(list) == a
cons(head(as))(cons(a1)(cons(head(as))(as)))
