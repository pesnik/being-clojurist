;; Functional Programming
;; In this chapter, you’ll learn how to think about your programming tasks in a way that makes the best use of those tools.
(ns chapter5)

(require '[clojure.string :as s])

(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(def input "What a lame joke! lol")
(def new-text (clean input))
(println input)
(println new-text)

;; Functional composition
((comp inc *) 2 3)

(def students
  {:name "Rakibul Hasan"
   :scores {:math 90
            :english 89
            :religion 64}})
(def math-score (comp :math :scores))
(def english-score (comp :english :scores))
(def religion-score (comp :religion :scores))

(math-score students)
(english-score students)
(religion-score students)
