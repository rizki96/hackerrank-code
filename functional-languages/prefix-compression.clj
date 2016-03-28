; https://www.hackerrank.com/challenges/prefix-compression
(require '[clojure.string :as str])
(defn prefix-compression [str1 str2]
    (loop [a0 0 res1 [] res2 [] res3 []]
        (let [mlen (max (.length str1) (.length str2))]
            (if (< a0 mlen)
                (if (= (get str1 a0) (get str2 a0))
                    (recur (+ a0 1) (conj res1 (get str1 a0)) res2 res3)
                    (recur mlen res1 (subs str1 a0) (subs str2 a0))
                )
                (conj [] (str/join "" res1) (str/join "" res2) (str/join "" res3))
            )
        )
    )
)

(let [
    str1 (read-line)
    str2 (read-line)
    ]
    (doseq [i (prefix-compression str1 str2)] (println (str (.length i) " " i)))
)
