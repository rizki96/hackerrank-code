; https://www.hackerrank.com/challenges/insertionsort1
(defn input-ints [string num]
    (map #(Integer/parseInt %) (first (split-at num (clojure.string/split string #" "))))
)

(defn ins-sort [m]
    (loop [a0 (.length m) res1 [] res2 m]
        (if (and (> a0 1) (< (nth res2 (- a0 1)) (nth res2 (- a0 2))))
            (recur (dec a0) (conj res1 (assoc res2 (- a0 1) (nth res2 (- a0 2))) ) (assoc (assoc res2 (- a0 1) (nth res2 (- a0 2))) (- a0 2) (nth res2 (- a0 1))) )
            (conj res1 res2)
        )
    )
)

(let [
    s (read-line)
    size (Integer/parseInt s)
    stream (read-line)]
    (doseq [i (ins-sort (into [] (input-ints stream size)))] (println (clojure.string/join " " i)))
)
