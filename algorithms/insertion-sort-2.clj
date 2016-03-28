; https://www.hackerrank.com/challenges/insertionsort2
(defn input-ints [string num]
    (map #(Integer/parseInt %) (first (split-at num (clojure.string/split string #" "))))
)

(defn ins-compare [m start]
    (loop [a0 start res m]
        (if (> a0 0)
            (if (< (nth res a0) (nth res (- a0 1)))
                (recur (- a0 1) (assoc (assoc res a0 (nth res (- a0 1))) (- a0 1) (nth res a0)))
                (recur (- a0 1) res)
            )
            res
        )
    )
)

(defn ins-sort [m]
    (loop [a0 1 res1 [] res2 m]
        (let [mlen (.length m)]
            (if (< a0 mlen) 
                (if (> (nth res2 a0) (nth res2 (- a0 1)))
                    (recur (+ a0 1) (conj res1 res2) res2)
                    (recur 
                        (+ a0 1) 
                        (conj res1 (ins-compare res2 a0)) 
                        (ins-compare res2 a0)
                    )
                )
                res1
                ;(conj res1 res2)
            )
        )
    )
)

(let [
    s (read-line)
    size (Integer/parseInt s)
    stream (read-line)]
    (doseq [i (ins-sort (into [] (input-ints stream size)))] (println (clojure.string/join " " i)))
)
