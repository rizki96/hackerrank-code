; https://www.hackerrank.com/challenges/maximizing-xor
(defn maxXor [l r ]
    (apply max (map (fn [[l r]] (bit-xor l r)) (for [x (range l (inc r)) y (range l (inc r))] [x y])))
)

(let [  
    
    _l (Integer/parseInt (read-line))
    
    _r (Integer/parseInt (read-line))
]    (println (maxXor _l _r))
)
