import TLImplicits._
import shapeless._
val Nat = "Nat" :: Type
val NatInd = ("0" ::: Nat) |: ("succ" ::: Nat -->>: Nat) =: Nat
val zero :: succ :: HNil = NatInd.intros
val n = "n" :: Nat
val m = "m" :: Nat
val one = succ(zero)
val two = succ(one)
val three = succ(two)
val four = succ(three)
val five = succ(four)
val six = succ(five)
val recNNN = NatInd.rec(Nat ->: Nat)
val addn = "add(n)" :: Nat ->: Nat
val add = recNNN(m :-> m)(n :-> (addn :-> (m :-> succ(addn(m)) )))
val recNProdNN = NatInd.rec(ProdTyp(Nat, Nat))
val pair = "(fib(n), fib(n+1))" :: ProdTyp(Nat, Nat)
val fibpair = recNProdNN(PairTerm(zero, one))(n :-> (pair :-> PairTerm(pair.second, add(pair.first)(pair.second)) ))
val fib = n :-> fibpair(n).first
fib(six).fansi
fib(add(add(n)(two))(add(three)(m)))
