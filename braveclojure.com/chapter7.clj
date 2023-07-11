;; Clojure Alchemy: Reading, Evaluation, and Macros
(ns chapter7)

;; define my own spaceship operator in clojure
(defmacro <=>
  [arg1 arg2]
  (if (> arg1 arg2)
    1
    (if (= arg1 arg2)
      0
      -1)))

(<=> 1 4)
