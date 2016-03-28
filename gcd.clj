(def gcd 
(fn [a b] ( 
    (loop [k a m b]
        (if (not= k m)
            (if (> k m)
                (recur (- k m) m)
                (recur k (- m k))
            )
            k
        )
    )
))
)
(let [[m n] 
(map read-string (re-seq #"\d+" (read-line)))
] (println (gcd m n))
)
