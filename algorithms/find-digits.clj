; https://www.hackerrank.com/challenges/find-digits
(defn input-digits [t]
    (loop [a0 t res []] 
        (if (> a0 0) 
            (let [n_t (read-line) n (Integer/parseInt n_t)] (recur (- a0 1) (conj res n)) ) 
            res
        )
    )
)

(defn find-digits [m]
    (map 
        (fn [c] 
            (reduce 
            (fn [res v] 
                (if (and (not= v \0) (= (mod c (Integer/parseInt (str "" v)) ) 0)) (inc res) res)
            )
            0
            (seq (str "" c))
            )
        )
        m
    )
)

(
    let [
        t_t (read-line) 
        t (Integer/parseInt t_t) 
    ]

    (doseq [i (find-digits (input-digits t))] (println i))
)
