(ns chapter6)
(def hello "Hello World!")
(println hello)

(clojure.core/refer 'chapter6-test :rename {'expr 'addit})
(clojure.core/alias 'aliases 'chapter6-test-alias)
(println (addit 6))
(println (expr2 6))
(println aliases/yahoo)

(ns chapter6-test)
(clojure.core/refer 'chapter6)
(println hello)

(def expr #(+ % 2))
(def expr2 (fn [arg] (str "You passed " arg)))

(expr2 45)

(ns chapter6-test-alias)
(def yahoo "@yahoo.com")

;; above all the methods to work with the ns are for working with REPL.
;; for a project file we'll require things like the following
(ns chapter6-actual
  (:require [chapter6-test-alias :as aliases]))

(println yahoo)

;; Thread Macro
(def print-it #(str "Your output is " %))
(def increment-it #(inc %))
(def multiply-it #(* % 2))

(defn thread-first
  [input]
  (-> input
      (increment-it)
      (multiply-it)
      (print-it)))

(defn thread-last
  [input]
  (->> input
      (increment-it)
      (multiply-it)
      (print-it)))

(thread-first 12)
(thread-last 12)
