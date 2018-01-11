import TLImplicits._
import shapeless._
val Bool = "Boolean" :: Type
val b = "b" :: Bool
val BoolInd = ("true" ::: Bool) |: ("false" ::: Bool) =: Bool
val tru :: fls :: HNil = BoolInd.intros
val recBB = BoolInd.rec(Bool)
val not = recBB(fls)(tru)

val indB_not_not_b_eq_b = BoolInd.induc(b :-> (not(not(b)) =:= b))
val not_not_b_eq_b = indB_not_not_b_eq_b(tru.refl)(fls.refl)  !: b ~>: (not(not(b)) =:= b)
