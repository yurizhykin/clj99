(ns clj99.arithmetic-test
  (:require [clj99.arithmetic :refer :all]
            [clojure.test :refer :all]
            [clojure.math.numeric-tower :as m]))

(deftest p31
  (testing "P31"
    (is (is-prime 13))
    (is (is-prime 997))
    (is (false? (is-prime 999)))
    (is (false? (is-prime 8911))))) ; Carmichael's number

(deftest p32
  (testing "P32"
    (is (== (gcd 36 63) 9))
    (is (== (gcd 63 36) 9))
    (is (== (gcd 35 64) 1))))

(deftest p33
  (testing "P33"
    (is (coprime? 35 64))
    (is (false? (coprime? 35 65)))))

(deftest p34
  (testing "P34"
    (is (= (totient-phi 10) 4))
    (is (= (totient-phi 99) 60))))

(deftest p35
  (testing "P35"
    (dotimes [i 10]
      ;; bigints need special libs, so ints only
      (let [n (rand-int Integer/MAX_VALUE)
            pfs (prime-factors n)]
        (is (== n (reduce * pfs)))))))

(deftest p36
  (testing "P36"
    (dotimes [i 10]
      (let [n (rand-int Integer/MAX_VALUE)
            pfs (prime-factors-mult n)]
        (is (== n (reduce #(* %1 (m/expt (%2 0) (%2 1))) 1 pfs)))))))
