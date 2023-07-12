(ns chapter9)

;; Futures, Delays, and Promises

;; Future (more likely to settimeout in JS?? kinda but it's more like async and settimeout and [@, deref] like await keyword available)
;; future creates a new thread and places each expression you pass it on the new thread
(future (Thread/sleep 1000)
        (println "Hello dear all!"))

(println "Instant call")

;; using deref
(let [x (future (Thread/sleep 1000)
                100 + 23)]
    (println "Instant")
    (println "deref result" (deref x))
    (println "After deref it's been cached")
    (println "Cached result " @x))

;; for deref we can use a timout param. using which will tell the program if the future doesn't evalutes within the time being, we we discard this
(deref (future (Thread/sleep 1000) 0) 10 5)
(deref (future (Thread/sleep 1000) 0) 2000 5)

;; using realized? to see if it’s done running
(realized? (future (Thread/sleep 1000)
                   (println "Hello after 1s")))

(let [x (future (Thread/sleep 1000) (println "Hello after 1s"))]
  @x
  (realized? x))

;; Delays (for using where we can decalre a instruction, until forced not evaluted)
(def hunky-punky
  (delay (let [m "Just call me dear, i'll be there"]
           (println "I don't know yet what is the purpose of this message: " m)
           m)))
(force hunky-punky)
@hunky-punky

;; Promises
(def new-promise (promise))
(deliver new-promise (+ 1 1))
@new-promise
