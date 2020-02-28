(ns iota-seed.core-test
  (:require [clojure.test :refer :all]
            [iota-seed.core :refer :all]))

(deftest test-length
  (testing "iota seed is 81-char long"
    (is (= (count (generate-seed)) 81))))

(deftest test-alphabet
  (testing "iota seed only contains iota tryte alphabet chars"
    (is (some? (re-matches #"[A-Z9]{81}" (generate-seed))))))
