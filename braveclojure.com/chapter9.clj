(ns chapter9)

;; Futures, Delays, and Promises

;; Future (more likely to settimeout in JS??)
;; future creates a new thread and places each expression you pass it on the new thread
(future (Thread/sleep 1000)
        (println "Hello dear all!"))

(println "Instant call")
