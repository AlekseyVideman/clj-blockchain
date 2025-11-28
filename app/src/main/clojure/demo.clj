(ns demo
  (:gen-class)
  (:require [training.blockchain :as chain]
            [training.payment-service :as pay]))

(defn -main []
  (pay/transfer "Владимир Путин" 1 "Алексей Видеман")
  (pay/transfer "Илон Маск" 1 "Алексей Видеман")
  (pay/transfer "Алексей Видеман" 2 "'на печенье'")

  (println "")
  (println "Blocks in chain:")
  (doseq [block chain/blockchain]
    (println block)))