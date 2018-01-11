import TLImplicits._
import shapeless._
val A = "A" :: Type
val a = "a" :: A
val a1 = "a1" :: A
val a2 = "a2" :: A
val Id = "Id" :: A ->: A ->: Type
val IdInd = ("refl" ::: a ~>>: (Id -> Id(a)(a) )) =:: Id
val refl :: HNil = IdInd.intros

val a1_eq_a2 = "a1 = a2" :: Id(a1)(a2)
val ind_a1eqa2_a2eqa1 = IdInd.induc(a1 :~> (a2 :~> (a1_eq_a2 :-> Id(a2)(a1) )))
val sym = ind_a1eqa2_a2eqa1(a :~> refl(a) )  !: a1 ~>: (a2 ~>: (Id(a1)(a2) ->: Id(a2)(a1) ))

sym(a2)(a1)(sym(a1)(a2)(a1_eq_a2))
