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
val f = "f" :: A ->: A
val ind_a1eqa2_fa1eqfa2 = IdInd.induc(a1 :~> (a2 :~> (a1_eq_a2 :-> (f ~>: Id(f(a1))(f(a2)) ))))
val ext = ind_a1eqa2_fa1eqfa2(a :~> (f :~> refl(f(a)) ))  !: a1 ~>: (a2 ~>: (Id(a1)(a2) ->: (f ~>: Id(f(a1))(f(a2)) )))
