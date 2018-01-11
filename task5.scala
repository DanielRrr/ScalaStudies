import TLImplicits._
import shapeless._
val Bool = "Boolean" :: Type
val b = "b" :: Bool
val BoolInd = ("true" ::: Bool) |: ("false" ::: Bool) =: Bool
val tru :: fls :: HNil = BoolInd.intros
val recBBB = BoolInd.rec(Bool ->: Bool)
val and = recBBB(b :-> b)(b :-> fls)

val tru_and_b_eq_b = b :~> and(tru)(b).refl  !: b ~>: (and(tru)(b) =:= b)

val fls_and_b_eq_fls = b :~> and(fls)(b).refl  !: b ~>: (and(fls)(b) =:= fls)

val indB_b_and_tru_eq_b = BoolInd.induc(b :-> (and(b)(tru) =:= b))
val b_and_tru_eq_b = indB_b_and_tru_eq_b(tru.refl)(fls.refl)  !: b ~>: (and(b)(tru) =:= b)

val indB_b_and_fls_eq_fls = BoolInd.induc(b :-> (and(b)(fls) =:= fls))
val b_and_fls_eq_fls = indB_b_and_fls_eq_fls(fls.refl)(fls.refl)  !: b ~>: (and(b)(fls) =:= fls)

tru_and_b_eq_b(b).fansi ++ fls_and_b_eq_fls(b).fansi ++ b_and_tru_eq_b(b).fansi ++ b_and_fls_eq_fls(b).fansi
