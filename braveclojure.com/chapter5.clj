;; Functional Programming
;; In this chapter, you’ll learn how to think about your programming tasks in a way that makes the best use of those tools.
(ns chapter5)

(require '[clojure.string :as s])

(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "What a lame joke! lol")
