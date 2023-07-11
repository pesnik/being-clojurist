(ns chapter6)
(def hello "Hello World!")
(println hello)

(clojure.core/refer 'chapter6-test :only ['expr])
(println (expr 6))
(println (expr2 6))

(ns chapter6-test)
(clojure.core/refer 'chapter6)
(println hello)

(def expr #(+ % 2))
(def expr2 (fn [arg] (str "You passed " arg)))

(expr2 45)
